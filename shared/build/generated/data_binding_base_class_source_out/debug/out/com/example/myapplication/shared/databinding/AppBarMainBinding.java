// Generated by view binder compiler. Do not edit!
package com.example.myapplication.shared.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.myapplication.shared.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class AppBarMainBinding implements ViewBinding {
  @NonNull
  private final CoordinatorLayout rootView;

  @NonNull
  public final ContentMainBinding contentMain;

  @NonNull
  public final CoordinatorLayout coordinatorLayout;

  /**
   * This binding is not available in all configurations.
   * <p>
   * Present:
   * <ul>
   *   <li>layout/</li>
   *   <li>layout-w600dp/</li>
   * </ul>
   *
   * Absent:
   * <ul>
   *   <li>layout-w1240dp/</li>
   * </ul>
   */
  @Nullable
  public final FloatingActionButton fab;

  @NonNull
  public final Toolbar toolbar;

  private AppBarMainBinding(@NonNull CoordinatorLayout rootView,
      @NonNull ContentMainBinding contentMain, @NonNull CoordinatorLayout coordinatorLayout,
      @Nullable FloatingActionButton fab, @NonNull Toolbar toolbar) {
    this.rootView = rootView;
    this.contentMain = contentMain;
    this.coordinatorLayout = coordinatorLayout;
    this.fab = fab;
    this.toolbar = toolbar;
  }

  @Override
  @NonNull
  public CoordinatorLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static AppBarMainBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static AppBarMainBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.app_bar_main, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static AppBarMainBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.content_main;
      View contentMain = ViewBindings.findChildViewById(rootView, id);
      if (contentMain == null) {
        break missingId;
      }
      ContentMainBinding binding_contentMain = ContentMainBinding.bind(contentMain);

      CoordinatorLayout coordinatorLayout = (CoordinatorLayout) rootView;

      id = R.id.fab;
      FloatingActionButton fab = ViewBindings.findChildViewById(rootView, id);

      id = R.id.toolbar;
      Toolbar toolbar = ViewBindings.findChildViewById(rootView, id);
      if (toolbar == null) {
        break missingId;
      }

      return new AppBarMainBinding((CoordinatorLayout) rootView, binding_contentMain,
          coordinatorLayout, fab, toolbar);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
