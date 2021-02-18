package com.example.retrobookit.controller;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.retrobookit.MainActivity;
import com.example.retrobookit.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {
    private EditText email;
    private EditText password;
    private Button loginButton;

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
            loginButton=findViewById(R.id.loginButton);
            email= findViewById(R.id.loginUsername);
            password=findViewById(R.id.loginPassword);
            mAuth=FirebaseAuth.getInstance();

         loginButton.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 String emailString= email.getText().toString();
                 String passwordString=password.getText().toString();

                 if(!emailString.equals("") && !passwordString.equals("")) {

                     mAuth.signInWithEmailAndPassword(emailString,passwordString)
                             .addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                                 @Override
                                 public void onComplete(@NonNull Task<AuthResult> task) {
                                     if(!task.isSuccessful()) {
                                         Toast.makeText(LoginActivity.this,"Failed Sign In",Toast.LENGTH_LONG).show();
                                     }
                                     else{
                                         startActivity(new Intent(LoginActivity.this,HomeActivity.class));
                                         Toast.makeText(LoginActivity.this,"Successfully Sign In",Toast.LENGTH_LONG).show();

                                     }
                                 }
                             });
                 }



             }
         });

    }
}