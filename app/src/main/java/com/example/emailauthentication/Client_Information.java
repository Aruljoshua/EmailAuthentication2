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


public class Client_Information extends AppCompatActivity {
    private Button b1;

    private EditText regNo,date,clientname,age,dob,schoolName,classStandard;
    FirebaseFirestore db;
    FirebaseAuth mAuth;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client_information);
        db= FirebaseFirestore.getInstance();
        mAuth = FirebaseAuth.getInstance();
        regNo = findViewById(R.id.editTextText8);
        date = findViewById(R.id.editTextText7);
        clientname =findViewById(R.id.editTextDate2);
        age = findViewById(R.id.editTextText);
        dob = findViewById(R.id.editTextDate);
        schoolName =findViewById(R.id.editTextText2);
        classStandard = findViewById(R.id.editTextText5);

    b1=findViewById(R.id.next1);
    b1.setOnClickListener(
            new View.OnClickListener(){
        @Override
                public void onClick(View v){

            String regs = regNo.getText().toString().trim();
            String schoolNam = schoolName.getText().toString().trim();
            String dobirth = dob.getText().toString().trim();
            String dates = date.getText().toString().trim();
            String ages = age.getText().toString().trim();
            String classstde = classStandard.getText().toString().trim();
            String clientnam = clientname.getText().toString().trim();






            Map<String, Object> user = new HashMap<>();
            user.put("classStandard", classstde);
            user.put("regNo", "regs");
            user.put("schoolName", "schoolNam");
            user.put("dob", "dobirth");
            user.put("date", "dates");
            user.put("clientname", "clientnam");
            user.put("age", "ages");





// Add a new document with a generated ID
            db.collection("client Information")
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



            Intent it=new Intent(Client_Information.this, Client_Information_1.class);
            startActivity(it);
        }
    }

    );
    }
}