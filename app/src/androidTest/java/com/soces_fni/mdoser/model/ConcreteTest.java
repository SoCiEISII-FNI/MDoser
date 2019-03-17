package com.soces_fni.mdoser.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class ConcreteTest {
    public static final int PROPORTION = 1;
    public static final int COEF = 50;
    public static final double DELTA = 0.001;
    public static final double EXPECTED = 1021.898;

    /**
     * test for function of calculate the quantity
     * of concrete.
     */
    @Test
    public void calculateQuantity() {
        Concrete concrete = new Concrete(PROPORTION, COEF);
        assertEquals(EXPECTED, concrete.CalculateQuantity(), DELTA);
    }
}