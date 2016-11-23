package com.example.swapniln.mypocket.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.swapniln.mypocket.R;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        getSupportActionBar().setTitle(R.string.login_sigup);
    }
}
