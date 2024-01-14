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

public class General_info3 extends AppCompatActivity {

    private Button btn1;
    private Button btn2;
    private EditText Nadults, Nkids, Jadults, Jkids, remarks, AgeMother, AgeFather, Specify;
    FirebaseFirestore db;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_general_info3);
        db = FirebaseFirestore.getInstance();
        mAuth = FirebaseAuth.getInstance();
        Nadults = findViewById(R.id.editTextText35);
        Nkids = findViewById(R.id.editTextText39);
        Jadults = findViewById(R.id.editTextText38);
        Jkids = findViewById(R.id.editTextText35);
        remarks = findViewById(R.id.editTextText41);
        AgeMother = findViewById(R.id.editTextText39);
        AgeFather = findViewById(R.id.editTextText42);
        Specify = findViewById(R.id.editTextText41);


        btn1 = findViewById(R.id.button24);
        btn2 = findViewById(R.id.button23);

        btn1.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        String Nadul = Nadults.getText().toString().trim();
                        String Nkid = Nkids.getText().toString().trim();
                        String Jadul = Jadults.getText().toString().trim();
                        String Jkid = Jkids.getText().toString().trim();
                        String remark = remarks.getText().toString().trim();
                        String Amother = AgeMother.getText().toString().trim();
                        String AFather = AgeFather.getText().toString().trim();
                        String S = Specify.getText().toString().trim();



                        Map<String, Object> user = new HashMap<>();
                        user.put("Nadults", Nadul);
                        user.put("Nkids", Nkid);
                        user.put("Jadults", Jadul);
                        user.put("Jkids", Jkid);
                        user.put("remarks", remark);
                        user.put("AgeMother", Amother);
                        user.put("AgeFather", AFather);
                        user.put("Specify", S);



// Add a new document with a generated ID
                        db.collection("genaral Information 2")
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


                        Intent it = new Intent(General_info3.this, Genaral_info2.class);
                        startActivity(it);
                    }
                }

        );

        btn2.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        Intent it = new Intent(General_info3.this, General_info4.class);
                                        startActivity(it);

                                    }
                                }
        );

    }
}