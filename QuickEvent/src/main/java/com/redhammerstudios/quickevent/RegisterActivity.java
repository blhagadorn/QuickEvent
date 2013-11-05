package com.redhammerstudios.quickevent;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class RegisterActivity extends Activity {
    Button login, create;
    EditText firstName, lastName, phoneNumber;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        //get buttons and edittexts by id
        login = (Button)findViewById(R.id.loginbutton);
        create = (Button)findViewById(R.id.createbutton);
        firstName = (EditText) findViewById(R.id.firstnameedittext);
        lastName = (EditText)findViewById(R.id.lastnameedittext);
        phoneNumber = (EditText)findViewById(R.id.phonenumberedittext);

        









    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.register, menu);
        return true;
    }



}
