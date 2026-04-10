package com.saferapps.sabiondo.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.saferapps.sabiondo.Constant;
import com.saferapps.sabiondo.R;
import com.saferapps.sabiondo.helper.SettingsPreferences;

import java.util.ArrayList;
import java.util.List;

public class VersusActivity extends AppCompatActivity {

    ListView listView;
    Button button;

    List<String> roomList;
    String playerName="";
    String roomName="";
    FirebaseDatabase database;
    DatabaseReference roomRef;
    DatabaseReference roomsRef;
    Context mcontext;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mcontext= getApplicationContext();

        database= FirebaseDatabase.getInstance();
        playerName= SettingsPreferences.getPlayerName(mcontext);
        roomName= playerName;
        roomList= new ArrayList<>();
        setContentView(R.layout.activity_versus);
        listView= findViewById(R.id.lv_versus);
        button= findViewById(R.id.btn_versus);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Crea un cuarto y se añade al mismo
                button.setText("CREATING ROOM");
                button.setEnabled(false);
                roomName= playerName;
                roomRef= database.getReference("rooms/"+roomName + "/player1");
                addRoomEventListener();
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            //se une a un cuarto como player2
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                roomName= roomList.get(position);
                roomRef= database.getReference("rooms/"+roomName + "/player2");
                addRoomEventListener();
                roomRef.setValue(playerName);
            }
        });
        //show if new room is created
        addRoomsEventListener();

    }

    private void addRoomEventListener() {
        roomRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                //join the room
                button.setText("CREATE ROOM");
                button.setEnabled(true);
                Intent intent= new Intent(mcontext, PokeActivity.class);
                intent.putExtra("roomName",roomName);
                startActivity(intent);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                //Error
                button.setText("CREATE ROOM");
                button.setEnabled(true);
                Toast.makeText(mcontext, "Error!", Toast.LENGTH_SHORT).show();

            }
        });
    }
    private void addRoomsEventListener(){
            roomsRef= database.getReference("rooms");
            roomsRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    //show list of rooms
                    roomList.clear();
                    Iterable<DataSnapshot> rooms =dataSnapshot.getChildren();
                    for (DataSnapshot snapshot : rooms){
                        roomList.add(snapshot.getKey());
                        ArrayAdapter<String> adapter= new ArrayAdapter<>(VersusActivity.this,
                                android.R.layout.simple_list_item_1,roomList);
                        listView.setAdapter(adapter);
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
    }
}
