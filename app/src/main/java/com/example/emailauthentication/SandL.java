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
import android.widget.RadioButton;

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

        boolean radioButton17 = ((RadioButton) findViewById(R.id.radioButton17)).isChecked();
        boolean radioButton19 = ((RadioButton) findViewById(R.id.radioButton19)).isChecked();
        boolean radioButton20 = ((RadioButton) findViewById(R.id.radioButton20)).isChecked();
        boolean radioButton21 = ((RadioButton) findViewById(R.id.radioButton21)).isChecked();
        boolean radioButton22 = ((RadioButton) findViewById(R.id.radioButton22)).isChecked();
        boolean radioButton9 = ((RadioButton) findViewById(R.id.radioButton9)).isChecked();
        boolean radioButton10 = ((RadioButton) findViewById(R.id.radioButton10)).isChecked();
        boolean radioButton12 = ((RadioButton) findViewById(R.id.radioButton12)).isChecked();
        boolean radioButton13 = ((RadioButton) findViewById(R.id.radioButton13)).isChecked();
        boolean radioButton5 = ((RadioButton) findViewById(R.id.radioButton5)).isChecked();
        boolean radioButton6 = ((RadioButton) findViewById(R.id.radioButton6)).isChecked();
        boolean radioButton7 = ((RadioButton) findViewById(R.id.radioButton7)).isChecked();
        boolean radioButton2 = ((RadioButton) findViewById(R.id.radioButton2)).isChecked();
        boolean radioButton3 = ((RadioButton) findViewById(R.id.radioButton3)).isChecked();
        boolean radioButton4 = ((RadioButton) findViewById(R.id.radioButton4)).isChecked();
        boolean radioButton8 = ((RadioButton) findViewById(R.id.radioButton8)).isChecked();
        boolean radioButton11 = ((RadioButton) findViewById(R.id.radioButton11)).isChecked();
        boolean radioButton14 = ((RadioButton) findViewById(R.id.radioButton14)).isChecked();
        boolean radioButton15 = ((RadioButton) findViewById(R.id.radioButton15)).isChecked();
        boolean radioButton16 = ((RadioButton) findViewById(R.id.radioButton16)).isChecked();
        boolean radioButton18 = ((RadioButton) findViewById(R.id.radioButton18)).isChecked();


        btn2.setOnClickListener(
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
                        Map<String, Object> radioButtonData = new HashMap<>();
                        radioButtonData.put("radioButton2", radioButton2);
                        radioButtonData.put("radioButton3", radioButton3);
                        radioButtonData.put("radioButton4", radioButton4);
                        radioButtonData.put("radioButton7", radioButton7);
                        radioButtonData.put("radioButton8", radioButton8);
                        radioButtonData.put("radioButton9", radioButton9);
                        radioButtonData.put("radioButton10", radioButton10);
                        radioButtonData.put("radioButton11", radioButton11);
                        radioButtonData.put("radioButton12", radioButton12);
                        radioButtonData.put("radioButton13", radioButton13);
                        radioButtonData.put("radioButton14", radioButton14);
                        radioButtonData.put("radioButton15", radioButton15);
                        radioButtonData.put("radioButton16", radioButton16);
                        radioButtonData.put("radioButton17", radioButton17);
                        radioButtonData.put("radioButton18", radioButton18);
                        radioButtonData.put("radioButton22", radioButton22);
                        radioButtonData.put("radioButton17", radioButton17);
                        radioButtonData.put("radioButton19", radioButton19);
                        radioButtonData.put("radioButton20", radioButton20);
                        radioButtonData.put("radioButton21", radioButton21);
                        radioButtonData.put("radioButton22", radioButton22);
                        radioButtonData.put("radioButton9", radioButton9);
                        radioButtonData.put("radioButton10", radioButton10);
                        radioButtonData.put("radioButton12", radioButton12);
                        radioButtonData.put("radioButton13", radioButton13);
                        radioButtonData.put("radioButton5", radioButton5);
                        radioButtonData.put("radioButton6", radioButton6);
                        radioButtonData.put("radioButton7", radioButton7);

                        db.collection("radioButtons")
                                .add(radioButtonData)
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




                        Intent it = new Intent(SandL.this, SandL3 .class);
                        startActivity(it);
                    }
                }

        );

        btn1.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        Intent it = new Intent(SandL.this, General_info5.class);
                                        startActivity(it);

                                    }
                                }
        );

    }
}