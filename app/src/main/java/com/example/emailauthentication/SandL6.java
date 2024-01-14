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

public class SandL6 extends AppCompatActivity {

    private Button btn1;
    private Button btn2;
    private EditText Others, Words, Length;
    FirebaseFirestore db;
    FirebaseAuth mAuth;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sand_l6);
        db = FirebaseFirestore.getInstance();
        mAuth = FirebaseAuth.getInstance();
        Others = findViewById(R.id.editTextText37);
        Words = findViewById(R.id.editTextText49);
        Length = findViewById(R.id.editTextText50);

        btn1 = findViewById(R.id.button21);
        btn2 = findViewById(R.id.button22);

        btn1.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        String other = Others.getText().toString().trim();
                        String word = Words.getText().toString().trim();
                        String len = Length.getText().toString().trim();

                        Map<String, Object> user = new HashMap<>();
                        user.put("Others", other);
                        user.put("Words", word);
                        user.put("len", Length);

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


                        Intent it = new Intent(SandL6.this, SandL8.class);
                        startActivity(it);
                    }
                }

        );

        btn2.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        Intent it = new Intent(SandL6.this, SandL5.class);
                                        startActivity(it);

                                    }
                                }
        );
    }
}