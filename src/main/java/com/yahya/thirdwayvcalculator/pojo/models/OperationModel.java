package com.yahya.thirdwayvcalculator.pojo.models;

/**
 * The type Operation model.
 */
public class OperationModel {
    /**
     * The Operation.
     */
    String operation;
    /**
     * The Sign.
     */
    String sign;

    /**
     * Gets sign.
     *
     * @return the sign
     */
    public String getSign() {
        return sign;
    }

    /**
     * Sets sign.
     *
     * @param sign the sign
     */
    public void setSign(String sign) {
        this.sign = sign;
    }

    /**
     * Instantiates a new Operation model.
     *
     * @param operation the operation
     * @param sign      the sign
     */
    public OperationModel(String operation, String sign) {
        this.operation = operation;
        this.sign = sign;
    }

    /**
     * Gets operation.
     *
     * @return the operation
     */
    public String getOperation() {
        return operation;
    }

    /**
     * Sets operation.
     *
     * @param operation the operation
     */
    public void setOperation(String operation) {
        this.operation = operation;
    }
}
