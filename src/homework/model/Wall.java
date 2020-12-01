package homework.model;

import java.awt.*;

/**
 * A wall that stops moving particles
 */
public class Wall extends Rectangle implements Drawable {

    private static final long serialVersionUID = 8174863775110098761L;

    public Wall(double x, double y, double height, double width) {
        super(x, y, height, width);
    }

    /**
     * Resets the level on collision
     */
    @Override
    public void onCollide() {
        level.reset();
    }

    /**
     * Draws the wall on the field
     *
     * @param g the Graphics object used to draw
     */
    @Override
    public void draw(Graphics g) {
        Color originalColor = g.getColor();
        g.setColor(Color.gray);
        g.fillRect((int) x, (int) y, (int) width, (int) height);
        g.setColor(originalColor);
    }
}
