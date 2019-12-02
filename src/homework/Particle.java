package homework;

import java.io.Serializable;

public class Particle implements Serializable {
    private static final long serialVersionUID = 1178093362037049731L;
    protected Point pos;
    protected double radius;
    protected int charge;

    public Particle(Point pos, int charge) {
        this.pos = pos;
        this.radius = 10;
        this.charge = charge;
    }

    public Particle() {
        this.pos = new Point(0, 0);
        this.radius = 10;
        this.charge = 0;
    }

    public Point getPos() {
        return pos;
    }

    public double getRadius() {
        return radius;
    }

    public int getCharge() {
        return charge;
    }

    public double distance(Particle p) {
        return this.pos.distance(p.pos);
    }

    public Point exertForceTo(Particle p) {
        double d = this.distance(p);
        if (d == 0) {
            return new Point(0, 0);
        }
        double mag = 1200 * this.charge * p.charge / (d * d);
        double phi = this.pos.angleTo(p.pos);
        return new Point((int)(mag * Math.cos(phi)), (int)(mag * Math.sin(phi)));
    }

    @Override
    public boolean equals(Object obj) {
        return this.pos.getX() == ((Particle)obj).pos.getX() && this.pos.getY() == ((Particle)obj).pos.getY()
                    && this.charge == ((Particle)obj).charge && this.radius == ((Particle)obj).radius;
    }
}
