package homework.model;

import java.awt.*;

/**
 * A class representing the goal area of the level
 */
public class Goal extends Rectangle implements Drawable {


    private static final long serialVersionUID = -1798537072646776227L;

    public Goal(double x, double y, double height, double width, Level level) {
        super(x, y, height, width, level);
    }

    public Goal(double x, double y, double height, double width) {
        super(x, y, height, width);
    }

    /**
     * Finishes the level upon collision
     */
    @Override
    public void onCollide() {
        level.finishLevel();
    }

    /**
     * Draws the goal area on the field
     *
     * @param g the Graphics object used to draw
     */
    @Override
    public void draw(Graphics g) {
        Color originalColor = g.getColor();
        g.setColor(Color.red);
        g.fillRect((int) x, (int) y, (int) width, (int) height);
        g.setColor(originalColor);
    }
}
