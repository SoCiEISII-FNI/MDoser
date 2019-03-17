package com.soces_fni.mdoser.model;

public final class Concrete extends AbstractElement {

    // kg/m3 mortero
    private static final float DENSITY = 1400;

    /**
     * constructor.
     * @param proportion .
     * @param sandCoefInput .
     */
    public Concrete(int proportion, int sandCoefInput) {
        super(proportion, sandCoefInput);
    }

    /**
     * quantity of concrete.
     * @return kg/m3 mortero.
     */
    @Override
    public double CalculateQuantity() {
        double concreteQuantity;
        double sumProportion = CalculateSumProportion();
        concreteQuantity = (1 / sumProportion) * DENSITY;
        return concreteQuantity;
    }
}
