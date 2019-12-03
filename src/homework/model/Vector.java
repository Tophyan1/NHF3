package homework.model;

import java.io.Serializable;

public class Vector implements Serializable {
    private static final long serialVersionUID = -9062380910028802700L;
    private double x;
    private double y;

    public Vector(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public Vector scale(double d) {
        x *= d;
        y *= d;
        return this;
    }

    public double length() {
        return Math.sqrt(x * x + y * y);
    }

    public Vector normalize() {
        double d = this.length();
        x /= d;
        y /= d;
        return this;
    }

    public Vector addVector(Vector v) {
        x += v.x;
        y += v.y;
        return this;
    }

    public Vector clone() {
        return new Vector(x, y);
    }
}
