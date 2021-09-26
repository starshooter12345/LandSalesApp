package com.project.landmanagementcode;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class rentmain extends AppCompatActivity {
    FloatingActionButton flac;
    ActionBar actionBar;
    RecyclerView mRecyclerView;
    DatabaseHelper databaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        actionBar = getSupportActionBar();
        actionBar.setTitle("Rental properties");

        mRecyclerView = findViewById(R.id.recyclerView);
        databaseHelper = new DatabaseHelper(this);

        showRecord();

        flac=findViewById(R.id.addFabButton);


        flac.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(rentmain.this, AddRecordActivity.class);
                intent.putExtra("editMode",false);
                startActivity(intent);
            }
        });
    }
    private void showRecord(){
        Adapter adapter = new Adapter(rentmain.this, databaseHelper.getAllData(Constants.C_ADD_TIMESTAMP + " DESC"));
        mRecyclerView.setAdapter(adapter);

    }
    protected void onResume(){
        super.onResume();
        showRecord();
    }
