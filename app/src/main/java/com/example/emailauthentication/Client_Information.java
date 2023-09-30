package com.example.emailauthentication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Client_Information extends AppCompatActivity {
    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client_information);


    b1=findViewById(R.id.next1);
    b1.setOnClickListener(new View.OnClickListener(){
        @Override
                public void onClick(View v){
            Intent it=new Intent(Client_Information.this, Client_Information_1.class);
            startActivity(it);
        }
    }

    );
    }
}