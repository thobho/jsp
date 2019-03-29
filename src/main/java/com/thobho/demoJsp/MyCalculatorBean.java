package com.thobho.demoJsp;

import java.io.Serializable;

public class MyCalculatorBean implements Serializable {
    private int addingNumber;
    private int multiplyNumber;

    public int add(int number) {
        return addingNumber + number;
    }

    int multiply(int number) {
        return multiplyNumber * number;
    }

    public int getAddingNumber() {
        return addingNumber;
    }

    public void setAddingNumber(int addingNumber) {
        this.addingNumber = addingNumber;
    }

    public int getMultiplyNumber() {
        return multiplyNumber;
    }

    public void setMultiplyNumber(int multiplyNumber) {
        this.multiplyNumber = multiplyNumber;
    }
}
