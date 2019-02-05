package com.soces_fni.mdoser.model;

public final class Sand extends AbstractElement {
    public Sand(int proportion, int sandCoefInput) {
        super(proportion, sandCoefInput);
    }

    @Override
    public float CalculateQuantity() {
        float sandQuantity;
        float proportion = getProportion();
        float sumProportion = CalculateSumProportion();

        // m3 sand / m3 mortero
        sandQuantity = proportion / sumProportion;
        return sandQuantity;
    }
}
