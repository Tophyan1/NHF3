package homework.model;

import java.io.Serializable;

public class Point implements Serializable {
    private static final long serialVersionUID = -610786499705052216L;
    private double x;
    private double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double distanceTo(Point point) {
        double dx = point.x - this.x;
        double dy = point.y - this.y;
        return Math.sqrt(dx * dx + dy * dy);
    }

    public Vector vectorTo(Point p2) {
        return new Vector(p2.x - this.x, p2.y - this.y);
    }

    public Point moveByVector(Vector v) {
        x += v.getX();
        y += v.getY();
        return this;
    }

    public Point clone() {
        return new Point(x, y);
    }
}
