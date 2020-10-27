package com.yahya.thirdwayvcalculator.pojo.models;

public class OperationModel {
    String operation;
    String sign;

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public OperationModel(String operation, String sign) {
        this.operation = operation;
        this.sign = sign;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }
}
