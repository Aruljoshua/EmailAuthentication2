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

public class General_info5 extends AppCompatActivity {
    private Button btn1;
    private Button btn2;
    private EditText regression,age,skills,mention,date;
    FirebaseFirestore db;
    FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_general_info5);
        db = FirebaseFirestore.getInstance();
        mAuth = FirebaseAuth.getInstance();
        regression = findViewById(R.id.editTextText36);
        age = findViewById(R.id.editTextText34);
        mention = findViewById(R.id.editTextText37);
        skills = findViewById(R.id.editTextText33);




        btn1 = findViewById(R.id.button2);
        btn2 = findViewById(R.id.button);

        btn1.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        String R = regression.getText().toString().trim();
                        String A = age.getText().toString().trim();
                        String men = mention.getText().toString().trim();
                        String sk = skills.getText().toString().trim();





                        Map<String, Object> user = new HashMap<>();
                        user.put("regression", R);
                        user.put("age", A);
                        user.put("mention", men);
                        user.put("skills", sk);





// Add a new document with a generated ID
                        db.collection("genaral Information 5")
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


                        Intent it = new Intent(General_info5.this, SandL.class);
                        startActivity(it);
                    }
                }

        );

        btn2.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        Intent it = new Intent(General_info5.this,General_info4.class);
                                        startActivity(it);

                                    }
                                }
        );
    }
    }
