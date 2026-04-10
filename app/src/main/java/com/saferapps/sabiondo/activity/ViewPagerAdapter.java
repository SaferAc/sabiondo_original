package com.saferapps.sabiondo.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.airbnb.lottie.LottieAnimationView;
import com.saferapps.sabiondo.Constant;
import com.saferapps.sabiondo.R;
import com.saferapps.sabiondo.helper.SettingsPreferences;

import java.util.List;



public class ViewPagerAdapter extends RecyclerView.Adapter<ViewPagerAdapter.ViewHolder> {

    private List<String> mData;
    private LayoutInflater mInflater;
    private ViewPager2 viewPager2;
    private Context mcontext;
    private Intent intent;
    private Activity activity;




// android. , ,
    private int[] colorArray = new int[]{android.R.color.holo_green_light,android.R.color.holo_orange_light, android.R.color.holo_blue_light,android.R.color.holo_orange_dark,
            android.R.color.holo_purple, android.R.color.holo_red_dark};
    ViewPagerAdapter(Context context, List<String> data, ViewPager2 viewPager2,Intent intent, Activity activity) {
        this.mInflater = LayoutInflater.from(context);
        this.mData = data;
        this.viewPager2 = viewPager2;
        this.mcontext= context;
        this.intent= intent;
        this.activity= activity;

    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_viewpager, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String animal = mData.get(position);

        holder.myTextView.setText(animal);
        holder.number.setText((position + 1) +"°");
        holder.relativeLayout.setBackgroundResource(colorArray[position]);
        holder.playgrade.setOnClickListener(v -> {
            if (SettingsPreferences.getSoundEnableDisable(activity)) {
                Constant.backSoundonclick(activity);
            }
            if (SettingsPreferences.getVibration(activity)) {
                Constant.vibrate(activity, Constant.VIBRATION_DURATION);
            }
          Intent i= new Intent();
          i.putExtra("level", ""+position);
          SettingsPreferences.setSchoolGrade(mcontext,position+1);
          activity.setResult(SetGradeActivity.RESULT_OK,intent);
          activity.finish();
        });


        if(position==0){
            holder.rightswippe.setVisibility(View.INVISIBLE);
        }else if(position==5){
            holder.leftswippe.setVisibility(View.INVISIBLE);
            holder.playgrade.setAnimation("grade.json");

        }

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView myTextView, number;
        RelativeLayout relativeLayout;
        LottieAnimationView leftswippe,rightswippe, playgrade;





        ViewHolder(View itemView) {
            super(itemView);
            myTextView = itemView.findViewById(R.id.tvTitle);
            number= itemView.findViewById(R.id.tvNumber);
            relativeLayout = itemView.findViewById(R.id.containerview);
            leftswippe= itemView.findViewById(R.id.slideleft);
            rightswippe=itemView.findViewById(R.id.slideright);
            playgrade= itemView.findViewById(R.id.playlevel);

        }
    }
}
