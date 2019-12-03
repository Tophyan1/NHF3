package homework.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class ChargeFrame extends JFrame {

    private CardLayout layout;
    private MenuPanel menuPanel;
    private GamePanel gamePanel;


    public ChargeFrame() throws HeadlessException {
        this.setTitle("Charge!");
        layout = new CardLayout();
        this.setLayout(layout);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(1280, 720);
        menuPanel = new MenuPanel();
        this.add(menuPanel);
        menuPanel.exitButton.addActionListener(actionEvent -> ChargeFrame.this.processWindowEvent(
                new WindowEvent(ChargeFrame.this, WindowEvent.WINDOW_CLOSING)
        ));
        gamePanel = new GamePanel();
        this.add(gamePanel);
        this.menuPanel.startButton.addActionListener(actionEvent -> layout.next(ChargeFrame.this.getContentPane()));

        this.menuPanel.loadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                gamePanel.game.load("resources/SaveGame.dat");
                layout.next(ChargeFrame.this.getContentPane());
            }
        });

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                try {
                    gamePanel.game.save("resources/SaveGame.dat");
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

    }
}
