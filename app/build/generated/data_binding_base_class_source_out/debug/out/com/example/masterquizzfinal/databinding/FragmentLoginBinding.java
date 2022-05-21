// Generated by view binder compiler. Do not edit!
package com.example.masterquizzfinal.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Switch;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.masterquizzfinal.R;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentLoginBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final ImageView imageView;

  @NonNull
  public final TextInputEditText loginEmail;

  @NonNull
  public final Button loginEnter;

  @NonNull
  public final TextInputEditText loginPassword;

  @NonNull
  public final TextInputLayout loginPasswordLayout;

  @NonNull
  public final TextInputLayout loginUsernameLayout;

  @NonNull
  public final ProgressBar progressCircular;

  @NonNull
  public final Switch switchRemember;

  @NonNull
  public final TextView textView27;

  private FragmentLoginBinding(@NonNull ConstraintLayout rootView, @NonNull ImageView imageView,
      @NonNull TextInputEditText loginEmail, @NonNull Button loginEnter,
      @NonNull TextInputEditText loginPassword, @NonNull TextInputLayout loginPasswordLayout,
      @NonNull TextInputLayout loginUsernameLayout, @NonNull ProgressBar progressCircular,
      @NonNull Switch switchRemember, @NonNull TextView textView27) {
    this.rootView = rootView;
    this.imageView = imageView;
    this.loginEmail = loginEmail;
    this.loginEnter = loginEnter;
    this.loginPassword = loginPassword;
    this.loginPasswordLayout = loginPasswordLayout;
    this.loginUsernameLayout = loginUsernameLayout;
    this.progressCircular = progressCircular;
    this.switchRemember = switchRemember;
    this.textView27 = textView27;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentLoginBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentLoginBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_login, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentLoginBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.imageView;
      ImageView imageView = ViewBindings.findChildViewById(rootView, id);
      if (imageView == null) {
        break missingId;
      }

      id = R.id.login_email;
      TextInputEditText loginEmail = ViewBindings.findChildViewById(rootView, id);
      if (loginEmail == null) {
        break missingId;
      }

      id = R.id.login_enter;
      Button loginEnter = ViewBindings.findChildViewById(rootView, id);
      if (loginEnter == null) {
        break missingId;
      }

      id = R.id.login_password;
      TextInputEditText loginPassword = ViewBindings.findChildViewById(rootView, id);
      if (loginPassword == null) {
        break missingId;
      }

      id = R.id.login_password_layout;
      TextInputLayout loginPasswordLayout = ViewBindings.findChildViewById(rootView, id);
      if (loginPasswordLayout == null) {
        break missingId;
      }

      id = R.id.login_username_layout;
      TextInputLayout loginUsernameLayout = ViewBindings.findChildViewById(rootView, id);
      if (loginUsernameLayout == null) {
        break missingId;
      }

      id = R.id.progressCircular;
      ProgressBar progressCircular = ViewBindings.findChildViewById(rootView, id);
      if (progressCircular == null) {
        break missingId;
      }

      id = R.id.switch_remember;
      Switch switchRemember = ViewBindings.findChildViewById(rootView, id);
      if (switchRemember == null) {
        break missingId;
      }

      id = R.id.textView27;
      TextView textView27 = ViewBindings.findChildViewById(rootView, id);
      if (textView27 == null) {
        break missingId;
      }

      return new FragmentLoginBinding((ConstraintLayout) rootView, imageView, loginEmail,
          loginEnter, loginPassword, loginPasswordLayout, loginUsernameLayout, progressCircular,
          switchRemember, textView27);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
