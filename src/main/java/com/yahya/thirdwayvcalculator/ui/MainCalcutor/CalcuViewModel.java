package com.yahya.thirdwayvcalculator.ui.MainCalcutor;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.yahya.thirdwayvcalculator.pojo.models.OperationModel;

import java.util.Observable;

public class CalcuViewModel extends ViewModel {

    MutableLiveData<OperationModel> liveData=new MutableLiveData<>();

}
