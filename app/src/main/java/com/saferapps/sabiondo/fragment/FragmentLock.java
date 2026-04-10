package com.saferapps.sabiondo.fragment;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.airbnb.lottie.LottieAnimationView;
import com.saferapps.sabiondo.Constant;
import com.saferapps.sabiondo.R;
import com.saferapps.sabiondo.activity.MainActivity;
import com.saferapps.sabiondo.helper.SettingsPreferences;
import com.saferapps.sabiondo.model.SetLevel;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import me.zhanghai.android.materialratingbar.MaterialRatingBar;

public class FragmentLock extends Fragment {
    LevelListAdapter adapter;


    public View v;
    private static int levelNo = 1;
    public static Context mcontext;
    List<SetLevel> levelList;
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    int schoolGrade;
    FragmentPlayTime fragmentTimePlay;
    ConstraintLayout constraintLayout;

    public static final int REFRESH_DELAY = 4000;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.lock_fragment, container, false);
        mcontext = getActivity().getBaseContext();

        schoolGrade= SettingsPreferences.getSchoolGrade(mcontext);
        fragmentTimePlay= new FragmentPlayTime();





        recyclerView =  v.findViewById(R.id.recyclerView);
        layoutManager = new GridLayoutManager(getActivity(),2);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addItemDecoration(new SpacesItemDecoration(10));
        levelNo = SettingsPreferences.getNoCompletedLevel(mcontext,schoolGrade);
        getActivity().setTitle(getString(R.string.select_level));
        levelList = new ArrayList<>();
        for (int i = 0; i < Constant.NO_OF_QUIZ_LEVEL; i++) {
            SetLevel card = new SetLevel("" + i, "Nivel " + (i + 1), levelNo);
            levelList.add(card);
        }
       constraintLayout = v.findViewById(R.id.headertext);

        AnimationDrawable animationDrawable = (AnimationDrawable) constraintLayout.getBackground();

        animationDrawable.setEnterFadeDuration(2500);
        animationDrawable.setExitFadeDuration(5000);

        animationDrawable.start();



        constraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.fragment_container, fragmentTimePlay, "fragment");
                ft.addToBackStack("tag");
                ft.commit();

            }
        });


        adapter = new LevelListAdapter(getActivity(), levelList);
        recyclerView.setAdapter(adapter);
        recyclerView.getRecycledViewPool().setMaxRecycledViews(0, 0);


        return v;
    }

    public class LevelListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
        String[] colorsTxt = mcontext.getResources().getStringArray(R.array.colors);



        public Activity activity;
        private List<SetLevel> cardList;
        private FragmentPlay fragmentPlay = new FragmentPlay();
        private FragmentPlayTime fragmentPlayTime = new FragmentPlayTime();
        private int levelNo = 1;

        public LevelListAdapter(Activity activity, List<SetLevel> cardList) {
            this.cardList = cardList;
            this.activity = activity;
        }

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lock_item, parent, false);
            return new LevelViewHolder(view);
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
            String ramdomColor = colorsTxt[new Random().nextInt(colorsTxt.length)];


            LevelViewHolder viewHolder = (LevelViewHolder) holder;
            levelNo = SettingsPreferences.getNoCompletedLevel(activity,schoolGrade);
            int score= SettingsPreferences.getLevelScore(mcontext,schoolGrade,position+1);
            int point= SettingsPreferences.getLevelPoints(mcontext,schoolGrade,position+1);
            float rating = (float) score / 2;
            SetLevel card = cardList.get(position);
            if (score==0){
                viewHolder.question_no.setVisibility(View.GONE);
            }
            if (point==0){
                viewHolder.scoreTotal.setVisibility(View.GONE);
            }
            viewHolder.title.setText(card.getEnglishTitle());
            viewHolder.question_no.setText("Correctas: " + score*10+ " %");
            viewHolder.scoreTotal.setText("Puntos: " +point);
            if (card.getlock() >= position + 1) {
                viewHolder.cardView.setCardBackgroundColor(Color.parseColor(ramdomColor));
                viewHolder.lock.setVisibility(View.GONE);
                viewHolder.ratingBar.setRating(rating);
                if(score<=5){
                    viewHolder.ratingBar.setVisibility(View.GONE);
                    viewHolder.question_no.setVisibility(View.GONE);
                    viewHolder.scoreTotal.setVisibility(View.GONE);
                }
            } else {
                viewHolder.lock.playAnimation();
                viewHolder.cardView.setCardBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
                viewHolder.question_no.setVisibility(View.GONE);
                viewHolder.title.setVisibility(View.GONE);
                viewHolder.ratingBar.setVisibility(View.GONE);
                viewHolder.scoreTotal.setVisibility(View.GONE);
            }

            viewHolder.cardView.setOnClickListener(view -> {

                if (SettingsPreferences.getSoundEnableDisable(activity)) {
                    Constant.backSoundonclick(activity);
                }
                if (SettingsPreferences.getVibration(activity)) {
                    Constant.vibrate(activity, Constant.VIBRATION_DURATION);
                }
                Constant.RequestlevelNo = position + 1;
                if (levelNo >= position + 1) {
                    FragmentTransaction ft = ((MainActivity) activity).getSupportFragmentManager().beginTransaction();
                    ft.replace(R.id.fragment_container, fragmentPlay);
                    ft.commit();
                } else {
                    Toast.makeText(activity, "Nivel bloqueado", Toast.LENGTH_SHORT).show();
                }

            });
        }

        @Override
        public int getItemCount() {
            return cardList.size();
        }

        public class LevelViewHolder extends RecyclerView.ViewHolder {
            TextView title, question_no,scoreTotal;
            LottieAnimationView lock;
            CardView cardView;
            MaterialRatingBar ratingBar;


            public LevelViewHolder(View itemView) {
                super(itemView);
                title =  itemView.findViewById(R.id.item_title);
                question_no =  itemView.findViewById(R.id.question_no);
                lock = itemView.findViewById(R.id.lock);
                cardView =  itemView.findViewById(R.id.cardView);
                ratingBar= itemView.findViewById(R.id.rating_bar);
                scoreTotal= itemView.findViewById(R.id.scoretotal);




            }
        }
    }
    public class SpacesItemDecoration extends RecyclerView.ItemDecoration {
        private int space;
        public SpacesItemDecoration(int space) {
            this.space = space;
        }
        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            outRect.left = space;
            outRect.right = space;
            outRect.bottom = space;
            // Add top margin only for the first item to avoid double space between items
            if (parent.getChildLayoutPosition(view) == 0) {
                outRect.top = space;
            } else {
                outRect.top = 0;
            }
        }
    }


}

