package com.soces_fni.mdoser.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class BrickTest {
    public static final int HEIGHT = 10;
    public static final int BASE = 20;
    public static final int SEPARATION = 1;
    public static final double EXPECTED = 1.0;
    public static final double DELTA = 0.1;

    /**
     * test for function of calculate the quantity
     * of bricks.
     */
    @Test
    public void calculateQuantity() {
        Brick brick = new Brick(HEIGHT, BASE, SEPARATION);
        assertEquals(EXPECTED, brick.CalculateQuantity(), DELTA);
    }
}