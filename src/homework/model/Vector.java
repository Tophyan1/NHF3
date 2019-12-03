package homework.model;

public class Vector {
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

    public Vector clone() {
        return new Vector(x, y);
    }
}
