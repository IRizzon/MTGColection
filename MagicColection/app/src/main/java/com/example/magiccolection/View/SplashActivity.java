package com.example.magiccolection.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.magiccolection.R;

public class SplashActivity extends AppCompatActivity {

    public static final int TIME_OUT_SPLASH = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        TelaSplash();
    }

    private void TelaSplash(){

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent telaLogin = new Intent(SplashActivity.this, LoginActivity.class);
                startActivity(telaLogin);
                finish();

            }
        }, TIME_OUT_SPLASH);

    }
}