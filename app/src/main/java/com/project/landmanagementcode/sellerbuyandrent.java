package com.project.landmanagementcode;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class sellerbuyandrent extends AppCompatActivity {

    Button btnsellersell, btnsellrent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sellerbuyandrent);


        btnsellersell = (Button) findViewById(R.id.btnsellersell);
        btnsellrent = (Button) findViewById(R.id.btnsellerrent);


        btnsellersell.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),AddRecordActivity.class);
                startActivity(intent);
            }
        });

//        btnsellrent.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
//                startActivity(intent);
//            }
//        });
    }
}