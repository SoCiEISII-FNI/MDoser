package com.soces_fni.mdoser.model;

/**
 * class for sand.
 */
public final class Sand extends AbstractElement {

    /**
     * constructor.
     * @param proportion .
     * @param sandCoefInput .
     */
    public Sand(int proportion, int sandCoefInput) {
        super(proportion, sandCoefInput);
    }

    /**
     * quantity of sand.
     * @return m3 sand / m3 mortero.
     */
    @Override
    public double CalculateQuantity() {
        double sandQuantity;
        double proportion = getProportion();
        double sumProportion = CalculateSumProportion();

        // m3 sand / m3 mortero
        sandQuantity = proportion / sumProportion;
        return sandQuantity;
    }
}
