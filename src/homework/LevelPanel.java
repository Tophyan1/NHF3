package homework;

import javax.swing.*;
import java.awt.*;

public class LevelPanel extends JPanel {
    Level level;
    java.awt.Point p;
    int charge = -1;

    public LevelPanel(Level level) {
        this.level = level;
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.black);
        g.fillRect(0, 0, 1280, 640);
        g.setColor(Color.yellow);
        g.fillOval(level.getPart().pos.getX() - (int) level.getPart().radius,
                level.getPart().pos.getY() - (int) level.getPart().radius,
                (int) level.getPart().radius * 2,
                (int) level.getPart().radius * 2);
        g.setColor(Color.red);
        g.drawString("+", level.getPart().pos.getX() - 5, level.getPart().pos.getY() + 5);
        g.setColor(Color.LIGHT_GRAY);
        for (Area wall : level.getWalls()) {
            g.fillRect(wall.getX(), wall.getY(), wall.getHeight(), wall.getWidth());
        }
        g.setColor(Color.red);
        g.fillRect(level.getGoal().getX(), level.getGoal().getY(), level.getGoal().getHeight(), level.getGoal().getWidth());
        for (Particle particle : level.getPartList()) {
            Color color = particle.charge < 0 ? Color.blue : Color.red;
            g.setColor(color);
            g.fillOval(particle.pos.getX() - (int) particle.radius,
                    particle.pos.getY() - (int) particle.radius,
                    (int) particle.radius * 2,
                    (int) particle.radius * 2);
            g.setColor(Color.black);
            g.drawOval(particle.pos.getX() - (int) particle.radius,
                    particle.pos.getY() - (int) particle.radius,
                    (int) particle.radius * 2,
                    (int) particle.radius * 2);
        }
    }

}
