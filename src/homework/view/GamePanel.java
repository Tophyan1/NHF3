package homework.view;

import homework.model.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GamePanel extends JPanel implements ActionListener {
    Game game;
    Timer timer;


    public GamePanel() {
        super();
        this.setBackground(Color.CYAN);
        game = new Game();
        timer = new Timer(20, this);
        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent keyEvent) {
            }

            @Override
            public void keyPressed(KeyEvent keyEvent) {
                if (keyEvent.getKeyCode() == KeyEvent.VK_SPACE) {
                    timer.start();
                }
            }

            @Override
            public void keyReleased(KeyEvent keyEvent) {
            }
        });

        this.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                if (mouseEvent.getButton() == MouseEvent.BUTTON1) {
                    homework.model.Point p = new homework.model.Point(mouseEvent.getX(), mouseEvent.getY());
                    game.addParticle(p, +1);
                }
                if (mouseEvent.getButton() == MouseEvent.BUTTON3) {
                    homework.model.Point p = new homework.model.Point(mouseEvent.getX(), mouseEvent.getY());
                    game.addParticle(p, -1);
                }
                GamePanel.this.repaint();
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

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        game.draw(g);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        game.step(20);
        if (game.isGameOver() || game.isFailed())
            timer.stop();
    }
}
