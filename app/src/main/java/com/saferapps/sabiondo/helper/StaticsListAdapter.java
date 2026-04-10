package com.saferapps.sabiondo.helper;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.cardview.widget.CardView;

import com.google.android.material.card.MaterialCardView;
import com.saferapps.sabiondo.R;

import java.util.ArrayList;

public class StaticsListAdapter extends BaseAdapter {
    private Context mContext;
    private ArrayList<String> grade;
    private ArrayList<Integer> level;

    public StaticsListAdapter(Context context, ArrayList<String> grade,ArrayList<Integer> level){
            this.mContext= context;
            this.grade= grade;
            this.level= level;
    }


    @Override
    public int getCount() {
        return grade.size();
    }

    @Override
    public Object getItem(int position) {
        return this.grade.get(position);
    }

    @Override
    public long getItemId(int id) {
        return id;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);

        v= layoutInflater.inflate(R.layout.stadistics_item, null);
        // Valor actual según la posición

        String currentGrade  = grade.get(position);
        int currentLevel = level.get(position);

        // Referenciamos el elemento a modificar y lo rellenamos
        TextView completed= v.findViewById(R.id.completedlevel);
        TextView grade =  v.findViewById(R.id.tv_grade_stc);
        TextView level =  v.findViewById(R.id.tv_level_statics);

        grade.setText(currentGrade);
        switch (position){
            case 0: grade.setTextColor(mContext.getResources().getColor(android.R.color.holo_green_light));
                break;
            case 1: grade.setTextColor(mContext.getResources().getColor(android.R.color.holo_green_light));
                completed.setText("Aciertos");
                break;
            case 2: grade.setTextColor(mContext.getResources().getColor(android.R.color.holo_orange_light));
                break;
            case 3: grade.setTextColor(mContext.getResources().getColor(android.R.color.holo_orange_light));
                completed.setText("Aciertos");
                break;
            case 4: grade.setTextColor(mContext.getResources().getColor(android.R.color.holo_blue_light));
                break;
            case 5: grade.setTextColor(mContext.getResources().getColor(android.R.color.holo_blue_light));
                completed.setText("Aciertos");
                break;
            case 6: grade.setTextColor(mContext.getResources().getColor(android.R.color.holo_orange_dark));
                break;
            case 7: grade.setTextColor(mContext.getResources().getColor(android.R.color.holo_orange_dark));
                completed.setText("Aciertos");
                break;
            case 8: grade.setTextColor(mContext.getResources().getColor(android.R.color.holo_purple));
                break;
            case 9: grade.setTextColor(mContext.getResources().getColor(android.R.color.holo_purple));
                completed.setText("Aciertos");
                break;
            case 10: grade.setTextColor(mContext.getResources().getColor(android.R.color.holo_red_dark));
                break;
            case 11: grade.setTextColor(mContext.getResources().getColor(android.R.color.holo_red_dark));
                completed.setText("Aciertos");
                break;
            case 12:
                completed.setText("Total de Aciertos");
                break;
            case 13:
                completed.setText("Puntaje Total");
                break;
        }
        level.setText(String.valueOf(currentLevel));
        if(currentLevel>=1&&currentLevel<=10){
            level.setTextColor(mContext.getResources().getColor(android.R.color.holo_orange_dark));
        }
        if(currentLevel>=11&&currentLevel<=20){
            level.setTextColor(mContext.getResources().getColor(android.R.color.holo_orange_light));
        }

        if(currentLevel>=21&&currentLevel<=30){
            level.setTextColor(mContext.getResources().getColor(android.R.color.holo_blue_light));
        }
        if(currentLevel>=31&&currentLevel<=99){
            level.setTextColor(mContext.getResources().getColor(android.R.color.holo_green_light));
        }


        return v;
    }
}
