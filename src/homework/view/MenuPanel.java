package homework.view;

import javax.swing.*;
import java.awt.*;

public class MenuPanel extends JPanel {
    JButton startButton;
    JButton loadButton;
    JButton exitButton;

    public MenuPanel() {
        super();
        this.setSize(1280, 720);
        this.setBackground(Color.BLACK);
        this.setLayout(null);
        setUpButtons();
    }

    private void setUpButtons() {
        startButton = new JButton("New Game");
        startButton.setBounds(540, 200, 200, 50);
        this.add(startButton);
        loadButton = new JButton("Load Game");
        loadButton.setBounds(540, 275, 200, 50);
        this.add(loadButton);
        exitButton = new JButton("Exit");
        exitButton.setBounds(540, 425, 200, 50);
        this.add(exitButton);
    }
}
