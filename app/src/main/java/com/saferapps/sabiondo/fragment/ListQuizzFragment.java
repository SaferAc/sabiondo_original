package com.saferapps.sabiondo.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.saferapps.sabiondo.R;
import com.saferapps.sabiondo.activity.MakeQuizz;
import com.saferapps.sabiondo.model.Quiz;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


public class ListQuizzFragment extends Fragment {
    private final List<Quiz> quizList = new ArrayList<>();
    private QuizAdapter adapter;
    private ProgressBar progressBar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.d("ListQuizzFragment", "onCreateView called");
        View v1 = inflater.inflate(R.layout.activity_list_quiz, container, false);

        progressBar = v1.findViewById(R.id.progressBar);
        RecyclerView mRecyclerView = v1.findViewById(R.id.recycler);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new QuizAdapter(quizList);
        mRecyclerView.setAdapter(adapter);

        FloatingActionButton fabaddquiz = v1.findViewById(R.id.fab_addquiz);

        fabaddquiz.setOnClickListener(v -> {
            Intent i = new Intent(getContext(), MakeQuizz.class);
            startActivity(i);
        });

        startFirebase();

        return v1;
    }

    private class QuizAdapter extends RecyclerView.Adapter<ViewHolder> {
        private final List<Quiz> quizzes;

        QuizAdapter(List<Quiz> quizzes) {
            this.quizzes = quizzes;
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_rv_card_quizlist, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            Quiz quiz = quizzes.get(position);
            holder.title.setText(quiz.getTitle());
            holder.votes.setText(String.valueOf(quiz.getVotes()));
            holder.grade.setText(String.format(Locale.getDefault(), "%d°", quiz.getGrade()));
            holder.scho_level.setText(quiz.getSchool_level());
            holder.trimestre.setText(String.valueOf(quiz.getTrimester()));

            holder.itemView.setOnClickListener(v -> {
                FragmentComunityQuiz fragment = new FragmentComunityQuiz();
                Bundle bundle = new Bundle();
                bundle.putSerializable("quiz", quiz);
                fragment.setArguments(bundle);
                getParentFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, fragment)
                        .addToBackStack(null)
                        .commit();
            });
        }

        @Override
        public int getItemCount() {
            return quizzes.size();
        }
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView title, votes, grade, scho_level, trimestre;
        ImageView share;

        ViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.tv_title);
            votes = itemView.findViewById(R.id.tv_votes);
            grade = itemView.findViewById(R.id.tv_scho_grade);
            scho_level = itemView.findViewById(R.id.txt_level);
            trimestre = itemView.findViewById(R.id.tv_trimestre);
            share = itemView.findViewById(R.id.sharebtn);
        }
    }

    private void startFirebase() {
        DatabaseReference database = FirebaseDatabase.getInstance().getReference("Quizlist");

        // Use ValueEventListener to hide progress bar once initial data is loaded
        database.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (progressBar != null) {
                    progressBar.setVisibility(View.GONE);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                if (progressBar != null) {
                    progressBar.setVisibility(View.GONE);
                }
            }
        });

        database.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                Quiz quiz = dataSnapshot.getValue(Quiz.class);
                if (quiz != null) {
                    String id = dataSnapshot.getKey();
                    quiz.setId(id);
                    quizList.add(quiz);
                    if (adapter != null) {
                        adapter.notifyItemInserted(quizList.size() - 1);
                    }
                }
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                Quiz updatedQuiz = dataSnapshot.getValue(Quiz.class);
                if (updatedQuiz != null) {
                    String id = dataSnapshot.getKey();
                    for (int i = 0; i < quizList.size(); i++) {
                        if (quizList.get(i).getId().equals(id)) {
                            updatedQuiz.setId(id);
                            quizList.set(i, updatedQuiz);
                            if (adapter != null) {
                                adapter.notifyItemChanged(i);
                            }
                            break;
                        }
                    }
                }
            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {
                String id = dataSnapshot.getKey();
                for (int i = 0; i < quizList.size(); i++) {
                    if (quizList.get(i).getId().equals(id)) {
                        quizList.remove(i);
                        if (adapter != null) {
                            adapter.notifyItemRemoved(i);
                        }
                        break;
                    }
                }
            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
    }
}
