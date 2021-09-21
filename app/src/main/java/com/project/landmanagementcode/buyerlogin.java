package com.project.landmanagementcode;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class buyerlogin extends AppCompatActivity {

   EditText emaillogin,passwordlogin;
   
   Button btnlogin;
   
   buyerDBhelper buyDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.buyerlogin);
        
        emaillogin = (EditText) findViewById(R.id.emaillogin);
        passwordlogin = (EditText) findViewById(R.id.passwordlogin);
        btnlogin = (Button) findViewById(R.id.btnlogin);
        
        buyDB = new buyerDBhelper(this);
        
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = emaillogin.getText().toString();
                String pass = passwordlogin.getText().toString();
                
                if(user.equals("") || pass.equals("")){
                    Toast.makeText(buyerlogin.this, "Please Enter The Crediantials.", Toast.LENGTH_SHORT).show();
                }
                else
                {
                   Boolean result = buyDB.checkbuyemailpassword(user,pass);
                   if(result==true){
                       Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                       startActivity(intent);
                       
                   }else
                   {
                       Toast.makeText(buyerlogin.this, "Invalid Crediantials.", Toast.LENGTH_SHORT).show();
                   }
                }
            }
        });

    }
}