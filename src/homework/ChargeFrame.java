package homework;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;

public class ChargeFrame extends JFrame {
    MenuPanel menu;
    HallOfFamePanel hallOfFame;
    EnterNamePanel enterName;
    GamePanel gamePanel;
    CardLayout layout;

    public ChargeFrame() throws HeadlessException {
        super("Charge!");
        layout = new CardLayout();
        this.setLayout(layout);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.getContentPane().setBackground(Color.BLACK);
        this.setSize(1280, 720);
        this.setResizable(false);
        this.setVisible(true);
        menu = new MenuPanel();
        this.add(menu, "1");
        menu.exit.addActionListener(actionEvent -> ChargeFrame.this.processWindowEvent(
                new WindowEvent(ChargeFrame.this, WindowEvent.WINDOW_CLOSING)
        ));
        hallOfFame = new HallOfFamePanel();
        this.add(hallOfFame, "2");

        enterName = new EnterNamePanel();
        this.add(enterName, "3");
        enterName.button1.addActionListener(actionEvent -> {
            layout.show(ChargeFrame.this.getContentPane(), "4");
            Player player = new Player(enterName.nameTextField.getText());
            gamePanel.game.setPlayer(player);
        });

        gamePanel = new GamePanel();
        this.add(gamePanel, "4");

        this.menu.start.addActionListener(actionEvent -> layout.show(ChargeFrame.this.getContentPane(), "3"));

        this.menu.hall.addActionListener(actionEvent -> layout.next(ChargeFrame.this.getContentPane()));

        this.hallOfFame.backButton.addActionListener(actionEvent -> layout.previous((ChargeFrame.this.getContentPane())));

        this.gamePanel.quitButton.addActionListener(actionEvent -> layout.first(ChargeFrame.this.getContentPane()));
    }


}
