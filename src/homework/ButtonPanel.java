package homework;

import javax.swing.*;
import java.awt.*;

public class ButtonPanel extends JPanel {

    int charge = -1;

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.darkGray);
        g.fillRect(0, 0, 70, 70);
        if (charge < 0) {
            g.setColor(Color.blue);
        } else {
            g.setColor(Color.red);
        }
        g.fillOval(15, 15, 40, 40);
    }
}
