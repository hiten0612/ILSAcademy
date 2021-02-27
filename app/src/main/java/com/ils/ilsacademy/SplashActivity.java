package com.ils.ilsacademy;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {
    private SharedPreferenceConfig sharedPreferenceConfig;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        sharedPreferenceConfig = new SharedPreferenceConfig(SplashActivity.this);

        new Handler().postDelayed(() -> {
            if(sharedPreferenceConfig.getLoginStatus()){
                Intent intent = new Intent(SplashActivity.this, DeshBoard.class);
                startActivity(intent);
                finish();
            }else{
                Intent intent = new Intent(SplashActivity.this, Login.class);
                startActivity(intent);
                finish();
            }
        }, 3000);
    }
}