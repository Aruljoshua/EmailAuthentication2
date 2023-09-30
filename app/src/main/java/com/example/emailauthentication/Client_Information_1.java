package com.example.emailauthentication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Client_Information_1 extends AppCompatActivity {
    Button b2;
    Button b3;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client_information1);
        b2=findViewById(R.id.next2);
        b3=findViewById(R.id.previous1);
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it=new Intent(Client_Information_1.this, Client_Information.class);
                startActivity(it);

            }
        });
        b2.setOnClickListener(new View.OnClickListener(){
                                  @Override
                                  public void onClick(View v){
                                      Intent it=new Intent(Client_Information_1.this, Client_Information_2.class);
                                      startActivity(it);

                                  }
                              }
        );

    }

    }
