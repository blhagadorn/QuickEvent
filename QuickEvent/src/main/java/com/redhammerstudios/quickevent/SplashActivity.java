package com.redhammerstudios.quickevent;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.Button;

public class SplashActivity extends Activity {

    Button login, register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);



        login = (Button)findViewById(R.id.splashloginbutton);
        register = (Button) findViewById(R.id.splashregisterbutton);

        login.setOnClickListener();

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.splash, menu);
        return true;
    }


    public boolean checkIfLoggedIn(){
        SharedPreferences prefs = this.getSharedPreferences(
                "com.redhammerstudios.quickevent", Context.MODE_PRIVATE);
        return prefs.getBoolean("skipLogin",false);
    }
    
}
