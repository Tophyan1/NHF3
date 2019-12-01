package homework;

import javax.swing.*;
import java.awt.*;


public class MenuPanel extends JPanel {
    JButton start;
    JButton load;
    JButton hall;
    JButton exit;

    public MenuPanel() {
        super();
        this.setSize(1280, 720);
        this.setBackground(Color.BLACK);
        this.setLayout(null);
        setUpButtons();

    }

    private void setUpButtons() {
        start = new JButton("New Game");
        start.setBounds(540, 200, 200, 50);
        this.add(start);
        load = new JButton("Load Game");
        load.setBounds(540, 275, 200, 50);
        this.add(load);
        hall = new JButton("Hall of Fame");
        hall.setBounds(540, 350, 200, 50);
        this.add(hall);
        exit = new JButton("Exit");
        exit.setBounds(540, 425, 200, 50);
        this.add(exit);
    }
}
