package com.soces_fni.mdoser.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class WaterTest {
    public static final int PROPORTION = 1;
    public static final int COEF = 50;
    public static final double EXPECTED = 291.971;
    public static final double DELTA = 0.001;

    /**
     * test for function of calculate the quantity
     * of water.
     */
    @Test
    public void calculateQuantity() {
        Water water = new Water(PROPORTION, COEF);
        assertEquals(EXPECTED, water.CalculateQuantity(), DELTA);
    }
}