package com.soces_fni.mdoser.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class BrickTest {
    public static final float HEIGHT = 11f;
    public static final float BASE = 25f;
    public static final float SEPARATION = 1f;
    public static final double EXPECTED = 36f;
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