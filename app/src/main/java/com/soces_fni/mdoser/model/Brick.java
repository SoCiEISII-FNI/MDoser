package com.soces_fni.mdoser.model;

/**
 * class for bricks.
 */
public final class Brick extends AbstractOperation {
    private float height;
    private float base;
    private float separation;
    private static final float LOST = 1.1f;

    /**
     * constructor.
     * @param height of the brick.
     * @param base of the brick.
     * @param separation between bricks.
     */
    public Brick(float height, float base, float separation) {
        this.height = height / 100;
        this.base = base / 100;
        this.separation = separation / 100;
    }

    /**
     * quantiity of bricks.
     * @return number to be trucked.
     */
    @Override
    public double CalculateQuantity() {
        double numberBricks;
        numberBricks = (1 / ((base + separation) * (height + separation))) * LOST;
        return Math.ceil(numberBricks);
    }
}
