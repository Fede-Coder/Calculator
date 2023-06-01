package com.fedecoder.calculator.operations;

public class Multiply extends Operation {
    public Multiply(Terminus left, Terminus right) {
        super(left, right);
    }

    @Override
    public double calculate() {
        double l = left.calculate();
        double r = right.calculate();

        return l * r;
    }
}
