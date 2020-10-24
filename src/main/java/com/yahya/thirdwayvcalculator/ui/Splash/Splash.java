package com.yahya.thirdwayvcalculator.ui.Splash;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import com.yahya.thirdwayvcalculator.R;
import com.yahya.thirdwayvcalculator.databinding.ActivitySplashBinding;
import com.yahya.thirdwayvcalculator.ui.MainCalcutor.CalcuActivity;

public class Splash extends AppCompatActivity {

    private static int timeOut = 3000;
    ActivitySplashBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_splash);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent nextIntent = new Intent(Splash.this, CalcuActivity.class);
                startActivity(nextIntent);
                finish();
            }
        }, timeOut);

    }

    @Override
    public void finish() {
        super.finish();
    }
}