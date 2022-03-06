package com.bbs.sampleproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class LoginActivity extends AppCompatActivity {

    TextInputEditText phone_et, password_et;
    CheckBox isRemembered;
    Button login_bt, registration_bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initVariables();

        login_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userPhone = phone_et.getText().toString().trim();
                String userPassword = password_et.getText().toString().trim();
                if (userPassword != null && userPassword.length()<8){
                    Toast.makeText(LoginActivity.this, "Password length should be 8 char long", Toast.LENGTH_SHORT).show();
                }


                if (userPhone.equals("BBS")){
                    if (userPassword.equalsIgnoreCase("bbs11111")){
                        Intent DashboardPage = new Intent(LoginActivity.this, DashboardActivity.class);
                        startActivity(DashboardPage);
                    }
                    else{
                        Toast.makeText(LoginActivity.this, "Wrong Password", Toast.LENGTH_SHORT).show();
                    }
                }
                else{
                    Toast.makeText(LoginActivity.this, "Wrong Username", Toast.LENGTH_SHORT).show();
                }
            }
        });

        registration_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, RegistrationActivity.class));
            }
        });
    }

    private void initVariables() {
        phone_et = findViewById(R.id.phone_et);
        password_et = findViewById(R.id.password_et);
        isRemembered = findViewById(R.id.is_remembered);
        login_bt = findViewById(R.id.login);
        registration_bt = findViewById(R.id.registration);
    }
}