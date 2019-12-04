package homework.view;

import javax.swing.*;
import java.awt.*;

public class MenuPanel extends JPanel {
    JButton startButton;
    JButton loadButton;
    JButton hallOfFameButton;
    JButton exitButton;

    public MenuPanel() {
        super();
        this.setSize(1280, 720);
        this.setBackground(Color.BLACK);
        this.setLayout(null);
        setUpAllButtons();
    }

    private void setUpAllButtons() {
        setUpNewGameButton();
        setUpLoadGameButton();
        setUpHallOfFameButton();
        setUpExitButton();
    }

    private void setUpExitButton() {
        exitButton = new JButton("Exit");
        exitButton.setBounds(540, 425, 200, 50);
        this.add(exitButton);
    }

    private void setUpHallOfFameButton() {
        hallOfFameButton = new JButton("Hall of Fame");
        hallOfFameButton.setBounds(540, 350, 200, 50);
        this.add(hallOfFameButton);
    }

    private void setUpLoadGameButton() {
        loadButton = new JButton("Load Game");
        loadButton.setBounds(540, 275, 200, 50);
        this.add(loadButton);
    }

    private void setUpNewGameButton() {
        startButton = new JButton("New Game");
        startButton.setBounds(540, 200, 200, 50);
        this.add(startButton);
    }
}
