package com.example.emailauthentication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Client_Information_2 extends AppCompatActivity {
    Button b4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client_information2);
        b4=findViewById(R.id.submit);
        b4.setOnClickListener(new View.OnClickListener(){
                                  @Override
                                  public void onClick(View v){
                                      Intent it=new Intent(Client_Information_2.this, Genaral_info.class);
                                      startActivity(it);

                                  }
                              }
        );
    }
}