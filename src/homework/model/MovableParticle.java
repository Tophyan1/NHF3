package homework.model;

public class MovableParticle implements PointCharge {
    private Point position;
    private double charge;
    private Vector velocity;
    private double mass;
    private double radius = 10;

    public MovableParticle(Point position, double charge, Vector velocity, double mass) {
        this.position = position;
        this.charge = charge;
        this.velocity = velocity;
        this.mass = mass;
    }

    @Override
    public final Point getPosition() {
        return position;
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
