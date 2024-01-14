package com.example.emailauthentication;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
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

public class Admin11 extends AppCompatActivity {
    private Button btn1;
    private Button btn2;
    private EditText Remarks1,remarks2,remarks3,tnv;
    FirebaseFirestore db;
    FirebaseAuth mAuth;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin11);
        db = FirebaseFirestore.getInstance();
        mAuth = FirebaseAuth.getInstance();
        Remarks1 = findViewById(R.id.editTextText57);
        remarks2=findViewById(R.id.editTextText59);
        remarks3=findViewById(R.id.editTextText63);
        tnv=findViewById(R.id.edittexta);





        btn1 = findViewById(R.id.button3);
        btn2 = findViewById(R.id.button4);

        btn1.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        String remark = Remarks1.getText().toString().trim();
                        String remark2 = remarks2.getText().toString().trim();
                        String remark3 = remarks3.getText().toString().trim();
                        String tnvs = tnv.getText().toString().trim();


                        Map<String, Object> user = new HashMap<>();
                        user.put("Remarks", remark);

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


                        Intent it = new Intent(Admin11.this, Admin12.class);
                        startActivity(it);
                    }
                }

        );

        btn2.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        Intent it = new Intent(Admin11.this, A9.class);
                                        startActivity(it);

                                    }
                                }
        );
    }
    }
