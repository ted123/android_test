package com.example.test.myfirstapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Intent;
import android.widget.EditText;
import android.widget.Toast;

public class MyActivity extends AppCompatActivity {
    DatabaseHelper myDb;
    public final static String EXTRA_MESSAGE = "com.example.test.myfirstapp.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        // for db
        myDb = new DatabaseHelper(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /** Called when the user clicks the Send button **/
    public void sendMessage( View view ) {

        Intent intent     = new Intent( this, DisplayMessageActivity.class );
        EditText name     = ( EditText ) findViewById( R.id.name );
        EditText surname  = ( EditText ) findViewById( R.id.surname );
        EditText mark     = ( EditText ) findViewById( R.id.mark );
        String nameStr    = name.getText().toString();
        String surnameStr = name.getText().toString();
        String markStr    = name.getText().toString();

        boolean isInserted = myDb.insertData( nameStr, surnameStr, markStr );

        if ( isInserted ) {
            Toast.makeText( this, "Data inserted successfully", Toast.LENGTH_LONG ).show();
            startActivity(intent);
        } else{
            Toast.makeText(this, "Data not inserted", Toast.LENGTH_LONG).show();
        }

    }
}
