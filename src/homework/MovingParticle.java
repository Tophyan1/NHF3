package homework;

import java.io.Serializable;

public class MovingParticle extends Particle implements Serializable {
    private static final long serialVersionUID = -7672821855120872004L;
    private Point vel;
    transient private Point acc;
    private double mass;

    public MovingParticle(Point pos, int charge, Point vel, double mass) {
        super(pos, charge);
        this.vel = vel;
        this.acc = new Point(0, 0);
        this.mass = mass;
    }

    public MovingParticle() {
        super();
        this.vel = new Point();
        this.acc = new Point();
        mass = 0;
    }

    public Point getVel() {
        return vel;
    }

    public void setVel(Point vel) {
        this.vel = vel;
    }

    public Point getAcc() {
        return acc;
    }

    public double getMass() {
        return mass;
    }

    public void move(Point force, int t) {
        this.acc = Point.scalePoint(force, 1.0 / mass);
        this.vel.addPoint(this.acc.scale((double) t / 500));
        this.pos.addPoint(this.vel.scale((double) t / 500));
    }

    public boolean collidedWith(Area rect) {
        int nearestX = Math.max(rect.getX(), Math.min(this.pos.getX(), rect.getX() + rect.getWidth()));
        int nearestY = Math.max(rect.getY(), Math.min(this.pos.getY(), rect.getY() + rect.getHeight()));
        int dx = this.pos.getX() - nearestX;
        int dy = this.pos.getY() - nearestY;
        return (this.radius * this.radius) >= dx * dx + dy * dy;
    }
}
