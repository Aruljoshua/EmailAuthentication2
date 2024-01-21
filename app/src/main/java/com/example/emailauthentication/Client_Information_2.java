package com.example.emailauthentication;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class Client_Information_2 extends AppCompatActivity {
    Button b4;
    private EditText email,remark,add1,add2,res1,res2,sig;
    FirebaseFirestore db;
    FirebaseAuth mAuth;
    private RadioGroup radioGroup;
    private CheckBox checkBox, checkBox2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client_information2);
        db= FirebaseFirestore.getInstance();
        mAuth = FirebaseAuth.getInstance();
        email = findViewById(R.id.editTextTextEmailAddress2);
        remark = findViewById(R.id.editTextText10);
        add1 =findViewById(R.id.editTextText12);
        add2 = findViewById(R.id.editTextText14);
        res1 = findViewById(R.id.editTextText12);
        res2 =findViewById(R.id.editTextText14);
        sig = findViewById(R.id.editTextText19);
        checkBox = findViewById(R.id.checkBox);
        checkBox2 = findViewById(R.id.checkBox2);
        b4=findViewById(R.id.submit);
        b4.setOnClickListener(new View.OnClickListener(){
                                  @Override
                                  public void onClick(View v){
                                      String emails = email.getText().toString().trim();
                                      String remarks = remark.getText().toString().trim();
                                      String add = add1.getText().toString().trim();
                                      String adds = add2.getText().toString().trim();
                                      String res = res1.getText().toString().trim();
                                      String ress = res2.getText().toString().trim();
                                      String sigs = sig.getText().toString().trim();
                                      boolean isChecked = checkBox.isChecked();
                                      boolean isChecked1 = checkBox2.isChecked();






                                      Map<String, Object> user = new HashMap<>();
                                      user.put("email",emails);
                                      user.put("remark", remarks);
                                      user.put("add1", add);
                                      user.put("add2", adds);
                                      user.put("res1", res);
                                      user.put("res2", ress);
                                      user.put("sig", sigs);
                                      user.put("checkBoxValue", isChecked);
                                      user.put("checkBoxValue", isChecked1);





// Add a new document with a generated ID
                                      db.collection("client Information 2")
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

                                      Intent it=new Intent(Client_Information_2.this, Genaral_info.class);
                                      startActivity(it);

                                  }
                              }
        );
    }
}