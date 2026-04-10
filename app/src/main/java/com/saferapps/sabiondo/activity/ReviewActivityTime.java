package com.saferapps.sabiondo.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;


import com.google.android.material.card.MaterialCardView;
import com.saferapps.sabiondo.R;
import com.saferapps.sabiondo.fragment.FragmentComunityQuiz;
import com.saferapps.sabiondo.fragment.FragmentPlay;
import com.saferapps.sabiondo.fragment.FragmentPlayTime;
import com.saferapps.sabiondo.model.Review;

import java.util.ArrayList;
import java.util.Collections;

public class ReviewActivityTime extends AppCompatActivity {
    public MaterialCardView cardView_A, cardView_B, cardView_C, cardView_D;
    public TextView txtQuestion, btnOpt1, btnOpt2, btnOpt3, btnOpt4, tvLevel, tvQuestionNo;
    public ImageView prev, next;
    public RelativeLayout layout_A, layout_B, layout_C, layout_D;
    private int questionIndex = 0;
    // QuizLevel level;
    private int NO_OF_QUESTION;
    private View playagain;


    public ArrayList<Review> reviews = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);



        playagain = findViewById(R.id.btn_playagainreview);
        btnOpt1 = findViewById(R.id.btnOpt1);
        btnOpt2 = findViewById(R.id.btnOpt2);
        btnOpt3 = findViewById(R.id.btnOpt3);
        btnOpt4 = findViewById(R.id.btnOpt4);
        cardView_A = findViewById(R.id.cardView_A);
        cardView_B = findViewById(R.id.cardView_B);
        cardView_C = findViewById(R.id.cardView_C);
        cardView_D = findViewById(R.id.cardView_D);
        txtQuestion = findViewById(R.id.question);
        layout_A = findViewById(R.id.a_layout);
        layout_B = findViewById(R.id.b_layout);
        layout_C = findViewById(R.id.c_layout);
        layout_D = findViewById(R.id.d_layout);
        prev = findViewById(R.id.prev);
        next = findViewById(R.id.next);
        tvQuestionNo = findViewById(R.id.questionNo);
        reviews = FragmentPlayTime.reviewspt;
        NO_OF_QUESTION = reviews.size();
        ReviewQuestion();
        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (questionIndex > 0) {
                    questionIndex--;
                    ReviewQuestion();
                }

            }
        });

        playagain.setOnClickListener(v -> {

            finish();
        });

        next.setOnClickListener(view -> {
            if (questionIndex < (reviews.size() - 1)) {
                System.out.println("*** no " + questionIndex);
                questionIndex++;

                ReviewQuestion();

            }

        });

    }

    public void ReviewQuestion() {
        if (questionIndex < reviews.size()) {
            int temp = questionIndex;


            txtQuestion.setText(reviews.get(questionIndex).getQuestion());
            ArrayList<String> options = new ArrayList<String>();
            options.addAll(reviews.get(questionIndex).getOptionList());
            Collections.shuffle(options);
            btnOpt1.setText("" + options.get(0).trim());
            btnOpt2.setText("" + options.get(1).trim());
            btnOpt3.setText("" + options.get(2).trim());
            btnOpt4.setText("" + options.get(3).trim());
            tvQuestionNo.setText(" " + (questionIndex + 1) + "/" + reviews.size());

            if (btnOpt1.getText().toString().trim().equalsIgnoreCase(reviews.get(questionIndex).getRightAns().trim())) {

                layout_A.setBackgroundResource(R.drawable.right_gradient);
                layout_B.setBackgroundResource(R.drawable.bg_gradient);
                layout_C.setBackgroundResource(R.drawable.bg_gradient);
                layout_D.setBackgroundResource(R.drawable.bg_gradient);
                if (btnOpt2.getText().toString().trim().equalsIgnoreCase(reviews.get(questionIndex).getWrongAns())) {
                    layout_B.setBackgroundResource(R.drawable.wrong_gradient);
                    // layout_A.setBackgroundResource(R.drawable.bg_gradient);
                    layout_C.setBackgroundResource(R.drawable.bg_gradient);
                    layout_D.setBackgroundResource(R.drawable.bg_gradient);
                } else if (btnOpt3.getText().toString().trim().equalsIgnoreCase(reviews.get(questionIndex).getWrongAns())) {
                    layout_C.setBackgroundResource(R.drawable.wrong_gradient);
                    //  layout_A.setBackgroundResource(R.drawable.bg_gradient);
                    layout_B.setBackgroundResource(R.drawable.bg_gradient);
                    layout_D.setBackgroundResource(R.drawable.bg_gradient);
                } else if (btnOpt4.getText().toString().trim().equalsIgnoreCase(reviews.get(questionIndex).getWrongAns())) {
                    layout_D.setBackgroundResource(R.drawable.wrong_gradient);
                    //   layout_A.setBackgroundResource(R.drawable.bg_gradient);
                    layout_B.setBackgroundResource(R.drawable.bg_gradient);
                    layout_C.setBackgroundResource(R.drawable.bg_gradient);
                }

            } else if (btnOpt2.getText().toString().trim().equalsIgnoreCase(reviews.get(questionIndex).getRightAns().trim())) {

                layout_B.setBackgroundResource(R.drawable.right_gradient);
                layout_A.setBackgroundResource(R.drawable.bg_gradient);
                layout_C.setBackgroundResource(R.drawable.bg_gradient);
                layout_D.setBackgroundResource(R.drawable.bg_gradient);
                if (btnOpt1.getText().toString().trim().equalsIgnoreCase(reviews.get(questionIndex).getWrongAns())) {
                    layout_A.setBackgroundResource(R.drawable.wrong_gradient);
                    // layout_B.setBackgroundResource(R.drawable.bg_gradient);
                    layout_C.setBackgroundResource(R.drawable.bg_gradient);
                    layout_D.setBackgroundResource(R.drawable.bg_gradient);
                } else if (btnOpt3.getText().toString().trim().equalsIgnoreCase(reviews.get(questionIndex).getWrongAns())) {
                    layout_C.setBackgroundResource(R.drawable.wrong_gradient);
                    layout_A.setBackgroundResource(R.drawable.bg_gradient);
                    //  layout_B.setBackgroundResource(R.drawable.bg_gradient);
                    layout_D.setBackgroundResource(R.drawable.bg_gradient);
                } else if (btnOpt4.getText().toString().trim().equalsIgnoreCase(reviews.get(questionIndex).getWrongAns())) {
                    layout_D.setBackgroundResource(R.drawable.wrong_gradient);
                    layout_A.setBackgroundResource(R.drawable.bg_gradient);
                    // layout_B.setBackgroundResource(R.drawable.bg_gradient);
                    layout_C.setBackgroundResource(R.drawable.bg_gradient);
                }

            } else if (btnOpt3.getText().toString().trim().equalsIgnoreCase(reviews.get(questionIndex).getRightAns().trim())) {

                layout_C.setBackgroundResource(R.drawable.right_gradient);
                layout_A.setBackgroundResource(R.drawable.bg_gradient);
                layout_B.setBackgroundResource(R.drawable.bg_gradient);
                layout_D.setBackgroundResource(R.drawable.bg_gradient);
                if (btnOpt1.getText().toString().trim().equalsIgnoreCase(reviews.get(questionIndex).getWrongAns())) {
                    layout_A.setBackgroundResource(R.drawable.wrong_gradient);
                    layout_B.setBackgroundResource(R.drawable.bg_gradient);
                    // layout_C.setBackgroundResource(R.drawable.bg_gradient);
                    layout_D.setBackgroundResource(R.drawable.bg_gradient);
                } else if (btnOpt2.getText().toString().trim().equalsIgnoreCase(reviews.get(questionIndex).getWrongAns())) {
                    layout_B.setBackgroundResource(R.drawable.wrong_gradient);
                    layout_A.setBackgroundResource(R.drawable.bg_gradient);
                    // layout_C.setBackgroundResource(R.drawable.bg_gradient);
                    layout_D.setBackgroundResource(R.drawable.bg_gradient);
                } else if (btnOpt4.getText().toString().trim().equalsIgnoreCase(reviews.get(questionIndex).getWrongAns())) {
                    layout_D.setBackgroundResource(R.drawable.wrong_gradient);
                    layout_A.setBackgroundResource(R.drawable.bg_gradient);
                    layout_B.setBackgroundResource(R.drawable.bg_gradient);
                    //  layout_C.setBackgroundResource(R.drawable.bg_gradient);
                }

            } else if (btnOpt4.getText().toString().trim().equalsIgnoreCase(reviews.get(questionIndex).getRightAns().trim())) {

                layout_D.setBackgroundResource(R.drawable.right_gradient);
                layout_A.setBackgroundResource(R.drawable.bg_gradient);
                layout_C.setBackgroundResource(R.drawable.bg_gradient);
                layout_B.setBackgroundResource(R.drawable.bg_gradient);
                if (btnOpt1.getText().toString().trim().equalsIgnoreCase(reviews.get(questionIndex).getWrongAns())) {
                    layout_A.setBackgroundResource(R.drawable.wrong_gradient);
                    layout_B.setBackgroundResource(R.drawable.bg_gradient);
                    layout_C.setBackgroundResource(R.drawable.bg_gradient);
                    // layout_D.setBackgroundResource(R.drawable.bg_gradient);
                } else if (btnOpt2.getText().toString().trim().equalsIgnoreCase(reviews.get(questionIndex).getWrongAns())) {
                    layout_B.setBackgroundResource(R.drawable.wrong_gradient);
                    layout_A.setBackgroundResource(R.drawable.bg_gradient);
                    layout_C.setBackgroundResource(R.drawable.bg_gradient);
                    // layout_D.setBackgroundResource(R.drawable.bg_gradient);
                } else if (btnOpt3.getText().toString().trim().equalsIgnoreCase(reviews.get(questionIndex).getWrongAns())) {
                    layout_C.setBackgroundResource(R.drawable.wrong_gradient);
                    layout_A.setBackgroundResource(R.drawable.bg_gradient);
                    layout_B.setBackgroundResource(R.drawable.bg_gradient);
                    //layout_D.setBackgroundResource(R.drawable.bg_gradient);
                }

            }
        }

    }
}
