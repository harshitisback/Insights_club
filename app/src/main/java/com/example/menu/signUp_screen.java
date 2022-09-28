package com.example.menu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class signUp_screen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_screen);
    }

    public void usersignup(View view) {
        Intent i1 = new Intent(getApplicationContext(),articles_page_screen.class);
        startActivity(i1);
    }

    public void uploadpic(View view) {
    }

    public void signupgoogle(View view) {
    }

}