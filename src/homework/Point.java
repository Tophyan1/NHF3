package homework;

import java.io.Serializable;

import static java.lang.Math.atan2;

public class Point implements Serializable {
    private static final long serialVersionUID = -3383830271333482425L;
    private int x;
    private int y;

    public Point() {
        this.x = 0;
        this.y = 0;
    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Point(java.awt.Point p) {
        this.x = p.x;
        this.y = p.y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public double distance(Point rhs) {
        return Math.sqrt((this.x - rhs.x) * (this.x - rhs.x) + (this.y - rhs.y) * (this.y - rhs.y));
    }

    public double angleTo(Point p) {
        return atan2(p.y - this.y, p.x - this.x);
    }

    public void setValue(Point p) {
        this.x = p.x;
        this.y = p.y;
    }

    public Point scale(double d) {
        return new Point((int)(this.x * d), (int)(this.y * d));
    }

    public Point addPoint(Point p) {
        return new Point(this.x + p.x, this.y + p.y);
    }

    public  Point subtractPoint(Point p) {
        return new Point(this.x - p.x, this.y - p.y);
    }

    @Override
    public boolean equals(Object obj) {
        return ((Point)obj).x == this.x && ((Point)obj).y == this.y;
    }
}
