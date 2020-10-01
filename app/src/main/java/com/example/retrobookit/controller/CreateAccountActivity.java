package com.example.retrobookit.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.retrobookit.MainActivity;
import com.example.retrobookit.R;

public class CreateAccountActivity extends AppCompatActivity {

    private Button createAccountButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        createAccountButton=findViewById(R.id.createAccountButton);
        createAccountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(CreateAccountActivity.this,"Account Created",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(CreateAccountActivity.this, MainActivity.class));
            }
        });

    }
}