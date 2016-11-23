package com.example.swapniln.mypocket.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.swapniln.mypocket.Database.dbManager;
import com.example.swapniln.mypocket.R;

public class RegisterActivity extends AppCompatActivity {
    Button signup;
    EditText name,mobile,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        getSupportActionBar().setTitle(R.string.login_sigup);
        name = (EditText) findViewById(R.id.register_name);
        mobile = (EditText) findViewById(R.id.register_username);
        password = (EditText) findViewById(R.id.register_password);
        signup = (Button) findViewById(R.id.btn_register);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbManager  dbm= new dbManager(getApplicationContext());
                dbm.register(name.getText().toString(),mobile.getText().toString(),password.getText().toString());
            }
        });
    }
}
