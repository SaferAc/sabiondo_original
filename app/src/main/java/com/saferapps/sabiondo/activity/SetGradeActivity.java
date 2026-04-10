package com.saferapps.sabiondo.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.saferapps.sabiondo.R;

import com.saferapps.sabiondo.helper.HorizontalFlipTransformation;

import java.util.ArrayList;
import java.util.List;

public class SetGradeActivity extends AppCompatActivity {

    ViewPager2 viewPager2;
    HorizontalFlipTransformation transformer;
    ViewPagerAdapter viewPagerAdapter;
    Intent intent;
    Activity activity;
    Context mcontext;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_grade);
        mcontext= getApplicationContext();
        transformer = new HorizontalFlipTransformation();
        viewPager2 = findViewById(R.id.viewpager);
        intent = getIntent();
        activity= this;



        List<String> list = new ArrayList<>();
        list.add("Primer Grado");
        list.add("Segundo Grado");
        list.add("Tercer Grado");
        list.add("Cuarto Grado");
        list.add("Quinto Grado");
        list.add("Sexto Grado");
        viewPagerAdapter = new ViewPagerAdapter(this, list, viewPager2, intent,activity);
        viewPager2.setAdapter(viewPagerAdapter);
        viewPager2.setPageTransformer(transformer);



    }
}

