package homework.model;

import java.awt.*;

public class Goal extends Rectangle implements Drawable {


    private static final long serialVersionUID = -1798537072646776227L;

    public Goal(double x, double y, double height, double width, Level level) {
        super(x, y, height, width, level);
    }

    public Goal(double x, double y, double height, double width) {
        super(x, y, height, width);
    }

    @Override
    public void onCollide() {
        level.finishLevel();
    }

    @Override
    public void draw(Graphics g) {
        Color originalColor = g.getColor();
        g.setColor(Color.red);
        g.fillRect((int) x, (int) y, (int) width, (int) height);
        g.setColor(originalColor);
    }
}
