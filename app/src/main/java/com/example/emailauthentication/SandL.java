package com.example.emailauthentication;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class SandL extends AppCompatActivity {
    private Button btn1;
    private Button btn2;
    private EditText Name,date;
    FirebaseFirestore db;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sand_l);
        db = FirebaseFirestore.getInstance();
        mAuth = FirebaseAuth.getInstance();
        Name = findViewById(R.id.editTextText31);
        date = findViewById(R.id.editTextDate4);

        btn1 = findViewById(R.id.button6);
        btn2 = findViewById(R.id.button8);

        btn1.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        String Nam = Name.getText().toString().trim();
                        String dat = date.getText().toString().trim();
                        Map<String, Object> user = new HashMap<>();
                        user.put("Name", Nam);
                        user.put("Date", dat);
                        db.collection("sandl")
                                .add(user)
                                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                                    @Override
                                    public void onSuccess(DocumentReference documentReference) {
                                        Log.d(TAG, "DocumentSnapshot added with ID: " + documentReference.getId());
                                    }
                                })
                                .addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        Log.w(TAG, "Error adding document", e);
                                    }
                                });


                        Intent it = new Intent(SandL.this, General_info5.class);
                        startActivity(it);
                    }
                }

        );

        btn2.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        Intent it = new Intent(SandL.this, SandL3 .class);
                                        startActivity(it);

                                    }
                                }
        );

    }
}