package com.redhammerstudios.quickevent;

import android.app.Activity;
import android.content.Intent;
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
    EditText emailAddress, password, birthday;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        //get buttons and edittexts by id
        login = (Button)findViewById(R.id.registerloginbutton);
        create = (Button)findViewById(R.id.registercreatebutton);
        emailAddress = (EditText) findViewById(R.id.registeremailedittext);
        password = (EditText)findViewById(R.id.registerpasswordedittext);
        birthday = (EditText)findViewById(R.id.registerbirthdayedittext);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Intent i = new Intent(RegisterActivity.this,LoginActivity.class);
                    startActivity(i);
            }
        });

        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent (RegisterActivity.this,EventActivity.class);
                i.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                i.putExtra("justRegistered",true);
                startActivity(i);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.register, menu);
        return true;
    }



}
