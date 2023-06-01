package com.fedecoder.calculator.operations;

public class Divide extends Operation {
    public Divide(Terminus left, Terminus right) {
        super(left, right);
    }

    @Override
    public double calculate() {
        double l = left.calculate();
        double r = right.calculate();

        return l / r;
    }
}
