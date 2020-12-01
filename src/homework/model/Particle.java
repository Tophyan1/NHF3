package homework.model;

import java.awt.*;

/**
 * An electrically charged object capable of exerting electric force
 */
public class Particle implements PointCharge, Drawable {
    private final double radius = 10;
    private Point position;
    private double charge;


    public Particle(Point position, double charge) {
        this.position = position;
        this.charge = charge;
    }

    /**
     * Calculates the force vector that this exerts on another point charge
     *
     * @param p the point charge upon which this exerts the force
     * @return the force vector exerted by this to p
     */
    public Vector calculateForce(PointCharge p) {
        double magnitude = this.calculateForceMagnitude(p);
        Vector force = this.position.vectorTo(p.getPosition());
        force.normalize();
        force.scale(magnitude);
        return force;
    }

    /**
     * Calculates the magnitude electric force given by Coulomb's law
     *
     * @param p the point charge upon which the force acts
     * @return the magnitude of the force vector
     */
    private double calculateForceMagnitude(PointCharge p) {
        return 9e9 * this.charge * p.getCharge() / (this.position.distanceTo(p.getPosition()) * this.position.distanceTo(p.getPosition()));
    }

    /**
     * Gets the position of the particle
     *
     * @return the position
     */
    @Override
    public final Point getPosition() {
        return position;
    }

    /**
     * Gers the charge of the particle
     *
     * @return the charge
     */
    @Override
    public final double getCharge() {
        return charge;
    }

    /**
     * Draws the particle on the field
     *
     * @param g the Graphics object used to draw
     */
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
