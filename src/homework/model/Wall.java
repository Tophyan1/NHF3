package homework.model;

import java.awt.*;

public class Wall extends Rectangle implements Drawable {

    private static final long serialVersionUID = 8174863775110098761L;

    public Wall(double x, double y, double height, double width) {
        super(x, y, height, width);
    }

    @Override
    public void onCollide() {
        level.reset();
    }

    @Override
    public void draw(Graphics g) {
        Color originalColor = g.getColor();
        g.setColor(Color.gray);
        g.fillRect((int) x, (int) y, (int) width, (int) height);
        g.setColor(originalColor);
    }
}
