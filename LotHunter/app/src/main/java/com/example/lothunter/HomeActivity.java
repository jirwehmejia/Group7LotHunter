package com.example.lothunter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeActivity extends AppCompatActivity {

    Button bPF;
    Button bLM;
    Button bLR;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_home);

        bPF = findViewById (R.id.ButtonPF);
        bLM = findViewById (R.id.ButtonLM);
        bLR = findViewById (R.id.ButtonLR);

        bPF.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                Intent moveToPropertyFinder = new Intent (HomeActivity.this, PropertyFinder.class);
                startActivity (moveToPropertyFinder);

                bLM.setOnClickListener (new View.OnClickListener () {
                    @Override
                    public void onClick(View view) {
                        Intent moveToLocationMap = new Intent (HomeActivity.this, LocationMap.class);
                        startActivity (moveToLocationMap);

                        bLR.setOnClickListener (new View.OnClickListener () {
                            @Override
                            public void onClick(View view) {
                                Intent moveToLotReservation = new Intent (HomeActivity.this, LotReservation.class);
                                startActivity (moveToLotReservation);
                            }
                        });
                    }
                });
            }
        });
    }
}