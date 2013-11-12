package com.redhammerstudios.quickevent;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.text.InputType;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Activity which displays a login screen to the user, offering registration as
 * well.
 */
public class LoginActivity extends Activity {

    EditText emailEditText, passwordEditText;
    Button loginButton, notRegisteredButton;
    CheckBox staySignedInCheckBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Boolean emailChanged = false;
        Boolean passwordChanged = false;

        setContentView(R.layout.activity_login);
        emailEditText = (EditText) findViewById(R.id.loginemailaddressedittext);
        passwordEditText = (EditText) findViewById(R.id.loginpasswordedittext);
        loginButton = (Button) findViewById(R.id.loginloginbutton);
        notRegisteredButton = (Button) findViewById(R.id.loginnotregisteredbutton);
        staySignedInCheckBox = (CheckBox) findViewById(R.id.loginstaysignedincheckbox);

        emailEditText.setText("example@email.com");

        passwordEditText.setInputType(InputType.TYPE_CLASS_TEXT);
        passwordEditText.setText("password");

        emailEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(emailEditText.getText().toString().equals("example@email.com")){
                    emailEditText.setText("");
                }
            }
        });

        passwordEditText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus == true){
                    passwordEditText.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                    passwordEditText.setText("");
                }
            }
        });

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(staySignedInCheckBox.isChecked()==true){
                    SharedPreferences prefs = LoginActivity.this.getSharedPreferences(
                            "com.redhammerstudios.quickevent", Context.MODE_PRIVATE);
                    prefs.edit().putBoolean("staySignedIn",true);
                }

            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        return true;
    }
}
