package com.example.test.myfirstapp;

import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.content.Intent;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class DisplayMessageActivity extends AppCompatActivity {
    DatabaseHelper myDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        // for db
        myDb                = new DatabaseHelper(this);
        Cursor res          = myDb.getAllData();
        StringBuffer buffer = new StringBuffer();

        while ( res.moveToNext() ) {
            buffer.append("Id: " + res.getString( 0 ) + "\n");
            buffer.append("Name: " + res.getString( 1 ) + "\n");
            buffer.append("Surname: " + res.getString( 2 ) + "\n");
            buffer.append("Marks: " + res.getString( 3 ) + "\n\n");
        }

        // for ui
        Intent intent = getIntent();

        TextView textView = new TextView(this);
        textView.setTextSize(12);
        textView.setText(buffer);

        RelativeLayout layout = (RelativeLayout) findViewById(R.id.content);
        layout.addView(textView);
    }

}
