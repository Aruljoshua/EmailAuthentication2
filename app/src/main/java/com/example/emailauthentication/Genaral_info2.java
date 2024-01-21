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
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Genaral_info2 extends AppCompatActivity {
    private Button btn1;
    private Button btn2;
    private EditText orgname,duration,frequncy,regirr,reason,brotherage;
    FirebaseFirestore db;
    FirebaseAuth mAuth;
    private CollectionReference checkboxCollection;
    private Button addButton;

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

        checkboxCollection = db.collection("checkboxes");


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

                        List<Map<String, Object>> checkboxDataList = new ArrayList<>();

                        Map<String, Object> checkboxData1 = new HashMap<>();
                        checkboxData1.put("id", "checkBox35");
                        checkboxData1.put("text", "f.NO ISSUES");
                        checkboxDataList.add(checkboxData1);

                        Map<String, Object> checkboxData2 = new HashMap<>();
                        checkboxData2.put("id", "checkBox34");
                        checkboxData2.put("text", "e.ANY OTHER");
                        checkboxDataList.add(checkboxData2);

                        Map<String, Object> checkboxData3 = new HashMap<>();
                        checkboxData3.put("id", "checkBox33");
                        checkboxData3.put("text", "d.AUTISM:ADHD");
                        checkboxDataList.add(checkboxData3);

                        Map<String, Object> checkboxData4 = new HashMap<>();
                        checkboxData4.put("id", "checkBox32");
                        checkboxData4.put("text", "c.SYNDROME");
                        checkboxDataList.add(checkboxData4);

                        Map<String, Object> checkboxData5 = new HashMap<>();
                        checkboxData5.put("id", "checkBox30");
                        checkboxData5.put("text", "a.LATE TALKER");
                        checkboxDataList.add(checkboxData5);

                        Map<String, Object> checkboxData6 = new HashMap<>();
                        checkboxData6.put("id", "checkBox29");
                        checkboxData6.put("text", "f.NO ISSUES");
                        checkboxDataList.add(checkboxData6);

                        Map<String, Object> checkboxData7 = new HashMap<>();
                        checkboxData7.put("id", "checkBox27");
                        checkboxData7.put("text", "d.AUTISM:ADHD");
                        checkboxDataList.add(checkboxData7);

                        Map<String, Object> checkboxData8 = new HashMap<>();
                        checkboxData8.put("id", "checkBox28");
                        checkboxData8.put("text", "e.ANY OTHER");
                        checkboxDataList.add(checkboxData8);

                        Map<String, Object> checkboxData9 = new HashMap<>();
                        checkboxData9.put("id", "checkBox26");
                        checkboxData9.put("text", "c.SYNDROME");
                        checkboxDataList.add(checkboxData9);

                        Map<String, Object> checkboxData10 = new HashMap<>();
                        checkboxData10.put("id", "checkBox25");
                        checkboxData10.put("text", "b.HEARING IMPAIRED");
                        checkboxDataList.add(checkboxData10);

                        Map<String, Object> checkboxData11 = new HashMap<>();
                        checkboxData11.put("id", "checkBox31");
                        checkboxData11.put("text", "b.HEARING IMPAIRED");
                        checkboxDataList.add(checkboxData11);



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
                        for (Map<String, Object> checkboxData : checkboxDataList) {
                            checkboxCollection.add(checkboxData)
                                    .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                                        @Override
                                        public void onSuccess(DocumentReference documentReference) {
                                            Log.d(TAG, "Checkbox data added successfully. Document ID: " + documentReference.getId());
                                        }
                                    })
                                    .addOnFailureListener(new OnFailureListener() {
                                        @Override
                                        public void onFailure(@NonNull Exception e) {
                                            Log.e(TAG, "Error adding checkbox data", e);
                                        }
                                    });
                        }

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

