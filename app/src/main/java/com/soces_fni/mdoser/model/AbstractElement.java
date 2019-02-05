package com.soces_fni.mdoser.model;

public abstract class AbstractElement extends AbstractOperation {

    private int proportion;
    private int sandCoefInput;
    private static final float CONCRETE_COEF_INPUT = 0.47f;

    public int getProportion() {
        return proportion;
    }

    public int getSandCoefInput() {
        return sandCoefInput;
    }

    public AbstractElement(int proportion, int sandCoefInput) {
        this.proportion = proportion;
        this.sandCoefInput = sandCoefInput;
    }

    public float CalculateSumProportion() {
        float sum = CONCRETE_COEF_INPUT + proportion * (sandCoefInput / 100)
                + 0.2f * (1 + proportion);
        return sum;
    }
}
