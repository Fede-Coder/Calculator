package com.fedecoder.calculator.operations;

public class Addition extends Operation {
    public Addition(Terminus left, Terminus right) {
        super(left, right);
    }

    @Override
    public double calculate() {
        double l = left.calculate();
        double r = right.calculate();

        return l + r;
    }
}
