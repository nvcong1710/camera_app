package com.example.myapplication.shared;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.widget.TextView;
import androidx.camera.core.ImageAnalysis;
import androidx.camera.core.ImageProxy;
import org.pytorch.*;
import org.pytorch.torchvision.TensorImageUtils;
import java.nio.ByteBuffer;

public class ImageAnalyzer implements ImageAnalysis.Analyzer {
    private final Module model;
    private final TextView resultText;

    public ImageAnalyzer(Module model, TextView resultText) {
        this.model = model;
        this.resultText = resultText;
    }

    @Override
    public void analyze(ImageProxy image) {
        Bitmap bitmap = toBitmap(image);
        image.close();

        Tensor inputTensor = TensorImageUtils.bitmapToFloat32Tensor(bitmap,
                new float[]{0.485f, 0.456f, 0.406f},
                new float[]{0.229f, 0.224f, 0.225f});

        Tensor outputTensor = model.forward(IValue.from(inputTensor)).toTensor();
        float[] scores = outputTensor.getDataAsFloatArray();

        int predictedLabel = 0;
        for (int i = 1; i < scores.length; i++) {
            if (scores[i] > scores[predictedLabel]) {
                predictedLabel = i;
            }
        }

        int finalLabel = predictedLabel;
        resultText.post(() -> resultText.setText("Predicted: " + finalLabel));
    }

    private Bitmap toBitmap(ImageProxy image) {
        ByteBuffer buffer = image.getPlanes()[0].getBuffer();
        byte[] bytes = new byte[buffer.remaining()];
        buffer.get(bytes);
        return BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
    }
}