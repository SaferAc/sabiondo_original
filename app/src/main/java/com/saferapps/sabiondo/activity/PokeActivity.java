package com.saferapps.sabiondo.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.saferapps.sabiondo.R;
import com.saferapps.sabiondo.helper.SettingsPreferences;

public class PokeActivity extends AppCompatActivity {

    Button button;
    String playerName="";
    String roomName="";
    String role="";
    String message="";
    FirebaseDatabase database;
    DatabaseReference messageRef;
    Context mcontext;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_poke);
        mcontext= getApplicationContext();

        button= findViewById(R.id.btn_poke);
        button.setEnabled(false);

        database= FirebaseDatabase.getInstance();
        playerName= SettingsPreferences.getPlayerName(mcontext);
        Bundle extras= getIntent().getExtras();
        if(extras !=null){
            roomName= extras.getString("roomName");
            if(roomName.equals(playerName)){
                role= "host";
            }else{
                role="guest";
            }
        }

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Send message
                button.setEnabled(false);
                message= role + ":Poked!";
                messageRef.setValue(message);
            }
        });

        //listen for incoming Messages
        messageRef= database.getReference("rooms/" +roomName + "/message");
        message= role + ":Poked!";
        messageRef.setValue(message);
        addRoomEventListener();
    }
    private void addRoomEventListener(){
        messageRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (role.equals("host")) {
                    if (dataSnapshot.getValue(String.class).contains("guest:")) {
                        button.setEnabled(true);
                        Toast.makeText(mcontext, "" + dataSnapshot.getValue(String.class).replace("guest:", ""), Toast.LENGTH_SHORT).show();
                    }
                } else {
                    if (role.equals("guest")) {
                        if (dataSnapshot.getValue(String.class).contains("host:")) {
                            button.setEnabled(true);
                            Toast.makeText(mcontext, "" + dataSnapshot.getValue(String.class).replace("guest:", ""), Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                //error
                messageRef.setValue(message);
            }
        });
    }
}
