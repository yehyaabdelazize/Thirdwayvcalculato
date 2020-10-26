package com.yahya.thirdwayvcalculator.ui.MainCalcutor;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.GridLayoutManager;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.yahya.thirdwayvcalculator.R;
import com.yahya.thirdwayvcalculator.databinding.ActivityCalcuBinding;
import com.yahya.thirdwayvcalculator.pojo.models.OperationModel;

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
        list = new ArrayList<>();
        // initialling variable Result on starting with zero (0.0)
        calcuBinding.tvResult.setText("" + result);
//

        // impl on clicking button ( + )
        calcuBinding.btnPlus.setOnClickListener(view -> {
            calcuBinding.tvOper.setText(calcuBinding.btnPlus.getText().toString());
            calcuBinding.btnMinus.setEnabled(false);
            calcuBinding.btnMultyply.setEnabled(false);
            calcuBinding.btnDivision.setEnabled(false);
            calcuBinding.tvOper.setVisibility(View.VISIBLE);
            calcuBinding.etSecOper.setHint("");

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

        CalcuAdapter adapter = new CalcuAdapter(getApplicationContext(), list);

        // impl on clicking button ( / )
        calcuBinding.btnEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (calcuBinding.etSecOper.toString().isEmpty() && calcuBinding.tvOper.toString().isEmpty()) {
                    Toast.makeText(CalcuActivity.this, "You Must Enter Operator First Then Number ...", Toast.LENGTH_SHORT).show();
                } else {
                    calcu_operation();

                    String fulloper = calcuBinding.tvOper.getText().toString() + calcuBinding.etSecOper.getText().toString();

                    list.add(new OperationModel(fulloper));
                    adapter.notifyDataSetChanged();

                    calcuBinding.tvOper.setText("");
                    calcuBinding.etSecOper.setText("");
                    calcuBinding.etSecOper.setHint("please enter the second operand");


                    calcuBinding.btnMinus.setEnabled(true);
                    calcuBinding.btnPlus.setEnabled(true);
                    calcuBinding.btnMultyply.setEnabled(true);
                    calcuBinding.btnDivision.setEnabled(true);

                }
            }
        });


        calcuBinding.recOpers.setLayoutManager(new GridLayoutManager(getApplicationContext(), 3));
        calcuBinding.recOpers.setAdapter(adapter);
    }

    //impl of calculation the operation for the Result
    public void calcu_operation() {

        String op = calcuBinding.tvOper.getText().toString().trim();
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