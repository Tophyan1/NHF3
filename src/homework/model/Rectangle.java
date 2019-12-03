package homework.model;

abstract public class Rectangle implements Collidable {
    protected double x;
    protected double y;
    protected double height;
    protected double width;

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

    @Override
    public boolean didCollide(MovableParticle p) {
        double nearestX = Math.max(this.x, Math.min(p.getPosition().getX(), this.x + this.width));
        double nearestY = Math.max(this.y, Math.min(p.getPosition().getY(), this.y + this.height));
        double dx = p.getPosition().getX() - nearestX;
        double dy = p.getPosition().getY() - nearestY;
        return (p.getRadius() * p.getRadius()) >= dx * dx + dy * dy;
    }
}
