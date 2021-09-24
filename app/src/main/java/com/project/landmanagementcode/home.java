package com.project.landmanagementcode;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class home extends AppCompatActivity {

    Button btnbuylogin, btnselllogin, btnregbuy, btnregsell, btnrent, btnsell;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);


        btnbuylogin = (Button) findViewById(R.id.btnbuylogin);
        btnselllogin = (Button) findViewById(R.id.btnsellogin);
        btnregbuy = (Button) findViewById(R.id.btnregbuy);
        btnregsell = (Button) findViewById(R.id.btnregsel);



        btnbuylogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),buyerlogin.class);
                startActivity(intent);
            }
        });

        btnselllogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),buyerlogin.class);
                startActivity(intent);
            }
        });

        btnregbuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),buyerregister.class);
                startActivity(intent);
            }
        });

        btnregsell.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),buyerlogin.class);
                startActivity(intent);
            }
        });



    }


}