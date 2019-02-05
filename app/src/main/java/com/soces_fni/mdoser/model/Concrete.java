package com.soces_fni.mdoser.model;

public final class Concrete extends AbstractElement {

    // kg/m3 mortero
    private static final float DENSITY = 1400;

    public Concrete(int proportion, int sandCoefInput) {
        super(proportion, sandCoefInput);
    }

    @Override
    public float CalculateQuantity() {
        float concreteQuantity;
        float sumProportion = CalculateSumProportion();
        concreteQuantity = (1 / sumProportion) * DENSITY;
        return concreteQuantity;
    }
}
