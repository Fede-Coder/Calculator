package com.fedecoder.calculator.operations;

public abstract class Operation implements Terminus {
    Terminus left;
    Terminus right;

    public Operation(Terminus left, Terminus right) {
        this.left = left;
        this.right = right;
    }
}
