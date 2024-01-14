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

public class Genaral_info2 extends AppCompatActivity {
    private Button btn1;
    private Button btn2;
    private EditText orgname,duration,frequncy,regirr,reason,brotherage;
    FirebaseFirestore db;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_genaral_info2);
        db = FirebaseFirestore.getInstance();
        mAuth = FirebaseAuth.getInstance();
        orgname = findViewById(R.id.editTextText26);
        duration = findViewById(R.id.editTextText27);
        frequncy = findViewById(R.id.editTextText28);
        regirr = findViewById(R.id.editTextText29);
        reason = findViewById(R.id.editTextText30);
        brotherage = findViewById(R.id.editTextText32);


        btn1 = findViewById(R.id.button);
        btn2 = findViewById(R.id.button2);

        btn2.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        String orgn = orgname.getText().toString().trim();
                        String dur= duration.getText().toString().trim();
                        String freq = frequncy.getText().toString().trim();
                        String reg = regirr.getText().toString().trim();
                        String res = reason.getText().toString().trim();
                        String ba = brotherage.getText().toString().trim();



                        Map<String, Object> user = new HashMap<>();
                        user.put("orgname", orgn);
                        user.put("duration", dur);
                        user.put("frequncy", freq);
                        user.put("regirr", reg);
                        user.put("reason", res);
                        user.put("brotherage", ba);



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
                        Intent it=new Intent(Genaral_info2.this, General_info4.class);
                        startActivity(it);



                    }
                }

        );

        btn1.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        Intent it = new Intent(Genaral_info2.this, Genaral_info.class);
                                        startActivity(it);

                                    }
                                }
        );
    }
}

