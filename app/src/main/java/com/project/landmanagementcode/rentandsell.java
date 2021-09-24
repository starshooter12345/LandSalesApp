package com.project.landmanagementcode;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class rentandsell extends AppCompatActivity {

    Button btnrentland, btnbuyland;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rentandsell);

        btnbuyland = (Button) findViewById(R.id.btnbuyland);
        btnrentland = (Button) findViewById(R.id.btnrentland);

//        btnrentland.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(getApplicationContext(),buyerlogin.class);
//                startActivity(intent);
//            }
//        });


        btnbuyland.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });



    }
}