package com.yahya.thirdwayvcalculator.ui.MainCalcutor;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.GridLayoutManager;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;

import com.yahya.thirdwayvcalculator.R;
import com.yahya.thirdwayvcalculator.databinding.ActivityCalcuBinding;
import com.yahya.thirdwayvcalculator.databinding.ActivitySplashBinding;
import com.yahya.thirdwayvcalculator.pojo.models.OperationModel;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class CalcuActivity extends AppCompatActivity {

    ActivityCalcuBinding calcuBinding;
    double result = 0;
    double num2;
    List<OperationModel> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        calcuBinding = DataBindingUtil.setContentView(this, R.layout.activity_calcu);

        // initialling variable Result on starting with zero (0.0)
        calcuBinding.tvResult.setText("" + result);


//        list = new ArrayList<>();
//        CalcuAdapter adapter = new CalcuAdapter(this, list);
//        calcuBinding.recOpers.setLayoutManager(new GridLayoutManager(this, 3));
//

        // impl on clicking button ( + )
        calcuBinding.btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calcuBinding.tvOper.setText(calcuBinding.btnPlus.getText().toString() + "  ");
                calcuBinding.btnMinus.setEnabled(false);
                calcuBinding.btnMultyply.setEnabled(false);
                calcuBinding.btnDivision.setEnabled(false);
                calcuBinding.tvOper.setVisibility(View.VISIBLE);
                calcuBinding.etSecOper.setHint("");
            }
        });

        // impl on clicking button ( - )
        calcuBinding.btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calcuBinding.tvOper.setText(calcuBinding.btnMinus.getText().toString() + "  ");
                calcuBinding.btnPlus.setEnabled(false);
                calcuBinding.btnMultyply.setEnabled(false);
                calcuBinding.btnDivision.setEnabled(false);
                calcuBinding.tvOper.setVisibility(View.VISIBLE);
                calcuBinding.etSecOper.setHint("");
            }
        });


        // impl on clicking button ( * )
        calcuBinding.btnMultyply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calcuBinding.tvOper.setText(calcuBinding.btnMultyply.getText().toString() + "  ");
                calcuBinding.btnMinus.setEnabled(false);
                calcuBinding.btnPlus.setEnabled(false);
                calcuBinding.btnDivision.setEnabled(false);
                calcuBinding.tvOper.setVisibility(View.VISIBLE);
                calcuBinding.etSecOper.setHint("");

            }
        });

        // impl on clicking button ( / )
        calcuBinding.btnDivision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calcuBinding.tvOper.setText(calcuBinding.btnDivision.getText().toString() + "  ");
                calcuBinding.btnMinus.setEnabled(false);
                calcuBinding.btnPlus.setEnabled(false);
                calcuBinding.btnMultyply.setEnabled(false);
                calcuBinding.tvOper.setVisibility(View.VISIBLE);
                calcuBinding.etSecOper.setHint("");

            }
        });

        // impl on clicking button ( / )
        calcuBinding.btnEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calcuBinding.btnMinus.setEnabled(false);
                calcuBinding.btnPlus.setEnabled(false);
                calcuBinding.btnMultyply.setEnabled(false);
                calcuBinding.btnDivision.setEnabled(false);

                calcu_operation();


            }
        });

    }

    //impl of calculation the operation for the Result
    public void calcu_operation() {

        String op = calcuBinding.tvOper.getText().toString();
        num2 = Double.parseDouble(calcuBinding.etSecOper.getText().toString());

        switch (op) {
            case "+":
                result += num2;
                calcuBinding.tvResult.setText("" + result);
                break;
            case "-":
                result -= num2;
                calcuBinding.tvResult.setText("" + result);
                break;
            case "*":
                result *= num2;
                calcuBinding.tvResult.setText("" + result);
                break;
            case "/":
                result /= num2;
                calcuBinding.tvResult.setText("" + result);
                break;
        }
    }
}