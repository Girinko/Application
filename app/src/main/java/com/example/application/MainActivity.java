package com.example.application;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    Button btnnext,btnLogin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnnext = findViewById(R.id.loginButton);
        btnLogin = findViewById(R.id.registerButton);

        btnnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Register = new Intent(MainActivity.this, Kalkulator.class);
                startActivity(Register);
            }
        });
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Login = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(Login);
            }
        });
    }


}