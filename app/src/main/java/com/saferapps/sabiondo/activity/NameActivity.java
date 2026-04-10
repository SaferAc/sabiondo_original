package com.saferapps.sabiondo.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.saferapps.sabiondo.R;
import com.saferapps.sabiondo.helper.SettingsPreferences;

public class NameActivity extends AppCompatActivity {
    EditText editText;
    Button button;

    String playerName="";
    FirebaseDatabase database;
    DatabaseReference playerRef;
    Context mcontext;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name);
        mcontext = getApplicationContext();

        editText = findViewById(R.id.ed_name);
        button = findViewById(R.id.btn_name);

        //check if the player exist
        database = FirebaseDatabase.getInstance();
        playerName = SettingsPreferences.getPlayerName(mcontext);
        if (!playerName.equals("")) {
            playerRef = database.getReference("players/" + playerName);
            addEventListener();
            playerRef.setValue("");

        }
        button.setOnClickListener(v -> {
            //login player
            playerName= editText.getText().toString().trim();
            editText.setText("");
            if(!playerName.equals("")){
                button.setText("INGRESANDO...");
                button.setEnabled(false);
                playerRef = database.getReference("players/" + playerName);
                addEventListener();
                playerRef.setValue("");
            }
        });
    }

    private void addEventListener() {
        //read from database
        playerRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(!playerName.equals("")){
                    SettingsPreferences.setPlayenName(mcontext,playerName);
                    startActivity(new Intent(mcontext,VersusActivity.class));
                    finish();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                button.setText("REGISTRATE");
                button.setEnabled(true);
                Toast.makeText(mcontext, "Error!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
