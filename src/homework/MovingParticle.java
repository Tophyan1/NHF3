package homework;

import java.io.Serializable;

public class MovingParticle extends Particle implements Serializable {
    private Point vel;
    transient private Point acc;
    private double mass;

    public MovingParticle(Point pos, int charge, Point vel, Point acc, double mass) {
        super(pos, charge);
        this.vel = vel;
        this.acc = acc;
        this.mass = mass;
    }

    public Point getVel() {
        return vel;
    }

    public Point getAcc() {
        return acc;
    }

    public double getMass() {
        return mass;
    }

    public void move(Point force, int t) {
        this.acc = force.scale(1.0 / this.mass);
        this.vel = this.acc.scale((double) t / 500);
        this.pos = this.pos.addPoint(this.vel.scale((double) t / 500));
    }

    public boolean collidedWith(Area rect) {
        int nearestX = Math.max(rect.getX(), Math.min(this.pos.getX(), rect.getX() + rect.getWidth()));
        int nearestY = Math.max(rect.getY(), Math.min(this.pos.getY(), rect.getY() + rect.getHeight()));
        int dx = this.pos.getX() - nearestX;
        int dy = this.pos.getY() - nearestY;
        return (this.radius * this.radius) >= dx * dx + dy * dy;
    }
}
