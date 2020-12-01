package homework.model;

import java.io.Serializable;

/**
 * A colllidable object representing a rectangle
 */
abstract public class Rectangle implements Collidable, Serializable, Drawable {
    private static final long serialVersionUID = 3347780795715416954L;
    protected double x;
    protected double y;
    protected double height;
    protected double width;
    protected Level level;

    public Rectangle(double x, double y, double height, double width, Level level) {
        this.x = x;
        this.y = y;
        this.height = height;
        this.width = width;
        this.level = level;
    }

    public Rectangle(double x, double y, double height, double width) {
        this.x = x;
        this.y = y;
        this.height = height;
        this.width = width;
    }

    /**
     * Gets the X coordinate of the top-left corner of the rectangle
     *
     * @return the X coordinate of the top-left corner
     */
    public double getX() {
        return x;
    }

    /**
     * Gets the Y coordinate of the top-left corner of the rectangle
     *
     * @return the y coordinate of the top-left corner
     */
    public double getY() {
        return y;
    }

    /**
     * Gets the height of the rectangle
     *
     * @return the height
     */
    public double getHeight() {
        return height;
    }

    /**
     * Gets the width of the rectangle
     *
     * @return the width
     */
    public double getWidth() {
        return width;
    }

    /**
     * Setter function to the owner level
     *
     * @param level the level for the rectangle to point to
     */
    public void setLevel(Level level) {
        this.level = level;
    }

    /**
     * Checks if a particle collided with the rectangle
     *
     * @param p the moving particle
     * @return true, if the particle hit the rectangle, false otherwise
     */
    @Override
    public boolean didCollide(MovableParticle p) {
        double nearestX = Math.max(this.x, Math.min(p.getPosition().getX(), this.x + this.width));
        double nearestY = Math.max(this.y, Math.min(p.getPosition().getY(), this.y + this.height));
        double dx = p.getPosition().getX() - nearestX;
        double dy = p.getPosition().getY() - nearestY;
        return (p.getRadius() * p.getRadius()) >= dx * dx + dy * dy;
    }
}
