package com.example.lothunter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Register extends AppCompatActivity {
    DatabaseHelper db;
    EditText mTextUsername;
    EditText mTextPassword;
    EditText mTextCfrPassword;
    Button mButtonSignup;
    TextView mTextViewRegis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_register);

        db = new DatabaseHelper (this);
        mTextUsername = (EditText) findViewById (R.id.userregis);
        mTextPassword = (EditText) findViewById (R.id.password);
        mTextCfrPassword = findViewById (R.id.confirmpass);
        mButtonSignup = findViewById (R.id.btnsingup2);
        mTextViewRegis = findViewById (R.id.ArTextView);

        mButtonSignup.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (Register.this, MainActivity2.class);
                startActivity (intent);
            }
        });
        mButtonSignup.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                String user = mTextUsername.getText ().toString ().trim ();
                String pwd = mTextPassword.getText ().toString ().trim ();
                String cnf_pwd = mTextCfrPassword.getText ().toString ().trim ();

                if (pwd.equals (cnf_pwd)){
                    long val = db.addUser (user,pwd);
                    if(val>0){
                        Toast.makeText ( Register.this, "You have registered", Toast.LENGTH_SHORT).show();
                        Intent moveToLogin = new Intent (Register.this, MainActivity2.class);
                        startActivity (moveToLogin);
                    }
                    else{
                        Toast.makeText ( Register.this, "Registration Error", Toast.LENGTH_SHORT).show();

                    }

                }
                else
                {
                    Toast.makeText ( Register.this, "Password is not matching", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}