package homework.model;

import java.io.Serializable;

public class MovableParticle implements PointCharge, Serializable {
    private static final long serialVersionUID = -7115988876897714834L;
    private Point position;
    private double charge;
    private Vector velocity = new Vector(0, 0);
    private double mass = 1;
    private double radius = 10;

    public MovableParticle(Point position, double charge, Vector velocity, double mass) {
        this.position = position;
        this.charge = charge;
        this.velocity = velocity;
        this.mass = mass;
    }

    public MovableParticle(Point position, double charge) {
        this.position = position;
        this.charge = charge;
    }

    @Override
    public final Point getPosition() {
        return position;
    }

    public void setPosition(Point position) {
        this.position = position;
    }

    @Override
    public final double getCharge() {
        return charge;
    }

    public Vector getVelocity() {
        return velocity;
    }

    public double getMass() {
        return mass;
    }

    public double getRadius() {
        return radius;
    }

    public void move(Vector force, double deltaTime) {
        Vector acceleration = force.clone().scale(1 / this.mass);
        this.velocity.addVector(acceleration.scale(deltaTime));
        this.position.moveByVector(velocity.clone().scale(deltaTime));
    }
}
