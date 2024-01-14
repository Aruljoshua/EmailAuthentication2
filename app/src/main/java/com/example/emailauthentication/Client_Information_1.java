package com.example.emailauthentication;

import  static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class Client_Information_1 extends AppCompatActivity {
    Button b2;
    Button b3;
    private EditText mothertongue,knownknowledges,refferedby,fathersname,occupation,contactno,email,mothersname,occupations,contactnom;
    FirebaseFirestore db;
    FirebaseAuth mAuth;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client_information1);
        db= FirebaseFirestore.getInstance();
        mAuth = FirebaseAuth.getInstance();
        mothertongue = findViewById(R.id.editTextText3);
        knownknowledges = findViewById(R.id.editTextText4);
        refferedby =findViewById(R.id.editTextText6);
        fathersname = findViewById(R.id.editTextText9);
        occupation = findViewById(R.id.editTextText11);
        contactno =findViewById(R.id.editTextPhone);
        email = findViewById(R.id.editTextTextEmailAddress);
        mothersname = findViewById(R.id.editTextText15);
        occupations=findViewById(R.id.editTextText16);
        contactnom=findViewById(R.id.editTextPhone5);

        b2=findViewById(R.id.next2);
        b3=findViewById(R.id.previous1);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mt = mothertongue.getText().toString().trim();
                String kn = knownknowledges.getText().toString().trim();
                String rb = refferedby.getText().toString().trim();
                String fn = fathersname.getText().toString().trim();
                String oc = occupation.getText().toString().trim();
                String cn = contactno.getText().toString().trim();
                String em = email.getText().toString().trim();
                String mn = mothersname.getText().toString().trim();
                String ocs = occupations.getText().toString().trim();
                String cns = contactnom.getText().toString().trim();

                Map<String, Object> user = new HashMap<>();
                user.put("mt", mt);
                user.put("kn", kn);
                user.put("rb", rb);
                user.put("fn", fn);
                user.put("oc", oc);
                user.put("cn", cn);
                user.put("em", em);
                user.put("mn", mn);
                user.put("ocs", ocs);
                user.put("cns", cns);






// Add a new document with a generated ID
                db.collection("client Information 1")
                        .add(user)
                        .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                            @Override
                            public void onSuccess(DocumentReference documentReference) {
                                Log.d(TAG, "DocumentSnapshot added with ID: " + documentReference.getId());
                                Toast.makeText(Client_Information_1.this,"DocumentSnapshot added with ID: ",Toast.LENGTH_SHORT).show();
                                Intent it=new Intent(Client_Information_1.this, Client_Information_2.class);
                                startActivity(it);
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Log.w(TAG, "Error adding document", e);
                                Toast.makeText(Client_Information_1.this,"Error adding document",Toast.LENGTH_SHORT).show();
                            }
                        });



            }
        });
        b3.setOnClickListener(new View.OnClickListener(){
                                  @Override
                                  public void onClick(View v){
                                      Intent it=new Intent(Client_Information_1.this, Client_Information.class);
                                      startActivity(it);

                                  }
                              }
        );

    }

    }
