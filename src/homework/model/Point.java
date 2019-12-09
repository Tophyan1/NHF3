package homework.model;

import java.io.Serializable;

/**
 * Class that represents a point in a two
 * dimensional coordinate system
 */
public class Point implements Serializable {
    private static final long serialVersionUID = -610786499705052216L;
    private double x;
    private double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Gets the X coordinate of the point
     *
     * @return the X coordinate of the point
     */
    public double getX() {
        return x;
    }

    /**
     * Gets the Y coordinate of the point
     *
     * @return the Y coordinate of the point
     */
    public double getY() {
        return y;
    }

    /**
     * Calculates the distance between two points
     *
     * @param point the other point
     * @return the distance in floating point format
     */
    public double distanceTo(Point point) {
        double dx = point.x - this.x;
        double dy = point.y - this.y;
        return Math.sqrt(dx * dx + dy * dy);
    }

    /**
     * Returns the vector pointing from this to p2
     *
     * @param p2 the point the returning vector points to
     * @return the vector pointing from this to p2
     */
    public Vector vectorTo(Point p2) {
        return new Vector(p2.x - this.x, p2.y - this.y);
    }

    /**
     * Callculates the point that a vector would push a point
     *
     * @param v the vector acting upon  the point
     * @return the end-point the original gets pushed to
     */
    public Point moveByVector(Vector v) {
        x += v.getX();
        y += v.getY();
        return this;
    }

    /**
     * Clone method
     *
     * @return a clone of this
     */
    public Point clone() {
        return new Point(x, y);
    }
}
