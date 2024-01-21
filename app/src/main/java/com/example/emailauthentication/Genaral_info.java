package com.example.emailauthentication;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class Genaral_info extends AppCompatActivity {
    private Button btn1;
    private Button btn2;
    private EditText name, date, reason, sceenexpo, age, duration, reduction, remark;
    FirebaseFirestore db;
    FirebaseAuth mAuth;

    private CheckBox checkBox4, checkBox5,checkBox6,checkBox7,checkBox8,checkBox9,checkBox11,checkBox12,checkBox3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_genaral_info);
        db = FirebaseFirestore.getInstance();
        mAuth = FirebaseAuth.getInstance();
        name = findViewById(R.id.editTextText13);
        date = findViewById(R.id.editTextDate3);
        reason = findViewById(R.id.editTextText20);
        sceenexpo = findViewById(R.id.editTextText21);
        age = findViewById(R.id.editTextText22);
        duration = findViewById(R.id.editTextText23);
        reduction = findViewById(R.id.editTextText24);
        remark = findViewById(R.id.editTextText25);

        checkBox4 = findViewById(R.id.checkBox4);
        checkBox5 = findViewById(R.id.checkBox5);
        checkBox6 = findViewById(R.id.checkBox6);
        checkBox7 = findViewById(R.id.checkBox7);
        checkBox8 = findViewById(R.id.checkBox8);
        checkBox9 = findViewById(R.id.checkBox9);
        checkBox11 = findViewById(R.id.checkBox11);
        checkBox12 = findViewById(R.id.checkBox12);
        checkBox3 = findViewById(R.id.checkBox3);



        btn1 = findViewById(R.id.previousbtn);
        btn2 = findViewById(R.id.generalinfonext);

        btn2.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        String names = name.getText().toString().trim();
                        String dates = date.getText().toString().trim();
                        String reasons = reason.getText().toString().trim();
                        String screenexpo = sceenexpo.getText().toString().trim();
                        String ages = age.getText().toString().trim();
                        String durations = duration.getText().toString().trim();
                        String reductions = reduction.getText().toString().trim();
                        String remarks = remark.getText().toString().trim();


                        boolean isChecked4 = checkBox4.isChecked();
                        boolean isChecked5 = checkBox5.isChecked();
                        boolean isChecked6 = checkBox6.isChecked();
                        boolean isChecked7 = checkBox7.isChecked();
                        boolean isChecked8 = checkBox8.isChecked();
                        boolean isChecked9 = checkBox9.isChecked();
                        boolean isChecked11 = checkBox11.isChecked();
                        boolean isChecked12 = checkBox12.isChecked();
                        boolean isChecked3 = checkBox3.isChecked();


                        Map<String, Object> user = new HashMap<>();
                        user.put("name", names);
                        user.put("date", dates);
                        user.put("reason", reasons);
                        user.put("sceenexpo", screenexpo);
                        user.put("age", ages);
                        user.put("duration", durations);
                        user.put("reduction", reductions);
                        user.put("remark", remarks);

                        user.put("userCheckBox4Value", isChecked4);
                        user.put("userCheckBox5Value", isChecked5);
                        user.put("userCheckBox6Value", isChecked6);
                        user.put("userCheckBox7Value", isChecked7);
                        user.put("userCheckBox8Value", isChecked8);
                        user.put("userCheckBox9Value", isChecked9);
                        user.put("userCheckBox11Value", isChecked11);
                        user.put("userCheckBox12Value", isChecked12);
                        user.put("userCheckBox3Value", isChecked3);


// Add a new document with a generated ID
                        db.collection("genaral Information")
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


                        Intent it = new Intent(Genaral_info.this, Genaral_info2.class);
                        startActivity(it);
                    }
                }

        );

        btn1.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        Intent it = new Intent(Genaral_info.this, Client_Information_2.class);
                                        startActivity(it);

                                    }
                                }
        );
    }
}





