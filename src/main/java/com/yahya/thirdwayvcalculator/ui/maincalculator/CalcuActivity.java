package com.yahya.thirdwayvcalculator.ui.maincalculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import com.yahya.thirdwayvcalculator.R;
import com.yahya.thirdwayvcalculator.databinding.ActivityCalcuBinding;
import com.yahya.thirdwayvcalculator.pojo.models.OperationModel;

import java.util.ArrayList;
import java.util.List;

public class CalcuActivity extends AppCompatActivity {

    public ActivityCalcuBinding calcuBinding;
    List<OperationModel> list;
    CalcuViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        calcuBinding = DataBindingUtil.setContentView(this, R.layout.activity_calcu);
        viewModel = new ViewModelProvider(this).get(CalcuViewModel.class);
        calcuBinding.setChallenge(viewModel);

        viewModel.Init(calcuBinding, this);

        list = new ArrayList<>();
        CalcuAdapter adapter = new CalcuAdapter(getApplicationContext(), list);
        calcuBinding.recOpers.setLayoutManager(new GridLayoutManager(getApplicationContext(), 3));
        calcuBinding.recOpers.setAdapter(adapter);


        viewModel.getLiveData().observe(this, new Observer<List<OperationModel>>() {
            @Override
            public void onChanged(List<OperationModel> operationModels) {
                list.clear();
                adapter.notifyDataSetChanged();
                list.addAll(operationModels);
                adapter.notifyDataSetChanged();
            }
        });


    }
}