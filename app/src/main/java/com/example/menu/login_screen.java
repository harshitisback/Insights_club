package com.example.menu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class login_screen extends AppCompatActivity {

    private FirebaseAuth auth;
    TextView login;
    Button forgetpass;
    Button signup;
    EditText email, pass;
    String Email, Pass, resetEmail;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);

        // finding ids
        auth = FirebaseAuth.getInstance();
        email = findViewById(R.id.editTextTextPersonName);
        pass = findViewById(R.id.editTextTextPassword);
        login = findViewById(R.id.login_text);

        signup = findViewById(R.id.signupnow);
        forgetpass = (Button) findViewById(R.id.forgetpass);


        // onclick listner
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(login_screen.this, signUp_screen.class));
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validateData();
            }
        });


        // forget password
        forgetpass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetpass();
            }
        });




    }

    private void resetpass() {

        resetEmail = email.getText().toString().trim();

        auth.sendPasswordResetEmail(resetEmail).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(task.isSuccessful()) {
                    Toast.makeText(login_screen.this, "Check your email to reset the password", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(login_screen.this, "Something went wrong", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

//        @Override
//    protected void onStart() {
//        super.onStart();
//        if(auth.getCurrentUser() != null){
//            openHomeScreen();
//        }
//    }

    private void validateData() {
        Email = email.getText().toString();
        Pass = pass.getText().toString();
        if(Email.isEmpty()){
            login.setEnabled(true);
            email.setError("Required");
            email.requestFocus();
        }else if(Pass.isEmpty()){
            login.setEnabled(true);
            pass.setError("Required");
            pass.requestFocus();
        }else {
            loginUser();
        }
    }

    private void loginUser() {
        auth.signInWithEmailAndPassword(Email, Pass)
                .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                    @Override
                    public void onSuccess(AuthResult authResult) {
                        openHomeScreen();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        login.setEnabled(true);
                        Toast.makeText(login_screen.this, "Error: "+e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private void openHomeScreen() {
        startActivity(new Intent(login_screen.this, MainActivity.class));
    }

}