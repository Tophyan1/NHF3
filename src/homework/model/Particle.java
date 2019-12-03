package homework.model;

import java.awt.*;

public class Particle implements PointCharge, Drawable {
    private final double radius = 10;
    private Point position;
    private double charge;


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

    @Override
    public void draw(Graphics g) {
        Color originalColor = g.getColor();
        Color chargeColor = charge > 0 ? Color.red : Color.blue;
        g.setColor(chargeColor);
        g.fillOval((int) (position.getX() - radius),
                (int) (position.getY() - radius),
                (int) (radius * 2),
                (int) (radius * 2));
        g.setColor(Color.black);
        g.drawOval((int) (position.getX() - radius),
                (int) (position.getY() - radius),
                (int) (radius * 2),
                (int) (radius * 2));
        g.setColor(originalColor);
    }
}
