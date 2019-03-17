package com.soces_fni.mdoser.model;

public abstract class AbstractElement extends AbstractOperation {

    private int proportion;
    private int sandCoefInput;
    private static final float CONCRETE_COEF_INPUT = 0.47f;

    /**
     * getter for proportion value.
     * @return int.
     */
    public int getProportion() {
        return proportion;
    }

    /**
     * getter for coeficient of sand.
     * @return int.
     */
    public int getSandCoefInput() {
        return sandCoefInput;
    }

    /**
     * constructor.
     * @param proportion .
     * @param sandCoefInput .
     */
    public AbstractElement(int proportion, int sandCoefInput) {
        this.proportion = proportion;
        this.sandCoefInput = sandCoefInput;
    }

    /**
     * precalcule for post quantities.
     * @return float.
     */
    public double CalculateSumProportion() {
        double sum = CONCRETE_COEF_INPUT + (proportion * (sandCoefInput / 100f))
                + (0.2f * (1f + proportion));
        return sum;
    }
}
