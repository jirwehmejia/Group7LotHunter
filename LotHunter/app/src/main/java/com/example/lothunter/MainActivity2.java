package com.example.lothunter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    EditText mTextUsername;
    EditText mTextPassword;
    Button mButtonLogin;
    TextView mTextViewRegister;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main2);

        db = new DatabaseHelper (this);
        mTextUsername = (EditText) findViewById (R.id.username);
        mTextPassword = (EditText) findViewById (R.id.pass);
        mButtonLogin = findViewById (R.id.btnlogin);
        mTextViewRegister = findViewById (R.id.textview_regis);


        mTextViewRegister.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (MainActivity2.this, Register.class);
                startActivity (intent);
            }
        });

        mButtonLogin.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                String user = mTextUsername.getText ().toString ().trim ();
                String pwd = mTextPassword.getText ().toString ().trim ();
                Boolean res = db.checkUser (user, pwd);

                if(res == true)
                {
                    Toast.makeText ( MainActivity2.this, "Successfully Logged In", Toast.LENGTH_SHORT).show();
                    Intent moveToHome = new Intent (MainActivity2.this, HomeActivity.class);
                    startActivity (moveToHome);
                }
                else
                {
                    Toast.makeText ( MainActivity2.this, "Login Error", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}