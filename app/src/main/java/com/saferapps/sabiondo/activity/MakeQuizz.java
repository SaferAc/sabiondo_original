package com.saferapps.sabiondo.activity;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.saferapps.sabiondo.R;
import com.saferapps.sabiondo.helper.SessionHandler;
import com.saferapps.sabiondo.model.Question;
import com.saferapps.sabiondo.model.Quiz;
import com.saferapps.sabiondo.model.User;
import java.util.ArrayList;
import java.util.List;

public class MakeQuizz extends AppCompatActivity implements View.OnClickListener {
    private static final int ADD_QUESTION_REQUEST = 100;
    private static final int EDIT_QUESTION_REQUEST = 200;
    private TextView p1,p2,p3,p4,p5,p6,p7,p8,p9,p10;
    private EditText ed_title,ed_spc_school_level, ed_grade;
    private ChipGroup chipGroupGrade;
    private ChipGroup chipGroupTime;
    private ChipGroup chipGroupTrimester;
    private CardView btn_create,btn_addquestion;
    private LinearLayout spcs, spcgrade, linegrade;
    private Chip chip1,chip2,chip3,chip4,chip5,chip6,chip7,chip8,chip9,chip10,chip11,chip12,chip13,chip14,chip15;
    private int schoolgrade=0, time=0, trimester=0;
    private String title, school_level;
    private boolean gradeVisible=true;
    private boolean isElementary=true;
    private List<Question> questionList= new ArrayList<>();
    private int questioncount=0;
    private DatabaseReference quizReference;
    private String id;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_quizz);
        SessionHandler session = new SessionHandler(MakeQuizz.this);
        User user = session.getUserDetails();
        id= user.getuId();
        ed_title= findViewById(R.id.et_quiztitle);
        ed_grade= findViewById(R.id.et_spc_school_grade);
        linegrade=findViewById(R.id.line_grade);
        ed_spc_school_level= findViewById(R.id.et_spc_school_level);
        ChipGroup chipGroup_school_level = findViewById(R.id.chip_group_shool_level);
        chipGroupGrade= findViewById(R.id.chip_group_grade);
        chipGroupTime= findViewById(R.id.chip_group_time);
        btn_create= findViewById(R.id.btn_createquiz);
        btn_create.setVisibility(View.GONE);
        spcgrade= findViewById(R.id.line_spcgrade);
        spcs=findViewById(R.id.line_spc);
        spcs.setVisibility(View.GONE);
        spcgrade.setVisibility(View.GONE);
        chip1= findViewById(R.id.chip1);
        chip2= findViewById(R.id.chip2);
        chip3= findViewById(R.id.chip3);
        chip4= findViewById(R.id.chip4);
        chip5= findViewById(R.id.chip5);
        chip6= findViewById(R.id.chip6);
        chip7= findViewById(R.id.chip7);
        chip8= findViewById(R.id.chip8);
        chip9= findViewById(R.id.chip9);
        chip10= findViewById(R.id.chip10);
        chip11= findViewById(R.id.chip11);
        chip12= findViewById(R.id.chip12);
        chip13= findViewById(R.id.chip13);
        chip14= findViewById(R.id.chip14);
        chip15= findViewById(R.id.chip15);
        chipGroupTrimester= findViewById(R.id.chip_group_trimestre);
        btn_addquestion=findViewById(R.id.btn_addquestion);
        p1= findViewById(R.id.num_1);
        p2= findViewById(R.id.num_2);
        p3= findViewById(R.id.num_3);
        p4= findViewById(R.id.num_4);
        p5= findViewById(R.id.num_5);
        p6= findViewById(R.id.num_6);
        p7= findViewById(R.id.num_7);
        p8= findViewById(R.id.num_8);
        p9= findViewById(R.id.num_9);
        p10= findViewById(R.id.num_10);



        final int[] CLICKABLES = new int[]{R.id.num_1, R.id.num_2, R.id.num_3, R.id.num_4,R.id.num_5,
                R.id.num_6,R.id.num_7,R.id.num_8,R.id.num_9,R.id.num_10};





        for (int i : CLICKABLES) {
            findViewById(i).setOnClickListener(this);
        }








        chipGroup_school_level.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == R.id.chip1) {
                chip1.setChipBackgroundColor(ColorStateList.valueOf(getResources().getColor(android.R.color.holo_purple)));
                chip1.setTextColor(ColorStateList.valueOf(getResources().getColor(android.R.color.white)));
                chip2.setChipBackgroundColor(ColorStateList.valueOf(getResources().getColor(android.R.color.white)));
                chip2.setTextColor(ColorStateList.valueOf(getResources().getColor(android.R.color.holo_blue_light)));
                chip3.setChipBackgroundColor(ColorStateList.valueOf(getResources().getColor(android.R.color.white)));
                chip3.setTextColor(ColorStateList.valueOf(getResources().getColor(android.R.color.holo_red_light)));
                spcs.setVisibility(View.GONE);
                linegrade.setVisibility(View.VISIBLE);
                spcgrade.setVisibility(View.GONE);
                chip7.setVisibility(View.VISIBLE);
                chip8.setVisibility(View.VISIBLE);
                chip9.setVisibility(View.VISIBLE);
                gradeVisible = true;
                school_level = "Primaria";
                chipGroupGrade.clearCheck();
                chipGroupTrimester.clearCheck();
                chipGroupTime.clearCheck();
                isElementary = true;
            } else if (checkedId == R.id.chip2) {
                chip1.setChipBackgroundColor(ColorStateList.valueOf(getResources().getColor(android.R.color.white)));
                chip1.setTextColor(ColorStateList.valueOf(getResources().getColor(android.R.color.holo_purple)));
                chip2.setChipBackgroundColor(ColorStateList.valueOf(getResources().getColor(android.R.color.holo_blue_light)));
                chip2.setTextColor(ColorStateList.valueOf(getResources().getColor(android.R.color.white)));
                chip3.setChipBackgroundColor(ColorStateList.valueOf(getResources().getColor(android.R.color.white)));
                chip3.setTextColor(ColorStateList.valueOf(getResources().getColor(android.R.color.holo_red_light)));

                spcs.setVisibility(View.GONE);
                linegrade.setVisibility(View.VISIBLE);
                spcgrade.setVisibility(View.GONE);
                chip7.setVisibility(View.GONE);
                chip8.setVisibility(View.GONE);
                chip9.setVisibility(View.GONE);
                gradeVisible = true;
                school_level = "Secundaria";
                chipGroupGrade.clearCheck();
                chipGroupTrimester.clearCheck();
                chipGroupTime.clearCheck();
                isElementary = false;
            } else if (checkedId == R.id.chip3) {
                chip1.setChipBackgroundColor(ColorStateList.valueOf(getResources().getColor(android.R.color.white)));
                chip1.setTextColor(ColorStateList.valueOf(getResources().getColor(android.R.color.holo_purple)));
                chip2.setChipBackgroundColor(ColorStateList.valueOf(getResources().getColor(android.R.color.white)));
                chip2.setTextColor(ColorStateList.valueOf(getResources().getColor(android.R.color.holo_blue_light)));
                chip3.setChipBackgroundColor(ColorStateList.valueOf(getResources().getColor(android.R.color.holo_red_light)));
                chip3.setTextColor(ColorStateList.valueOf(getResources().getColor(android.R.color.white)));
                linegrade.setVisibility(View.GONE);
                spcs.setVisibility(View.VISIBLE);
                spcgrade.setVisibility(View.VISIBLE);
                chip7.setVisibility(View.VISIBLE);
                chip8.setVisibility(View.VISIBLE);
                chip9.setVisibility(View.VISIBLE);
                gradeVisible = false;
                school_level = "";
                chipGroupGrade.clearCheck();
                chipGroupTrimester.clearCheck();
                chipGroupTime.clearCheck();
            } else {
                chip1.setChipBackgroundColor(ColorStateList.valueOf(getResources().getColor(android.R.color.white)));
                chip1.setTextColor(ColorStateList.valueOf(getResources().getColor(android.R.color.holo_purple)));
                chip2.setChipBackgroundColor(ColorStateList.valueOf(getResources().getColor(android.R.color.white)));
                chip2.setTextColor(ColorStateList.valueOf(getResources().getColor(android.R.color.holo_blue_light)));
                chip3.setChipBackgroundColor(ColorStateList.valueOf(getResources().getColor(android.R.color.white)));
                chip3.setTextColor(ColorStateList.valueOf(getResources().getColor(android.R.color.holo_red_light)));
                spcs.setVisibility(View.GONE);
                linegrade.setVisibility(View.VISIBLE);
                spcgrade.setVisibility(View.GONE);
                chip7.setVisibility(View.VISIBLE);
                chip8.setVisibility(View.VISIBLE);
                chip9.setVisibility(View.VISIBLE);
                gradeVisible = true;
                school_level = "";
                chipGroupGrade.clearCheck();
                chipGroupTrimester.clearCheck();
                chipGroupTime.clearCheck();
            }
        });


        chipGroupGrade.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == R.id.chip4) {
                chip4.setChipBackgroundColor(ColorStateList.valueOf(getResources().getColor(android.R.color.holo_green_light)));
                chip4.setTextColor(ColorStateList.valueOf(getResources().getColor(android.R.color.white)));
                chip5.setChipBackgroundColor(ColorStateList.valueOf(getResources().getColor(android.R.color.white)));
                chip5.setTextColor(ColorStateList.valueOf(getResources().getColor(android.R.color.holo_orange_light)));
                chip6.setChipBackgroundColor(ColorStateList.valueOf(getResources().getColor(android.R.color.white)));
                chip6.setTextColor(ColorStateList.valueOf(getResources().getColor(android.R.color.holo_blue_light)));
                chip7.setChipBackgroundColor(ColorStateList.valueOf(getResources().getColor(android.R.color.white)));
                chip7.setTextColor(ColorStateList.valueOf(getResources().getColor(android.R.color.holo_orange_dark)));
                chip8.setChipBackgroundColor(ColorStateList.valueOf(getResources().getColor(android.R.color.white)));
                chip8.setTextColor(ColorStateList.valueOf(getResources().getColor(android.R.color.holo_purple)));
                chip9.setChipBackgroundColor(ColorStateList.valueOf(getResources().getColor(android.R.color.white)));
                chip9.setTextColor(ColorStateList.valueOf(getResources().getColor(android.R.color.holo_red_light)));
                schoolgrade = 1;
                if (!isElementary) {
                    schoolgrade = 7;
                }
            } else if (checkedId == R.id.chip5) {
                chip4.setChipBackgroundColor(ColorStateList.valueOf(getResources().getColor(android.R.color.white)));
                chip4.setTextColor(ColorStateList.valueOf(getResources().getColor(android.R.color.holo_green_light)));
                chip5.setChipBackgroundColor(ColorStateList.valueOf(getResources().getColor(android.R.color.holo_orange_light)));
                chip5.setTextColor(ColorStateList.valueOf(getResources().getColor(android.R.color.white)));
                chip6.setChipBackgroundColor(ColorStateList.valueOf(getResources().getColor(android.R.color.white)));
                chip6.setTextColor(ColorStateList.valueOf(getResources().getColor(android.R.color.holo_blue_light)));
                chip7.setChipBackgroundColor(ColorStateList.valueOf(getResources().getColor(android.R.color.white)));
                chip7.setTextColor(ColorStateList.valueOf(getResources().getColor(android.R.color.holo_orange_dark)));
                chip8.setChipBackgroundColor(ColorStateList.valueOf(getResources().getColor(android.R.color.white)));
                chip8.setTextColor(ColorStateList.valueOf(getResources().getColor(android.R.color.holo_purple)));
                chip9.setChipBackgroundColor(ColorStateList.valueOf(getResources().getColor(android.R.color.white)));
                chip9.setTextColor(ColorStateList.valueOf(getResources().getColor(android.R.color.holo_red_light)));
                schoolgrade = 2;
                if (!isElementary) {
                    schoolgrade = 8;
                }
            } else if (checkedId == R.id.chip6) {
                chip4.setChipBackgroundColor(ColorStateList.valueOf(getResources().getColor(android.R.color.white)));
                chip4.setTextColor(ColorStateList.valueOf(getResources().getColor(android.R.color.holo_green_light)));
                chip5.setChipBackgroundColor(ColorStateList.valueOf(getResources().getColor(android.R.color.white)));
                chip5.setTextColor(ColorStateList.valueOf(getResources().getColor(android.R.color.holo_orange_light)));
                chip6.setChipBackgroundColor(ColorStateList.valueOf(getResources().getColor(android.R.color.holo_blue_light)));
                chip6.setTextColor(ColorStateList.valueOf(getResources().getColor(android.R.color.white)));
                chip7.setChipBackgroundColor(ColorStateList.valueOf(getResources().getColor(android.R.color.white)));
                chip7.setTextColor(ColorStateList.valueOf(getResources().getColor(android.R.color.holo_orange_dark)));
                chip8.setChipBackgroundColor(ColorStateList.valueOf(getResources().getColor(android.R.color.white)));
                chip8.setTextColor(ColorStateList.valueOf(getResources().getColor(android.R.color.holo_purple)));
                chip9.setChipBackgroundColor(ColorStateList.valueOf(getResources().getColor(android.R.color.white)));
                chip9.setTextColor(ColorStateList.valueOf(getResources().getColor(android.R.color.holo_red_light)));

                schoolgrade = 3;
                if (!isElementary) {
                    schoolgrade = 9;
                }
            } else if (checkedId == R.id.chip7) {
                chip4.setChipBackgroundColor(ColorStateList.valueOf(getResources().getColor(android.R.color.white)));
                chip4.setTextColor(ColorStateList.valueOf(getResources().getColor(android.R.color.holo_green_light)));
                chip5.setChipBackgroundColor(ColorStateList.valueOf(getResources().getColor(android.R.color.white)));
                chip5.setTextColor(ColorStateList.valueOf(getResources().getColor(android.R.color.holo_orange_light)));
                chip6.setChipBackgroundColor(ColorStateList.valueOf(getResources().getColor(android.R.color.white)));
                chip6.setTextColor(ColorStateList.valueOf(getResources().getColor(android.R.color.holo_blue_light)));
                chip7.setChipBackgroundColor(ColorStateList.valueOf(getResources().getColor(android.R.color.holo_orange_dark)));
                chip7.setTextColor(ColorStateList.valueOf(getResources().getColor(android.R.color.white)));
                chip8.setChipBackgroundColor(ColorStateList.valueOf(getResources().getColor(android.R.color.white)));
                chip8.setTextColor(ColorStateList.valueOf(getResources().getColor(android.R.color.holo_purple)));
                chip9.setChipBackgroundColor(ColorStateList.valueOf(getResources().getColor(android.R.color.white)));
                chip9.setTextColor(ColorStateList.valueOf(getResources().getColor(android.R.color.holo_red_light)));
                schoolgrade = 4;
            } else if (checkedId == R.id.chip8) {
                chip4.setChipBackgroundColor(ColorStateList.valueOf(getResources().getColor(android.R.color.white)));
                chip4.setTextColor(ColorStateList.valueOf(getResources().getColor(android.R.color.holo_green_light)));
                chip5.setChipBackgroundColor(ColorStateList.valueOf(getResources().getColor(android.R.color.white)));
                chip5.setTextColor(ColorStateList.valueOf(getResources().getColor(android.R.color.holo_orange_light)));
                chip6.setChipBackgroundColor(ColorStateList.valueOf(getResources().getColor(android.R.color.white)));
                chip6.setTextColor(ColorStateList.valueOf(getResources().getColor(android.R.color.holo_blue_light)));
                chip7.setChipBackgroundColor(ColorStateList.valueOf(getResources().getColor(android.R.color.white)));
                chip7.setTextColor(ColorStateList.valueOf(getResources().getColor(android.R.color.holo_orange_dark)));
                chip8.setChipBackgroundColor(ColorStateList.valueOf(getResources().getColor(android.R.color.holo_purple)));
                chip8.setTextColor(ColorStateList.valueOf(getResources().getColor(android.R.color.white)));
                chip9.setChipBackgroundColor(ColorStateList.valueOf(getResources().getColor(android.R.color.white)));
                chip9.setTextColor(ColorStateList.valueOf(getResources().getColor(android.R.color.holo_red_light)));
                schoolgrade = 5;
            } else if (checkedId == R.id.chip9) {
                chip4.setChipBackgroundColor(ColorStateList.valueOf(getResources().getColor(android.R.color.white)));
                chip4.setTextColor(ColorStateList.valueOf(getResources().getColor(android.R.color.holo_green_light)));
                chip6.setChipBackgroundColor(ColorStateList.valueOf(getResources().getColor(android.R.color.white)));
                chip6.setTextColor(ColorStateList.valueOf(getResources().getColor(android.R.color.holo_blue_light)));
                chip5.setChipBackgroundColor(ColorStateList.valueOf(getResources().getColor(android.R.color.white)));
                chip5.setTextColor(ColorStateList.valueOf(getResources().getColor(android.R.color.holo_orange_light)));
                chip7.setChipBackgroundColor(ColorStateList.valueOf(getResources().getColor(android.R.color.white)));
                chip7.setTextColor(ColorStateList.valueOf(getResources().getColor(android.R.color.holo_orange_dark)));
                chip8.setChipBackgroundColor(ColorStateList.valueOf(getResources().getColor(android.R.color.white)));
                chip8.setTextColor(ColorStateList.valueOf(getResources().getColor(android.R.color.holo_purple)));
                chip9.setChipBackgroundColor(ColorStateList.valueOf(getResources().getColor(android.R.color.holo_red_light)));
                chip9.setTextColor(ColorStateList.valueOf(getResources().getColor(android.R.color.white)));
                schoolgrade = 6;
            } else {
                chip4.setChipBackgroundColor(ColorStateList.valueOf(getResources().getColor(android.R.color.white)));
                chip4.setTextColor(ColorStateList.valueOf(getResources().getColor(android.R.color.holo_green_light)));
                chip5.setChipBackgroundColor(ColorStateList.valueOf(getResources().getColor(android.R.color.white)));
                chip5.setTextColor(ColorStateList.valueOf(getResources().getColor(android.R.color.holo_orange_light)));
                chip6.setChipBackgroundColor(ColorStateList.valueOf(getResources().getColor(android.R.color.white)));
                chip6.setTextColor(ColorStateList.valueOf(getResources().getColor(android.R.color.holo_blue_light)));
                chip7.setChipBackgroundColor(ColorStateList.valueOf(getResources().getColor(android.R.color.white)));
                chip7.setTextColor(ColorStateList.valueOf(getResources().getColor(android.R.color.holo_orange_dark)));
                chip8.setChipBackgroundColor(ColorStateList.valueOf(getResources().getColor(android.R.color.white)));
                chip8.setTextColor(ColorStateList.valueOf(getResources().getColor(android.R.color.holo_purple)));
                chip9.setChipBackgroundColor(ColorStateList.valueOf(getResources().getColor(android.R.color.white)));
                chip9.setTextColor(ColorStateList.valueOf(getResources().getColor(android.R.color.holo_red_light)));
                schoolgrade = 0;
            }
        });

        chipGroupTime.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == R.id.chip10) {
                chip10.setChipBackgroundColor(ColorStateList.valueOf(getResources().getColor(android.R.color.holo_red_light)));
                chip10.setTextColor(ColorStateList.valueOf(getResources().getColor(android.R.color.white)));
                chip11.setChipBackgroundColor(ColorStateList.valueOf(getResources().getColor(android.R.color.white)));
                chip11.setTextColor(ColorStateList.valueOf(getResources().getColor(android.R.color.holo_blue_light)));
                chip12.setChipBackgroundColor(ColorStateList.valueOf(getResources().getColor(android.R.color.white)));
                chip12.setTextColor(ColorStateList.valueOf(getResources().getColor(android.R.color.holo_purple)));
                time = 30;
            } else if (checkedId == R.id.chip11) {
                chip10.setChipBackgroundColor(ColorStateList.valueOf(getResources().getColor(android.R.color.white)));
                chip10.setTextColor(ColorStateList.valueOf(getResources().getColor(android.R.color.holo_red_light)));
                chip11.setChipBackgroundColor(ColorStateList.valueOf(getResources().getColor(android.R.color.holo_blue_light)));
                chip11.setTextColor(ColorStateList.valueOf(getResources().getColor(android.R.color.white)));
                chip12.setChipBackgroundColor(ColorStateList.valueOf(getResources().getColor(android.R.color.white)));
                chip12.setTextColor(ColorStateList.valueOf(getResources().getColor(android.R.color.holo_purple)));
                time = 40;
            } else if (checkedId == R.id.chip12) {
                chip10.setChipBackgroundColor(ColorStateList.valueOf(getResources().getColor(android.R.color.white)));
                chip10.setTextColor(ColorStateList.valueOf(getResources().getColor(android.R.color.holo_red_light)));
                chip11.setChipBackgroundColor(ColorStateList.valueOf(getResources().getColor(android.R.color.white)));
                chip11.setTextColor(ColorStateList.valueOf(getResources().getColor(android.R.color.holo_blue_light)));
                chip12.setChipBackgroundColor(ColorStateList.valueOf(getResources().getColor(android.R.color.holo_purple)));
                chip12.setTextColor(ColorStateList.valueOf(getResources().getColor(android.R.color.white)));
                time = 99;
            } else {
                chip10.setChipBackgroundColor(ColorStateList.valueOf(getResources().getColor(android.R.color.white)));
                chip10.setTextColor(ColorStateList.valueOf(getResources().getColor(android.R.color.holo_red_light)));
                chip11.setChipBackgroundColor(ColorStateList.valueOf(getResources().getColor(android.R.color.white)));
                chip11.setTextColor(ColorStateList.valueOf(getResources().getColor(android.R.color.holo_blue_light)));
                chip12.setChipBackgroundColor(ColorStateList.valueOf(getResources().getColor(android.R.color.white)));
                chip12.setTextColor(ColorStateList.valueOf(getResources().getColor(android.R.color.holo_purple)));
                time = 0;
            }
        });
        chipGroupTrimester.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == R.id.chip13) {
                chip13.setChipBackgroundColor(ColorStateList.valueOf(getResources().getColor(android.R.color.holo_blue_bright)));
                chip13.setTextColor(ColorStateList.valueOf(getResources().getColor(android.R.color.white)));
                chip14.setChipBackgroundColor(ColorStateList.valueOf(getResources().getColor(android.R.color.white)));
                chip14.setTextColor(ColorStateList.valueOf(getResources().getColor(android.R.color.holo_orange_dark)));
                chip15.setChipBackgroundColor(ColorStateList.valueOf(getResources().getColor(android.R.color.white)));
                chip15.setTextColor(ColorStateList.valueOf(getResources().getColor(android.R.color.holo_green_dark)));
                trimester = 1;
            } else if (checkedId == R.id.chip14) {
                trimester = 2;
                chip13.setChipBackgroundColor(ColorStateList.valueOf(getResources().getColor(android.R.color.white)));
                chip13.setTextColor(ColorStateList.valueOf(getResources().getColor(android.R.color.holo_blue_bright)));
                chip14.setChipBackgroundColor(ColorStateList.valueOf(getResources().getColor(android.R.color.holo_orange_dark)));
                chip14.setTextColor(ColorStateList.valueOf(getResources().getColor(android.R.color.white)));
                chip15.setChipBackgroundColor(ColorStateList.valueOf(getResources().getColor(android.R.color.white)));
                chip15.setTextColor(ColorStateList.valueOf(getResources().getColor(android.R.color.holo_green_dark)));
            } else if (checkedId == R.id.chip15) {
                trimester = 3;
                chip13.setChipBackgroundColor(ColorStateList.valueOf(getResources().getColor(android.R.color.white)));
                chip13.setTextColor(ColorStateList.valueOf(getResources().getColor(android.R.color.holo_blue_bright)));
                chip14.setChipBackgroundColor(ColorStateList.valueOf(getResources().getColor(android.R.color.white)));
                chip14.setTextColor(ColorStateList.valueOf(getResources().getColor(android.R.color.holo_orange_dark)));
                chip15.setChipBackgroundColor(ColorStateList.valueOf(getResources().getColor(android.R.color.holo_green_dark)));
                chip15.setTextColor(ColorStateList.valueOf(getResources().getColor(android.R.color.white)));
            } else {
                chip13.setChipBackgroundColor(ColorStateList.valueOf(getResources().getColor(android.R.color.white)));
                chip13.setTextColor(ColorStateList.valueOf(getResources().getColor(android.R.color.holo_blue_bright)));
                chip14.setChipBackgroundColor(ColorStateList.valueOf(getResources().getColor(android.R.color.white)));
                chip14.setTextColor(ColorStateList.valueOf(getResources().getColor(android.R.color.holo_orange_dark)));
                chip15.setChipBackgroundColor(ColorStateList.valueOf(getResources().getColor(android.R.color.white)));
                chip15.setTextColor(ColorStateList.valueOf(getResources().getColor(android.R.color.holo_green_dark)));
                trimester = 0;
            }


        });
        btn_addquestion.setOnClickListener(v -> {
            Intent i = new Intent(this, AddEditQuestion.class);
            startActivityForResult(i, ADD_QUESTION_REQUEST);
        });

        btn_create.setOnClickListener(v -> {
            if(!gradeVisible){
                title= ed_title.getText().toString();
                school_level= ed_spc_school_level.getText().toString().trim();
                schoolgrade= Integer.parseInt(ed_grade.getText().toString().trim());
                if(school_level.isEmpty()||schoolgrade==0||title.isEmpty()){
                    Toast.makeText(this, "Faltan datos por agregar", Toast.LENGTH_SHORT).show();
                }
                else {
                    new AlertDialog.Builder(MakeQuizz.this)
                            .setTitle("Cuestionario Creado Exitosamente")
                            .setMessage("Al dar click en enviar, no podras editar el cuestionario, ¿Estas de acuerdo?")

                            // Specifying a listener allows you to take an action before dismissing the dialog.
                            // The dialog is automatically dismissed when a dialog button is clicked.
                            .setPositiveButton(android.R.string.yes, (dialog, which) -> writebigQuizz(title,school_level,schoolgrade,time,questionList))

                            // A null listener allows the button to dismiss the dialog and take no further action.
                            .setNegativeButton(android.R.string.no, null)
                            .show();

                }
            }else{
                title= ed_title.getText().toString();
                if(title.isEmpty()||schoolgrade==0||time==0||trimester==0||school_level.isEmpty()){
                    Toast.makeText(this, "Faltan datos por agregar", Toast.LENGTH_SHORT).show();
                }else{
                    new AlertDialog.Builder(MakeQuizz.this)
                            .setTitle("Cuestionario Creado Exitosamente")
                            .setMessage("Al dar click en enviar, no podras editar el cuestionario, ¿Estas de acuerdo?")

                            // Specifying a listener allows you to take an action before dismissing the dialog.
                            // The dialog is automatically dismissed when a dialog button is clicked.
                            .setPositiveButton(android.R.string.yes, (dialog, which) -> writeQuizz(title,school_level,schoolgrade,trimester,time,questionList))

                            // A null listener allows the button to dismiss the dialog and take no further action.
                            .setNegativeButton(android.R.string.no, null)
                            .show();

                }

            }


        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode==RESULT_OK){
            switch (requestCode){
                case ADD_QUESTION_REQUEST:
                    assert data != null;
                    String questiontext = data.getStringExtra(AddEditQuestion.QUESTIONTEXT);
                   String opt_a= data.getStringExtra(AddEditQuestion.OPT_A);
                   String opt_b= data.getStringExtra(AddEditQuestion.OPT_B);
                   String opt_c= data.getStringExtra(AddEditQuestion.OPT_C);
                   String opt_d= data.getStringExtra(AddEditQuestion.OPT_D);
                   String true_asn= data.getStringExtra(AddEditQuestion.TRUE_ANS);
                   String subject= data.getStringExtra(AddEditQuestion.SUBJECT);
                   String feedback= data.getStringExtra(AddEditQuestion.FEEDBACK);
                   String uri= data.getStringExtra(AddEditQuestion.URI);
                   Question question= new Question(questiontext,opt_a,opt_b,opt_c,opt_d,true_asn,subject,feedback,uri);
                   questionList.add(question);
                   questioncount++;
                   if (questioncount == 1) {
                       p1.setBackgroundResource(R.drawable.circle_finish);
                   } else if (questioncount == 2) {
                       p1.setBackgroundResource(R.drawable.circle_finish);
                       p2.setBackgroundResource(R.drawable.circle_finish);
                   } else if (questioncount == 3) {
                       p1.setBackgroundResource(R.drawable.circle_finish);
                       p2.setBackgroundResource(R.drawable.circle_finish);
                       p3.setBackgroundResource(R.drawable.circle_finish);
                   } else if (questioncount == 4) {
                       p1.setBackgroundResource(R.drawable.circle_finish);
                       p2.setBackgroundResource(R.drawable.circle_finish);
                       p3.setBackgroundResource(R.drawable.circle_finish);
                       p4.setBackgroundResource(R.drawable.circle_finish);
                   } else if (questioncount == 5) {
                       p1.setBackgroundResource(R.drawable.circle_finish);
                       p2.setBackgroundResource(R.drawable.circle_finish);
                       p3.setBackgroundResource(R.drawable.circle_finish);
                       p4.setBackgroundResource(R.drawable.circle_finish);
                       p5.setBackgroundResource(R.drawable.circle_finish);
                   } else if (questioncount == 6) {
                       p1.setBackgroundResource(R.drawable.circle_finish);
                       p2.setBackgroundResource(R.drawable.circle_finish);
                       p3.setBackgroundResource(R.drawable.circle_finish);
                       p4.setBackgroundResource(R.drawable.circle_finish);
                       p5.setBackgroundResource(R.drawable.circle_finish);
                       p6.setBackgroundResource(R.drawable.circle_finish);
                   } else if (questioncount == 7) {
                       p1.setBackgroundResource(R.drawable.circle_finish);
                       p2.setBackgroundResource(R.drawable.circle_finish);
                       p3.setBackgroundResource(R.drawable.circle_finish);
                       p4.setBackgroundResource(R.drawable.circle_finish);
                       p5.setBackgroundResource(R.drawable.circle_finish);
                       p6.setBackgroundResource(R.drawable.circle_finish);
                       p7.setBackgroundResource(R.drawable.circle_finish);
                   } else if (questioncount == 8) {
                       p1.setBackgroundResource(R.drawable.circle_finish);
                       p2.setBackgroundResource(R.drawable.circle_finish);
                       p3.setBackgroundResource(R.drawable.circle_finish);
                       p4.setBackgroundResource(R.drawable.circle_finish);
                       p5.setBackgroundResource(R.drawable.circle_finish);
                       p6.setBackgroundResource(R.drawable.circle_finish);
                       p7.setBackgroundResource(R.drawable.circle_finish);
                       p8.setBackgroundResource(R.drawable.circle_finish);
                   } else if (questioncount == 9) {
                       p1.setBackgroundResource(R.drawable.circle_finish);
                       p2.setBackgroundResource(R.drawable.circle_finish);
                       p3.setBackgroundResource(R.drawable.circle_finish);
                       p4.setBackgroundResource(R.drawable.circle_finish);
                       p5.setBackgroundResource(R.drawable.circle_finish);
                       p6.setBackgroundResource(R.drawable.circle_finish);
                       p7.setBackgroundResource(R.drawable.circle_finish);
                       p8.setBackgroundResource(R.drawable.circle_finish);
                       p9.setBackgroundResource(R.drawable.circle_finish);
                   } else if (questioncount == 10) {
                       p1.setBackgroundResource(R.drawable.circle_finish);
                       p2.setBackgroundResource(R.drawable.circle_finish);
                       p3.setBackgroundResource(R.drawable.circle_finish);
                       p4.setBackgroundResource(R.drawable.circle_finish);
                       p5.setBackgroundResource(R.drawable.circle_finish);
                       p6.setBackgroundResource(R.drawable.circle_finish);
                       p7.setBackgroundResource(R.drawable.circle_finish);
                       p8.setBackgroundResource(R.drawable.circle_finish);
                       p9.setBackgroundResource(R.drawable.circle_finish);
                       p10.setBackgroundResource(R.drawable.circle_finish);
                       startfirebase();
                       btn_create.setVisibility(View.VISIBLE);
                       btn_addquestion.setVisibility(View.GONE);
                   }
                    break;
                case EDIT_QUESTION_REQUEST:
                    break;
            }
        }

    }

    @Override
    public void onClick(View v) {
        int viewId = v.getId();
        if (viewId == R.id.num_1) {
            int questionIndex = 1;
            editQuestion(questionIndex);
        } else if (viewId == R.id.num_2) {
            int questionIndex = 2;
            editQuestion(questionIndex);
        } else if (viewId == R.id.num_3) {
            int questionIndex = 3;
            editQuestion(questionIndex);
        } else if (viewId == R.id.num_4) {
            int questionIndex = 4;
            editQuestion(questionIndex);
        } else if (viewId == R.id.num_5) {
            int questionIndex = 5;
            editQuestion(questionIndex);
        } else if (viewId == R.id.num_6) {
            int questionIndex = 6;
            editQuestion(questionIndex);
        } else if (viewId == R.id.num_7) {
            int questionIndex = 7;
            editQuestion(questionIndex);
        } else if (viewId == R.id.num_8) {
            int questionIndex = 8;
            editQuestion(questionIndex);
        } else if (viewId == R.id.num_9) {
            int questionIndex = 9;
            editQuestion(questionIndex);
        } else if (viewId == R.id.num_10) {
            int questionIndex = 10;
            editQuestion(questionIndex);
        }
    }

    public void editQuestion(int index) {
        if(questionList.size()<index){
            Toast.makeText(MakeQuizz.this, "La pregunta no se ha elaborado", Toast.LENGTH_SHORT).show();
            return;
        }
        Question question = questionList.get(index-1);
        Intent intent = new Intent(this, AddEditQuestion.class);
        intent.putExtra(AddEditQuestion.QUESTIONTEXT, question.getQuestion_text());
        intent.putExtra(AddEditQuestion.OPT_A, question.getOption_a());
        intent.putExtra(AddEditQuestion.OPT_B, question.getOption_b());
        intent.putExtra(AddEditQuestion.OPT_C, question.getOption_c());
        intent.putExtra(AddEditQuestion.OPT_D, question.getOption_d());
        intent.putExtra(AddEditQuestion.TRUE_ANS, question.getTrue_option());
        intent.putExtra(AddEditQuestion.SUBJECT, question.getSubject());
        intent.putExtra(AddEditQuestion.FEEDBACK, question.getFeedback());
        intent.putExtra(AddEditQuestion.URI, question.getUri());
        startActivityForResult(intent, EDIT_QUESTION_REQUEST);
    }
   /* @Override
    public boolean dispatchTouchEvent(MotionEvent event) {

        View v = getCurrentFocus();
        boolean ret = super.dispatchTouchEvent(event);

        if (v instanceof EditText) {
            View w = getCurrentFocus();
            int[] scrcoords = new int[2];
            assert w != null;
            w.getLocationOnScreen(scrcoords);
            float x = event.getRawX() + w.getLeft() - scrcoords[0];
            float y = event.getRawY() + w.getTop() - scrcoords[1];

            //Log.d("Activity", "Touch event "+event.getRawX()+","+event.getRawY()+" "+x+","+y+" rect "+w.getLeft()+","+w.getTop()+","+w.getRight()+","+w.getBottom()+" coords "+scrcoords[0]+","+scrcoords[1]);
            if (event.getAction() == MotionEvent.ACTION_UP && (x < w.getLeft() || x >= w.getRight() || y < w.getTop() || y > w.getBottom()) ) {

                InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                assert imm != null;
                imm.hideSoftInputFromWindow(Objects.requireNonNull(getWindow().getCurrentFocus()).getWindowToken(), 0);
            }
        }
        return ret;
    }*/
    private void startfirebase(){
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        quizReference= database.getReference();

    }
    private void writeQuizz(String title, String school_level, int grade, int trimester, int time, List<Question> question_list){
        Quiz quiz= new Quiz(title,school_level,grade,trimester,time,question_list,0,id);
        DatabaseReference quizlist= quizReference.child("Quizlist");
        DatabaseReference newQuizref=quizlist.push();
        newQuizref.setValue(quiz).addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                Toast.makeText(MakeQuizz.this, "Cuestionario Creado", Toast.LENGTH_SHORT).show();
                finish();
            } else {
                Toast.makeText(MakeQuizz.this, "Hubo un error al guardar el cuestionario", Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void writebigQuizz(String title, String school_level, int grade, int time, List<Question> question_list){
        Quiz quiz= new Quiz(title,school_level,grade,time,question_list,0,id);
        DatabaseReference quizlist= quizReference.child("Quizlist");
        DatabaseReference newQuizref=quizlist.push();
        newQuizref.setValue(quiz).addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                Toast.makeText(MakeQuizz.this, "Cuestionario Creado", Toast.LENGTH_SHORT).show();

                finish();
            } else {
                Toast.makeText(MakeQuizz.this, "Hubo un error al guardar el cuestionario", Toast.LENGTH_SHORT).show();

            }
        });
    }


    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setTitle("Cambios no guardados")
                .setMessage("¿Desea perder los cambios?")

                // Specifying a listener allows you to take an action before dismissing the dialog.
                // The dialog is automatically dismissed when a dialog button is clicked.
                .setPositiveButton(android.R.string.yes, (dialog, which) -> {

                    MakeQuizz.super.onBackPressed();
                })

                // A null listener allows the button to dismiss the dialog and take no further action.
                .setNegativeButton(android.R.string.no, null)
                .show();
    }


}
