package com.soces_fni.mdoser.model;

public final class Water extends AbstractElement {

    /**
     * constructor.
     * @param proportion .
     * @param sandCoefInput .
     */
    public Water(int proportion, int sandCoefInput) {
        super(proportion, sandCoefInput);
    }

    /**
     * quantity of waterr.
     * @return l/m3 mortero.
     */
    @Override
    public double CalculateQuantity() {
        double waterQuantity;
        double proportion = getProportion();
        double sumProportion = CalculateSumProportion();

        // l/m3 mortero
        waterQuantity = ((0.2f * (1 + proportion)) / sumProportion) * 1000;
        return waterQuantity;
    }
}
