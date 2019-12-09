package homework.model;

import java.io.Serializable;

/**
 * A class representing a vector in a
 * two dimensional coordinate system
 */
public class Vector implements Serializable {
    private static final long serialVersionUID = -9062380910028802700L;
    private double x;
    private double y;

    public Vector(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Gets the X coordinate of the vector
     *
     * @return the X coordinate of the vector
     */
    public double getX() {
        return x;
    }

    /**
     * Gets the Y coordinate of the vector
     *
     * @return the Y coordinate of the vector
     */
    public double getY() {
        return y;
    }

    /**
     * Scales the vector by a number
     *
     * @param d the scaling factor
     * @return the newly made vector
     */
    public Vector scale(double d) {
        x *= d;
        y *= d;
        return this;
    }

    /**
     * returns the length of the vector
     *
     * @return the length of the vector
     */
    public double length() {
        return Math.sqrt(x * x + y * y);
    }

    /**
     * normalizes the vector
     *
     * @return the vector with the same angle as the original one, with a length of 1
     */
    public Vector normalize() {
        double d = this.length();
        x /= d;
        y /= d;
        return this;
    }

    /**
     * Adds a vector to another
     *
     * @param v the second operand of addition
     * @return the sum
     */
    public Vector addVector(Vector v) {
        x += v.x;
        y += v.y;
        return this;
    }

    /**
     * Cloning method
     *
     * @return a clone of this
     */
    public Vector clone() {
        return new Vector(x, y);
    }
}
