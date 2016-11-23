package com.example.swapniln.mypocket.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.swapniln.mypocket.Database.dbManager;
import com.example.swapniln.mypocket.R;

import java.util.HashMap;

public class LoginActivity extends AppCompatActivity {
    EditText username,password;
    Button btn_login;
    TextView singup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().setTitle(R.string.login_signin);
        username =(EditText)findViewById(R.id.login_username);
        password =(EditText)findViewById(R.id.login_password);
        btn_login =(Button)findViewById(R.id.btn_login);
        singup = (TextView)findViewById(R.id.login_signup);
        singup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent signupAct = new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(signupAct);

            }
        });
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbManager dbmanager = new dbManager(getApplicationContext());
                HashMap list = new HashMap();
                list =dbmanager.login(username.getText().toString(),password.getText().toString());
            }
        });
    }
}
