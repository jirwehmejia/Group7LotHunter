package com.example.lothunter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static int SPLASH_SCREEN=2500;
    ImageView imageView;
    TextView text1, text2;
    Animation top, bottom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main);

        getWindow ().setFlags (WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView (R.layout.activity_main);

        imageView = findViewById (R.id.logo);
        text1 = findViewById (R.id.text1);
        text2 = findViewById (R.id.text2);

        top = AnimationUtils.loadAnimation (this, R.anim.top);
        bottom = AnimationUtils.loadAnimation (this, R.anim.bottom);

        imageView.setAnimation (top);
        text1.setAnimation (bottom);
        text2.setAnimation (bottom);

        new Handler ().postDelayed (new Runnable () {
            @Override
            public void run() {
                Intent intent = new Intent (MainActivity.this, MainActivity2.class);
                startActivity (intent);
                finish ();
            }
        },SPLASH_SCREEN);
    }
}