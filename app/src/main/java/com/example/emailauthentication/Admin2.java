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

public class Admin2 extends AppCompatActivity {
    private Button btn1;
    private Button btn2;
    private EditText Remarks,remarks1;
    FirebaseFirestore db;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin2);
        db = FirebaseFirestore.getInstance();
        mAuth = FirebaseAuth.getInstance();
        Remarks = findViewById(R.id.editTextText55);
        remarks1 = findViewById(R.id.editTextText53);



        btn1 = findViewById(R.id.button5);
        btn2 = findViewById(R.id.button6);

        btn1.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        String remark = Remarks.getText().toString().trim();
                        String aremark = remarks1.getText().toString().trim();



                        Map<String, Object> user = new HashMap<>();
                        user.put("Remarks", remark);
                        user.put("remarks1", aremark);


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


                        Intent it = new Intent(Admin2.this, Admin_3.class);
                        startActivity(it);
                    }
                }

        );

        btn2.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        Intent it = new Intent(Admin2.this, A1.class);
                                        startActivity(it);

                                    }
                                }
        );
    }
    }
