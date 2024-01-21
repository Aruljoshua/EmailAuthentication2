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
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.CollectionReference;
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

    RadioButton radioButton9, radioButton8, radioButton7, radioButton12, radioButton11, radioButton10, radioButton15, radioButton14, radioButton13, radioButton18, radioButton17, radioButton16, radioButton25, radioButton23, radioButton22, radioButton28, radioButton31, radioButton30, radioButton29, radioButton35, radioButton33, radioButton32;



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



        RadioButton radioButton2 = findViewById(R.id.radioButton2);
        RadioButton radioButton3 = findViewById(R.id.radioButton3);
        RadioButton radioButton4 = findViewById(R.id.radioButton4);
        RadioButton radioButton5 = findViewById(R.id.radioButton5);
        RadioButton radioButton6 = findViewById(R.id.radioButton6);
        RadioButton radioButton19 = findViewById(R.id.radioButton19);
        RadioButton radioButton20 = findViewById(R.id.radioButton20);
        RadioButton radioButton24 = findViewById(R.id.radioButton24);
        RadioButton radioButton26 = findViewById(R.id.radioButton26);
        RadioButton radioButton27 = findViewById(R.id.radioButton27);
        radioButton9 = findViewById(R.id.radioButton9);
        radioButton8 = findViewById(R.id.radioButton8);
        radioButton7 = findViewById(R.id.radioButton7);
        radioButton12 = findViewById(R.id.radioButton12);
        radioButton11 = findViewById(R.id.radioButton11);
        radioButton10 = findViewById(R.id.radioButton10);
        radioButton15 = findViewById(R.id.radioButton15);
        radioButton14 = findViewById(R.id.radioButton14);
        radioButton13 = findViewById(R.id.radioButton13);
        radioButton18 = findViewById(R.id.radioButton18);
        radioButton17 = findViewById(R.id.radioButton17);
        radioButton16 = findViewById(R.id.radioButton16);
        radioButton25 = findViewById(R.id.radioButton25);
        radioButton23 = findViewById(R.id.radioButton23);
        radioButton22 = findViewById(R.id.radioButton22);
        radioButton28 = findViewById(R.id.radioButton28);
        radioButton31 = findViewById(R.id.radioButton31);
        radioButton30 = findViewById(R.id.radioButton30);
        radioButton29 = findViewById(R.id.radioButton29);
        radioButton35 = findViewById(R.id.radioButton35);
        radioButton33 = findViewById(R.id.radioButton33);
        radioButton32 = findViewById(R.id.radioButton32);




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


                        String radioButton2Details = radioButton2.getText().toString();
                        String radioButton3Details = radioButton3.getText().toString();
                        String radioButton4Details = radioButton4.getText().toString();
                        String radioButton5Details = radioButton5.getText().toString();
                        String radioButton6Details = radioButton6.getText().toString();
                        String radioButton19Details = radioButton19.getText().toString();
                        String radioButton20Details = radioButton20.getText().toString();
                        String radioButton24Details = radioButton24.getText().toString();
                        String radioButton26Details = radioButton26.getText().toString();
                        String radioButton27Details = radioButton27.getText().toString();

                        CollectionReference radioButtonDetailsCollection = db.collection("radioButtonDetails");
                        DocumentReference newDocumentRef = radioButtonDetailsCollection.document();

// Create a HashMap to store the radioButtonDetails
                        Map<String, Object> radioButtonData = new HashMap<>();
                        radioButtonData.put("radioButton2", radioButton2Details);
                        radioButtonData.put("radioButton3", radioButton3Details);
                        radioButtonData.put("radioButton4", radioButton4Details);
                        radioButtonData.put("radioButton5", radioButton5Details);
                        radioButtonData.put("radioButton6", radioButton6Details);
                        radioButtonData.put("radioButton19", radioButton19Details);
                        radioButtonData.put("radioButton20", radioButton20Details);
                        radioButtonData.put("radioButton24", radioButton24Details);
                        radioButtonData.put("radioButton26", radioButton26Details);
                        radioButtonData.put("radioButton27", radioButton27Details);
                        radioButtonData.put("radioButton9", radioButton9.isChecked());
                        radioButtonData.put("radioButton8", radioButton8.isChecked());
                        radioButtonData.put("radioButton7", radioButton7.isChecked());
                        radioButtonData.put("radioButton12", radioButton12.isChecked());
                        radioButtonData.put("radioButton11", radioButton11.isChecked());
                        radioButtonData.put("radioButton10", radioButton10.isChecked());
                        radioButtonData.put("radioButton15", radioButton15.isChecked());
                        radioButtonData.put("radioButton14", radioButton14.isChecked());
                        radioButtonData.put("radioButton13", radioButton13.isChecked());
                        radioButtonData.put("radioButton18", radioButton18.isChecked());
                        radioButtonData.put("radioButton17", radioButton17.isChecked());
                        radioButtonData.put("radioButton16", radioButton16.isChecked());
                        radioButtonData.put("radioButton25", radioButton25.isChecked());
                        radioButtonData.put("radioButton23", radioButton23.isChecked());
                        radioButtonData.put("radioButton22", radioButton22.isChecked());
                        radioButtonData.put("radioButton28", radioButton28.isChecked());
                        radioButtonData.put("radioButton31", radioButton31.isChecked());
                        radioButtonData.put("radioButton30", radioButton30.isChecked());
                        radioButtonData.put("radioButton29", radioButton29.isChecked());
                        radioButtonData.put("radioButton35", radioButton35.isChecked());
                        radioButtonData.put("radioButton33", radioButton33.isChecked());
                        radioButtonData.put("radioButton32", radioButton32.isChecked());


                        newDocumentRef.set(radioButtonData)
                                .addOnSuccessListener(new OnSuccessListener<Void>() {
                                    @Override
                                    public void onSuccess(Void aVoid) {
                                        Toast.makeText(General_info5.this, "Details are saved", Toast.LENGTH_SHORT).show();
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
