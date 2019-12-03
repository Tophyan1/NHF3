package homework.model;

public class Particle implements PointCharge {
    protected Point position;
    double charge;


    public Particle(Point position, double charge) {
        this.position = position;
        this.charge = charge;
    }

    public Vector calculateForce(PointCharge p) {
        double magnitude = this.calculateForceMagnitude(p);
        Vector force = this.position.vectorTo(p.getPosition());
        force.normalize();
        force.scale(magnitude);
        return force;
    }

    private double calculateForceMagnitude(PointCharge p) {
        return 9e9 * this.charge * p.getCharge() / (this.position.distanceTo(p.getPosition()) * this.position.distanceTo(p.getPosition()));
    }

    @Override
    public final Point getPosition() {
        return position;
    }

    @Override
    public final double getCharge() {
        return charge;
    }
}
