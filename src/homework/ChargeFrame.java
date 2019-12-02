package homework;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

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
        this.add(menu);
        menu.exit.addActionListener(actionEvent -> ChargeFrame.this.processWindowEvent(
                new WindowEvent(ChargeFrame.this, WindowEvent.WINDOW_CLOSING)
        ));
        hallOfFame = new HallOfFamePanel();
        this.add(hallOfFame);

        enterName = new EnterNamePanel();
        this.add(enterName);

        enterName.button1.addActionListener(actionEvent -> {
            Player player = new Player(enterName.nameTextField.getText());
            gamePanel.game.setPlayer(player);
            gamePanel.updatePlayerData();
            layout.next(ChargeFrame.this.getContentPane());
        });

        gamePanel = new GamePanel();
        this.add(gamePanel);

        this.menu.start.addActionListener(actionEvent -> {
            gamePanel.game.reset("resources/Levels/Level_1.dat");
            layout.next(ChargeFrame.this.getContentPane());
            layout.next(ChargeFrame.this.getContentPane());
        });

        this.menu.load.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                FileInputStream fis = null;
                try {
                    fis = new FileInputStream("resources/SaveGame.dat");
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                ObjectInputStream ois = null;
                try {
                    ois = new ObjectInputStream(fis);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                gamePanel.game.load(ois);
                gamePanel.updatePlayerData();
                layout.last(ChargeFrame.this.getContentPane());
            }
        });

        this.menu.hall.addActionListener(actionEvent -> layout.next(ChargeFrame.this.getContentPane()));

        this.hallOfFame.backButton.addActionListener(actionEvent -> layout.previous((ChargeFrame.this.getContentPane())));

        this.gamePanel.quitButton.addActionListener(actionEvent -> layout.first(ChargeFrame.this.getContentPane()));
    }


}
