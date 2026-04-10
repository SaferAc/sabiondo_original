package com.saferapps.sabiondo.fragment;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.saferapps.sabiondo.R;
import com.saferapps.sabiondo.helper.SettingsPreferences;
import com.saferapps.sabiondo.helper.StaticsListAdapter;

import java.util.ArrayList;


public class StadisticsFragment extends Fragment {

    private Context mContext;
    private ListView listview;
    private ArrayList<String> grade;
    private ArrayList<Integer> level;


    public StadisticsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        mContext = getContext();
        View v = inflater.inflate(R.layout.fragment_stadistics, container, false);

        level= new ArrayList<>();
        level.add(SettingsPreferences.getNoCompletedLevel(mContext,1));
        level.add(SettingsPreferences.getQuestionRecord(mContext,1));
        level.add(SettingsPreferences.getNoCompletedLevel(mContext,2));
        level.add(SettingsPreferences.getQuestionRecord(mContext,2));
        level.add(SettingsPreferences.getNoCompletedLevel(mContext,3));
        level.add(SettingsPreferences.getQuestionRecord(mContext,3));
        level.add(SettingsPreferences.getNoCompletedLevel(mContext,4));
        level.add(SettingsPreferences.getQuestionRecord(mContext,4));
        level.add(SettingsPreferences.getNoCompletedLevel(mContext,5));
        level.add(SettingsPreferences.getQuestionRecord(mContext,5));
        level.add(SettingsPreferences.getNoCompletedLevel(mContext,6));
        level.add(SettingsPreferences.getQuestionRecord(mContext,6));
        level.add(SettingsPreferences.getRightAns(mContext));
        level.add(SettingsPreferences.getPoint(mContext));


        grade= new ArrayList<>();
        grade.add("Primer Grado");
        grade.add("Record:");
        grade.add("Segundo Grado");
        grade.add("Record:");
        grade.add("Tercer Grado");
        grade.add("Record:");
        grade.add("Cuarto Grado");
        grade.add("Record:");
        grade.add("Quinto Grado");
        grade.add("Record:");
        grade.add("Sexto Grado");
        grade.add("Record:");
        grade.add("Aciertos:");
        grade.add("Puntos:");
        listview =  v.findViewById(R.id.stadisticslist);

        StaticsListAdapter adapter = new StaticsListAdapter(mContext, grade,level);
        listview.setAdapter(adapter);



        return v;
    }
}
