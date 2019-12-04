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
import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;


public class ChargeFrame extends JFrame {

    private CardLayout layout;
    private GamePanel gamePanel;


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
        AddListeners(menuPanel);
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

        this.gamePanel.quitButton.addActionListener(actionEvent -> layout.previous(ChargeFrame.this.getContentPane()));

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
                Point p = new Point(mouseEvent.getX(), mouseEvent.getY());
                if (mouseEvent.getButton() == MouseEvent.BUTTON1) {
                    gamePanel.levelPanel.game.getCurrentLevel().pushParticle(new Particle(p, 1e-5));
                } else if (mouseEvent.getButton() == MouseEvent.BUTTON3) {
                    gamePanel.levelPanel.game.getCurrentLevel().pushParticle(new Particle(p, -1e-5));
                }
                gamePanel.repaint();
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

    public void getIntoHallOfFame(int score) {
        winDialog dialog = new winDialog(this);
        dialog.setVisible(true);

        dialog.OKButton.addActionListener(actionEvent -> {
            String playerName = dialog.nameField.getText();

            Player currentPlayer = new Player(playerName, score);
            ArrayList<Player> hallOfFame = new ArrayList<>();
            FileReader fr = null;
            try {
                fr = new FileReader("resources/HallOfFame.txt");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            BufferedReader br = new BufferedReader(fr);
            for (int i = 0; i < 10; ++i) {
                Player p = new Player("", 0);
                p.loadFromText(br);
                hallOfFame.add(p);
            }
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            hallOfFame.add(currentPlayer);
            hallOfFame.sort(Comparator.comparingInt(player -> -player.score));

            FileWriter fw = null;
            try {
                fw = new FileWriter("resources/HallOfFame.txt");
            } catch (IOException e) {
                e.printStackTrace();
            }
            for (int i = 0; i < 10; ++i) {
                hallOfFame.get(i).saveToText(fw);
            }
            try {
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            dialog.dispose();
        });


    }
}
