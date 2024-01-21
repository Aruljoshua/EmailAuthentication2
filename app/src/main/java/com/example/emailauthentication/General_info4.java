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

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class General_info4 extends AppCompatActivity {

    private Button btn1;
    private Button btn2;
    private EditText Specify, weight, mention,OtherSpecify, MedicationNames;
    FirebaseFirestore db;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_general_info4);

        db = FirebaseFirestore.getInstance();
        mAuth = FirebaseAuth.getInstance();
        Specify = findViewById(R.id.editTextText40);
        weight = findViewById(R.id.editTextText45);
        mention = findViewById(R.id.editTextText46);
        OtherSpecify = findViewById(R.id.editTextText47);
        MedicationNames = findViewById(R.id.editTextText48);



        btn2 = findViewById(R.id.button5);
        btn1 = findViewById(R.id.button7);

        btn1.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        String S = Specify.getText().toString().trim();
                        String We = weight.getText().toString().trim();
                        String Men = mention.getText().toString().trim();
                        String OtherS = OtherSpecify.getText().toString().trim();
                        String Mname = MedicationNames.getText().toString().trim();




                        Map<String, Object> user = new HashMap<>();
                        user.put("Specify", S);
                        user.put("weight", We);
                        user.put("mention", Men);
                        user.put("OtherSpecify", OtherS);
                        user.put("MedicationNames", Mname);




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

                        Map<String, Object> checkboxes = new HashMap<>();

// Add each checkbox value to the Map
                        CheckBox checkBox77 = findViewById(R.id.checkBox77);
                        checkboxes.put("h_no_health_issues", checkBox77.isChecked());

                        CheckBox checkBox76 = findViewById(R.id.checkBox76);
                        checkboxes.put("e_convulsion_seizures", checkBox76.isChecked());

                        CheckBox checkBox75 = findViewById(R.id.checkBox75);
                        checkboxes.put("d_head_injury", checkBox75.isChecked());

                        CheckBox checkBox74 = findViewById(R.id.checkBox74);
                        checkboxes.put("c_allergic_conditions", checkBox74.isChecked());

                        CheckBox checkBox73 = findViewById(R.id.checkBox73);
                        checkboxes.put("b_respiratory_infections", checkBox73.isChecked());

                        CheckBox checkBox71 = findViewById(R.id.checkBox71);
                        checkboxes.put("iii_feeble", checkBox71.isChecked());

                        CheckBox checkBox67 = findViewById(R.id.checkBox67);
                        checkboxes.put("iii_post_mature", checkBox67.isChecked());

                        CheckBox checkBox66 = findViewById(R.id.checkBox66);
                        checkboxes.put("ii_pre_mature", checkBox66.isChecked());

                        CheckBox checkBox62 = findViewById(R.id.checkBox62);
                        checkboxes.put("b_umbilical_cord_twisting", checkBox62.isChecked());

                        CheckBox checkBox61 = findViewById(R.id.checkBox61);
                        checkboxes.put("e_breech_delivery", checkBox61.isChecked());

                        CheckBox checkBox60 = findViewById(R.id.checkBox60);
                        checkboxes.put("c_prolonged_delivery", checkBox60.isChecked());

                        CheckBox checkBox58 = findViewById(R.id.checkBox58);
                        checkboxes.put("iii_forceps", checkBox58.isChecked());

                        CheckBox checkBox56 = findViewById(R.id.checkBox56);
                        checkboxes.put("ii_caesarean", checkBox56.isChecked());

                        CheckBox checkBox53 = findViewById(R.id.checkBox53);
                        checkboxes.put("i_normal", checkBox53.isChecked());

                        CheckBox checkBox57 = findViewById(R.id.checkBox57);
                        checkboxes.put("iv_suction", checkBox57.isChecked());

                        CheckBox checkBox59 = findViewById(R.id.checkBox59);
                        checkboxes.put("d_precipitate_delivery", checkBox59.isChecked());

                        CheckBox checkBox65 = findViewById(R.id.checkBox65);
                        checkboxes.put("i_full_term", checkBox65.isChecked());

                        CheckBox checkBox68 = findViewById(R.id.checkBox68);
                        checkboxes.put("i_immediate", checkBox68.isChecked());

                        CheckBox checkBox69 = findViewById(R.id.checkBox69);
                        checkboxes.put("ii_delayed", checkBox69.isChecked());

                        CheckBox checkBox72 = findViewById(R.id.checkBox72);
                        checkboxes.put("a_infantile_jaundice", checkBox72.isChecked());

// Add the Map to Firestore
                        db.collection("checkboxes").document("checkbox_values").set(checkboxes)
                                .addOnSuccessListener(new OnSuccessListener<Void>() {
                                    @Override
                                    public void onSuccess(Void aVoid) {
                                        Log.d(TAG, "Checkbox values successfully stored in Firestore.");
                                    }
                                })
                                .addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        Log.w(TAG, "Error storing checkbox values in Firestore.", e);
                                    }
                                });


                       Intent it = new Intent(General_info4.this, General_info5.class);
                       startActivity(it);
                    }
                }

        );

        btn2.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                       Intent it = new Intent(General_info4.this, Genaral_info2.class);
                                      startActivity(it);

                                    }
                                }
        );
    }
}