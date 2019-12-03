package homework.model;

import java.io.Serializable;

abstract public class Rectangle implements Collidable, Serializable {
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

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getHeight() {
        return height;
    }

    public double getWidth() {
        return width;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    @Override
    public boolean didCollide(MovableParticle p) {
        double nearestX = Math.max(this.x, Math.min(p.getPosition().getX(), this.x + this.width));
        double nearestY = Math.max(this.y, Math.min(p.getPosition().getY(), this.y + this.height));
        double dx = p.getPosition().getX() - nearestX;
        double dy = p.getPosition().getY() - nearestY;
        return (p.getRadius() * p.getRadius()) >= dx * dx + dy * dy;
    }
}
