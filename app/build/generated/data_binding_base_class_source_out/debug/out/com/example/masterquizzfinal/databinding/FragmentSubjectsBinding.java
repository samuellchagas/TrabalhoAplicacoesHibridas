// Generated by view binder compiler. Do not edit!
package com.example.masterquizzfinal.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.masterquizzfinal.R;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentSubjectsBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final ExtendedFloatingActionButton altA;

  @NonNull
  public final ExtendedFloatingActionButton altB;

  @NonNull
  public final ExtendedFloatingActionButton altC;

  @NonNull
  public final ExtendedFloatingActionButton altD;

  @NonNull
  public final CardView backgroundQuestion;

  @NonNull
  public final ExtendedFloatingActionButton btnConfirm;

  @NonNull
  public final TextView pointsScoreText;

  @NonNull
  public final TextView questText;

  @NonNull
  public final TextView scoreText;

  @NonNull
  public final Toolbar toolbar;

  private FragmentSubjectsBinding(@NonNull ConstraintLayout rootView,
      @NonNull ExtendedFloatingActionButton altA, @NonNull ExtendedFloatingActionButton altB,
      @NonNull ExtendedFloatingActionButton altC, @NonNull ExtendedFloatingActionButton altD,
      @NonNull CardView backgroundQuestion, @NonNull ExtendedFloatingActionButton btnConfirm,
      @NonNull TextView pointsScoreText, @NonNull TextView questText, @NonNull TextView scoreText,
      @NonNull Toolbar toolbar) {
    this.rootView = rootView;
    this.altA = altA;
    this.altB = altB;
    this.altC = altC;
    this.altD = altD;
    this.backgroundQuestion = backgroundQuestion;
    this.btnConfirm = btnConfirm;
    this.pointsScoreText = pointsScoreText;
    this.questText = questText;
    this.scoreText = scoreText;
    this.toolbar = toolbar;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentSubjectsBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentSubjectsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_subjects, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentSubjectsBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.alt_a;
      ExtendedFloatingActionButton altA = ViewBindings.findChildViewById(rootView, id);
      if (altA == null) {
        break missingId;
      }

      id = R.id.alt_b;
      ExtendedFloatingActionButton altB = ViewBindings.findChildViewById(rootView, id);
      if (altB == null) {
        break missingId;
      }

      id = R.id.alt_c;
      ExtendedFloatingActionButton altC = ViewBindings.findChildViewById(rootView, id);
      if (altC == null) {
        break missingId;
      }

      id = R.id.alt_d;
      ExtendedFloatingActionButton altD = ViewBindings.findChildViewById(rootView, id);
      if (altD == null) {
        break missingId;
      }

      id = R.id.background_question;
      CardView backgroundQuestion = ViewBindings.findChildViewById(rootView, id);
      if (backgroundQuestion == null) {
        break missingId;
      }

      id = R.id.btn_confirm;
      ExtendedFloatingActionButton btnConfirm = ViewBindings.findChildViewById(rootView, id);
      if (btnConfirm == null) {
        break missingId;
      }

      id = R.id.points_score_text;
      TextView pointsScoreText = ViewBindings.findChildViewById(rootView, id);
      if (pointsScoreText == null) {
        break missingId;
      }

      id = R.id.quest_text;
      TextView questText = ViewBindings.findChildViewById(rootView, id);
      if (questText == null) {
        break missingId;
      }

      id = R.id.score_text;
      TextView scoreText = ViewBindings.findChildViewById(rootView, id);
      if (scoreText == null) {
        break missingId;
      }

      id = R.id.toolbar;
      Toolbar toolbar = ViewBindings.findChildViewById(rootView, id);
      if (toolbar == null) {
        break missingId;
      }

      return new FragmentSubjectsBinding((ConstraintLayout) rootView, altA, altB, altC, altD,
          backgroundQuestion, btnConfirm, pointsScoreText, questText, scoreText, toolbar);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}