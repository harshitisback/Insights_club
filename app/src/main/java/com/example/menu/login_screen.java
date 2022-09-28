package com.example.menu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class login_screen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);
    }


    public void signup(View view) {
        Intent i = new Intent(getApplicationContext(),signUp_screen.class);
        startActivity(i);
    }

    public void forgetpass(View view) {

    }

    public void loginbtn(View view) {

    }

    public void signingoogle(View view) {

    }

}