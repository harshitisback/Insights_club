package com.example.menu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

public class profile_page_screen extends AppCompatActivity {

    ImageView back;
    ImageView profilepic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_page_screen);
        profilepic = findViewById(R.id.profile_pic_);




    }
}