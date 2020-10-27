package com.yahya.thirdwayvcalculator.ui.maincalculator;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.yahya.thirdwayvcalculator.R;
import com.yahya.thirdwayvcalculator.databinding.ActivityCalcuBinding;
import com.yahya.thirdwayvcalculator.pojo.models.OperationModel;

import java.util.ArrayList;
import java.util.List;

public class CalcuViewModel extends ViewModel {
    MutableLiveData<List<OperationModel>> liveData = new MutableLiveData<>();
    ActivityCalcuBinding calcuBinding;
    Context c;
    double result = 0;
    double num2;
    List<OperationModel> list;


    public void Init(ActivityCalcuBinding binding, Context context) {
        this.calcuBinding = binding;
        this.c = context;
        liveData = new MutableLiveData<>();
        list = new ArrayList<>();
        liveData.setValue(list);
    }

    public LiveData<List<OperationModel>> getLiveData() {
        return liveData;
    }

    @SuppressLint("SetTextI18n")
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_undo:
                break;

            case R.id.btn_redo:
                break;

            case R.id.btn_plus:
                calcuBinding.tvOper.setText(calcuBinding.btnPlus.getText().toString());
                calcuBinding.btnMinus.setEnabled(false);
                calcuBinding.btnMultyply.setEnabled(false);
                calcuBinding.btnDivision.setEnabled(false);
                calcuBinding.tvOper.setVisibility(View.VISIBLE);
                calcuBinding.etSecOper.setHint("");
                break;

            case R.id.btn_minus:
                calcuBinding.tvOper.setText(calcuBinding.btnMinus.getText().toString() + "  ");
                calcuBinding.btnPlus.setEnabled(false);
                calcuBinding.btnMultyply.setEnabled(false);
                calcuBinding.btnDivision.setEnabled(false);
                calcuBinding.tvOper.setVisibility(View.VISIBLE);
                calcuBinding.etSecOper.setHint("");
                break;

            case R.id.btn_multyply:
                calcuBinding.tvOper.setText(calcuBinding.btnMultyply.getText().toString() + "  ");
                calcuBinding.btnMinus.setEnabled(false);
                calcuBinding.btnPlus.setEnabled(false);
                calcuBinding.btnDivision.setEnabled(false);
                calcuBinding.tvOper.setVisibility(View.VISIBLE);
                calcuBinding.etSecOper.setHint("");
                break;

            case R.id.btn_division:
                calcuBinding.tvOper.setText(calcuBinding.btnDivision.getText().toString() + "  ");
                calcuBinding.btnMinus.setEnabled(false);
                calcuBinding.btnPlus.setEnabled(false);
                calcuBinding.btnMultyply.setEnabled(false);
                calcuBinding.tvOper.setVisibility(View.VISIBLE);
                calcuBinding.etSecOper.setHint("");
                break;
            case R.id.btn_equal:

                if (TextUtils.isEmpty(calcuBinding.etSecOper.getText().toString()) && TextUtils.isEmpty(calcuBinding.tvOper.getText().toString())) {
                    Toast.makeText(c, "You Must Enter Operator First Then Number ...", Toast.LENGTH_SHORT).show();
                } else {

                    calcu_operation();

                    String op=calcuBinding.tvOper.getText().toString();
                    String num=calcuBinding.etSecOper.getText().toString();
                    list.add(new OperationModel(num,op));
                    liveData.setValue(list);
                    calcuBinding.tvOper.setText("");
                    calcuBinding.etSecOper.setText("");
                    calcuBinding.etSecOper.setHint("please enter the second operand");

                    calcuBinding.btnMinus.setEnabled(true);
                    calcuBinding.btnPlus.setEnabled(true);
                    calcuBinding.btnMultyply.setEnabled(true);
                    calcuBinding.btnDivision.setEnabled(true);
                    break;

                }

        }


    }


    //impl of calculation the operation for the Result
    @SuppressLint("SetTextI18n")
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
