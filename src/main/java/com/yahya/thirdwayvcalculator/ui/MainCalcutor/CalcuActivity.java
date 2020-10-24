package com.yahya.thirdwayvcalculator.ui.MainCalcutor;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;

import com.yahya.thirdwayvcalculator.R;
import com.yahya.thirdwayvcalculator.databinding.ActivityCalcuBinding;
import com.yahya.thirdwayvcalculator.databinding.ActivitySplashBinding;

public class CalcuActivity extends AppCompatActivity {

    ActivityCalcuBinding calcuBinding;
    double num;
    double result = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        calcuBinding = DataBindingUtil.setContentView(this, R.layout.activity_calcu);

        double result = 0;
        calcuBinding.tvResult.setText("" + result);


        // impl on clicking button ( + )
        calcuBinding.btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calcuBinding.tvSecOpr.setText(calcuBinding.btnPlus.getText().toString());
                calcuBinding.btnMinus.setEnabled(false);
                calcuBinding.btnMultyply.setEnabled(false);
                calcuBinding.btnDivision.setEnabled(false);
            }
        });

        // impl on clicking button ( - )
        calcuBinding.btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calcuBinding.tvSecOpr.setText(calcuBinding.btnMinus.getText().toString());
                calcuBinding.btnPlus.setEnabled(false);
                calcuBinding.btnMultyply.setEnabled(false);
                calcuBinding.btnDivision.setEnabled(false);
                view.setFocusableInTouchMode(false);
            }
        });


        // impl on clicking button ( * )
        calcuBinding.btnMultyply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calcuBinding.tvSecOpr.setText(calcuBinding.btnMultyply.getText().toString());
                calcuBinding.btnMinus.setEnabled(false);
                calcuBinding.btnPlus.setEnabled(false);
                calcuBinding.btnDivision.setEnabled(false);
                view.setFocusableInTouchMode(false);
            }
        });

        // impl on clicking button ( / )
        calcuBinding.btnDivision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calcuBinding.tvSecOpr.setText(calcuBinding.btnDivision.getText().toString());
                calcuBinding.btnMinus.setEnabled(false);
                calcuBinding.btnPlus.setEnabled(false);
                calcuBinding.btnMultyply.setEnabled(false);
                view.setFocusableInTouchMode(false);
            }
        });


        // impl on clicking button ( = )
        calcuBinding.btnEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num = Double.parseDouble(calcuBinding.etNum2.getText().toString());
                double res;
                switch (calcuBinding.tvSecOpr.getText().toString()) {
                    case "+":
                        res = num +result;
                        calcuBinding.tvResult.setText(""+res);
                    case "-":
                        res = num -result;
                        calcuBinding.tvResult.setText(""+res);
                    case "*":
                        res = num *result;
                        calcuBinding.tvResult.setText(""+res);
                    case "/":
                        res = num /result;
                        calcuBinding.tvResult.setText(""+res);
                }

            }
        });


    }
}