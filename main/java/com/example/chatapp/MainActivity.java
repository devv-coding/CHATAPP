package com.example.chatapp;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private DatabaseReference myRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        myRef = database.getReference("ChatData")
                .child("UserChat").child("Vikash").child("message");

        //write();
        //readOnce();
        //readAll();
        readAllMessage();
    }

    private void readAllMessage() {
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference()
                .child("ChatData").child("Group").child("message");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                    Helper helper = dataSnapshot1.getValue(Helper.class);
                    Log.d(TAG, "onDataChange: Message" + helper.getMessage());
                    // Log.d(TAG, "onDataChange: Sender "+helper.getSender());
                    // Log.d(TAG, "onDataChange: Receiver "+helper.getReceiver());
                }


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }

    private void readAll() {
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference()
                .child("ChatData").child("Group").child("message").child("-LiRJGDgA0GxxpRcD6SE");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Helper helper = dataSnapshot.getValue(Helper.class);
                Log.d(TAG, "onDataChange: Message" + helper.getMessage());
                Log.d(TAG, "onDataChange: Sender " + helper.getSender());
                Log.d(TAG, "onDataChange: Receiver " + helper.getReceiver());

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }

    private void readOnce() {
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference()
                .child("ChatData").child("Group").child("message").child("-LiRID8vyM1FQIBNy0_N")
                .child("message");

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String data = dataSnapshot.getValue(String.class);
                Log.d(TAG, "onDataChange: Message " + data);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


    }

    private void write() {
        Map map = new HashMap();
        map.put("message", "hii");
        myRef.push().setValue(map).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                Log.d(TAG, "onComplete: ");
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Log.e(TAG, "onFailure: " + e.toString());
            }
        });
    }
}

/*
package com.example.firebasetrial;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private DatabaseReference myRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

// Write a message to the database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("ChatData").child("Group").child("Message");

        Map map = new HashMap();
        map.put("message", "Hello Friend");
        map.put("sender", "Name");
        map.put("id", "ID");
        map.put("time", "Hello Friend");
        myRef.push().setValue(map);

        read();
        //write();
        //DatabaseReference myReff = database.getReference("text").child("Group");
        */
/*myRef.setValue("Hello, World!");
        myReff.child("Hello, Friend!").setValue("Hello, World!");
        myReff.setValue("Hello, World!");*//*


 */
/*myRef.push().setValue(map).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                Log.d(TAG, "onComplete: ");
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Log.e(TAG, "onFailure: ", e.toString());
            }
        });*//*

    }

    private void read() {
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference()
                .child("ChatData").child("Group").child("Message");
    }

    private void write() {


    }
}
*/
