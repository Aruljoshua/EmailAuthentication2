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

public class SandL4 extends AppCompatActivity {

    private Button btn1;
    private Button btn2;
    private EditText Likes, Dislikes, Comments;
    FirebaseFirestore db;
    FirebaseAuth mAuth;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sand_l4);
        db = FirebaseFirestore.getInstance();
        mAuth = FirebaseAuth.getInstance();
        Likes = findViewById(R.id.editTextText51);
        Dislikes = findViewById(R.id.editTextText52);
        Comments = findViewById(R.id.editTextText53);

        btn2 = findViewById(R.id.button11);
        btn1 = findViewById(R.id.button14);

        btn1.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        String like = Likes.getText().toString().trim();
                        String DisL = Dislikes.getText().toString().trim();
                        String comment = Comments.getText().toString().trim();

                        Map<String, Object> user = new HashMap<>();
                        user.put("Likes", like);
                        user.put("Dislikes", DisL);
                        user.put("Comments", comment);

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


                        Intent it = new Intent(SandL4.this, SandL6.class);
                        startActivity(it);
                    }
                }

        );

        btn2.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        Intent it = new Intent(SandL4.this, SandL3.class);
                                        startActivity(it);

                                    }
                                }
        );


    }
}