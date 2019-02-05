package com.soces_fni.mdoser.model;

public final class Water extends AbstractElement {

    public Water(int proportion, int sandCoefInput) {
        super(proportion, sandCoefInput);
    }

    @Override
    public float CalculateQuantity() {
        float waterQuantity;
        float proportion = getProportion();
        float sumProportion = CalculateSumProportion();

        // l/m3 mortero
        waterQuantity = ((0.2f * (1 + proportion)) / sumProportion) * 1000;
        return waterQuantity;
    }
}
