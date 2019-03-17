package com.soces_fni.mdoser.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class SandTest {
    public static final int PROPORTION = 1;
    public static final int COEF = 50;
    public static final double EXPECTED = 0.730;
    public static final double DELTA = 0.001;

    /**
     * test for function of calculate the quantity
     * of Sand.
     */
    @Test
    public void calculateQuantity() {
        Sand sand = new Sand(PROPORTION, COEF);
        assertEquals(EXPECTED, sand.CalculateQuantity(), DELTA);
    }
}