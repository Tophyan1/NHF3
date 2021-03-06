package homework.view;

import homework.model.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * A panel that shows the current game
 */
public class LevelPanel extends JPanel implements ActionListener {

    ChargeFrame owner;
    Game game;
    Timer timer;

    public LevelPanel() {
        this.setBackground(Color.black);
        this.game = new Game();
        timer = new Timer(20, this);
    }

    /**
     * Draws the gaem
     *
     * @param g the Graphics object used to draw
     */
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        game.getCurrentLevel().draw(g);
    }

    /**
     * Steps the game upon a Timer tick
     *
     * @param actionEvent the Timer's tick
     */
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        game.step(0.02);
        this.repaint();
        if (game.isGameOver()) {
            System.out.println(game.getScore());
            owner.getIntoHallOfFame(game.getScore());
        }

    }


}
