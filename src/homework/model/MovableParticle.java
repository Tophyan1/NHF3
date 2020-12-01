package homework.model;

import java.awt.*;
import java.io.Serializable;

/**
 * A particle that can move on the field
 */
public class MovableParticle implements PointCharge, Serializable, Drawable {
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

    /**
     * Gets the current position of the particle
     *
     * @return the current position
     */
    @Override
    public final Point getPosition() {
        return position;
    }

    /**
     * Sets the position of the particle
     * Used for testing purposes
     *
     * @param position the new position
     */
    public void setPosition(Point position) {
        this.position = position;
    }

    /**
     * Gets the charge of the particle
     *
     * @return the charge
     */
    @Override
    public final double getCharge() {
        return charge;
    }

    /**
     * Gets the radius of the particle
     *
     * @return the radius
     */
    public double getRadius() {
        return radius;
    }

    /**
     * Moved the particle as it would physically move given its velocity, the force acting
     * upon it and the time passing.
     *
     * @param force     the force acting upon the particle
     * @param deltaTime the time period of the movement
     */
    public void move(Vector force, double deltaTime) {
        Vector acceleration = force.clone().scale(1 / this.mass);
        this.velocity.addVector(acceleration.scale(deltaTime));
        this.position.moveByVector(velocity.clone().scale(deltaTime));
    }

    /**
     * Draws the particle on the field
     *
     * @param g the Graphics object used to draw
     */
    @Override
    public void draw(Graphics g) {
        Color originalColor = g.getColor();
        g.setColor(Color.yellow);
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
