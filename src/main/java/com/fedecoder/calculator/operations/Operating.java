package com.fedecoder.calculator.operations;

public class Operating implements Terminus {
    double value;

    public Operating(double value) {
        this.value = value;
    }

    public double calculate() {
        return value;
    }
}
