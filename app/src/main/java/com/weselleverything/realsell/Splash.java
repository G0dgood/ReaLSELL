package com.weselleverything.realsell;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_splash);
        getSupportActionBar ().hide ();
        Handler hd = new Handler();
        hd.postDelayed (new Runnable () {
            @Override
            public void run() {
                Intent i = new Intent(Splash.this, Login.class);
                startActivity (i);
                finish ();
            }
        },3000);
    }
}