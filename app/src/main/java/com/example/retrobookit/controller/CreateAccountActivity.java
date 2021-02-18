package com.example.retrobookit.controller;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
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

public class CreateAccountActivity extends AppCompatActivity {

    private Button createAccountButton;
    private EditText email;
    private EditText password;

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        createAccountButton=findViewById(R.id.createAccountButton);
        email= findViewById(R.id.createActUsername);
        password=findViewById(R.id.createActPassword);
        mAuth=FirebaseAuth.getInstance();


        createAccountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emailString= email.getText().toString();
                String passwordString=password.getText().toString();

                if(!emailString.equals("") && !passwordString.equals("")){
                    mAuth.createUserWithEmailAndPassword(emailString,passwordString)
                            .addOnCompleteListener(CreateAccountActivity.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if(!task.isSuccessful()) {
                                        Toast.makeText(CreateAccountActivity.this,"Failed Sign Up",Toast.LENGTH_LONG).show();
                                    }
                                    else{
                                        Toast.makeText(CreateAccountActivity.this,"Account Created",Toast.LENGTH_SHORT).show();
                                        startActivity(new Intent(CreateAccountActivity.this, MainActivity.class));

                                    }
                                }
                            });


                }



            }
        });

    }
}