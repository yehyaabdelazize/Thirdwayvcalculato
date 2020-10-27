package com.yahya.thirdwayvcalculator.ui.splash;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.yahya.thirdwayvcalculator.R;
import com.yahya.thirdwayvcalculator.databinding.ActivitySplashBinding;
import com.yahya.thirdwayvcalculator.ui.maincalculator.CalcuActivity;


/**
 * The type Splash.
 */
public class Splash extends AppCompatActivity {

    private static int timeOut = 3000;
    /**
     * The Binding.
     */
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