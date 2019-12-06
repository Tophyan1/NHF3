package homework.view;

import homework.model.Game;
import homework.model.Particle;
import homework.model.Point;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;


public class ChargeFrame extends JFrame {

    private CardLayout layout;
    private GamePanel gamePanel;
    private HallOfFamePanel hallOfFamePanel;


    public ChargeFrame() throws HeadlessException {
        this.setTitle("Charge!");
        layout = new CardLayout();
        this.setLayout(layout);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(1280, 720);
        MenuPanel menuPanel = new MenuPanel();
        this.add(menuPanel);
        gamePanel = new GamePanel();
        this.add(gamePanel);
        gamePanel.levelPanel.owner = this;
        hallOfFamePanel = new HallOfFamePanel();
        this.add(hallOfFamePanel);
        AddListeners(menuPanel);
    }

    public void getIntoHallOfFame(int score) {
        winDialog dialog = new winDialog(this);
        dialog.setVisible(true);

        dialog.OKButton.addActionListener(actionEvent -> {
            String playerName = dialog.nameField.getText();
            Player currentPlayer = new Player(playerName, score);
            ArrayList<Player> hallOfFame = Player.readHallOfFame();
            hallOfFame.add(currentPlayer);
            Player.writeHallOfFame(hallOfFame);
            layout.first(ChargeFrame.this.getContentPane());
            dialog.dispose();
        });


    }

    private void AddListeners(MenuPanel menuPanel) {

        menuPanel.exitButton.addActionListener(actionEvent -> ChargeFrame.this.processWindowEvent(
                new WindowEvent(ChargeFrame.this, WindowEvent.WINDOW_CLOSING)
        ));

        menuPanel.startButton.addActionListener(actionEvent -> {
            gamePanel.levelPanel.game = new Game();
            layout.next(ChargeFrame.this.getContentPane());
        });

        menuPanel.loadButton.addActionListener(actionEvent -> {
            layout.next(ChargeFrame.this.getContentPane());
            gamePanel.levelPanel.game.load("resources/SaveGame.dat");
        });

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                try {
                    gamePanel.levelPanel.game.save("resources/SaveGame.dat");
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        this.gamePanel.quitButton.addActionListener(actionEvent -> {
            gamePanel.levelPanel.timer.stop();
            layout.previous(ChargeFrame.this.getContentPane());
        });

        this.gamePanel.saveButton.addActionListener(actionEvent -> gamePanel.levelPanel.game.save("resources/SaveGame.dat"));

        this.gamePanel.removeButton.addActionListener(actionEvent -> {
            gamePanel.levelPanel.game.getCurrentLevel().popParticle();
            gamePanel.repaint();
        });

        addMouseListenerToLevelPanel();

        this.gamePanel.startButton.addActionListener(actionEvent -> {
            gamePanel.levelPanel.game.getCurrentLevel().setTimer(gamePanel.levelPanel.timer);
            gamePanel.levelPanel.timer.start();
        });

        menuPanel.hallOfFameButton.addActionListener(actionEvent -> {
            hallOfFamePanel.showHallOfFame();
            layout.last(ChargeFrame.this.getContentPane());
        });

        this.hallOfFamePanel.backButton.addActionListener(actionEvent -> layout.first(ChargeFrame.this.getContentPane()));
    }

    private void addMouseListenerToLevelPanel() {
        this.gamePanel.levelPanel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                Point p = new Point(mouseEvent.getX(), mouseEvent.getY());
                if (mouseEvent.getButton() == MouseEvent.BUTTON1) {
                    gamePanel.levelPanel.game.getCurrentLevel().pushParticle(new Particle(p, 1e-5));
                } else if (mouseEvent.getButton() == MouseEvent.BUTTON3) {
                    gamePanel.levelPanel.game.getCurrentLevel().pushParticle(new Particle(p, -1e-5));
                }
                gamePanel.repaint();
            }

            @Override
            public void mousePressed(MouseEvent mouseEvent) {
            }

            @Override
            public void mouseReleased(MouseEvent mouseEvent) {
            }

            @Override
            public void mouseEntered(MouseEvent mouseEvent) {
            }

            @Override
            public void mouseExited(MouseEvent mouseEvent) {
            }
        });
    }
}
