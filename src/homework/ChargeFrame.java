package homework;

import javax.swing.*;
import java.awt.*;
import java.io.Serializable;

public class ChargeFrame extends JFrame implements Serializable {
    MenuPanel menu;
    HallOfFamePanel hallOfFame;

    public ChargeFrame() throws HeadlessException {
        super("Charge!");
        this.setLayout(new CardLayout());
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.getContentPane().setBackground(Color.BLACK);
        this.setSize(1280, 720);
        this.setResizable(false);
        this.setVisible(true);
        menu = new MenuPanel();
        this.add(menu);
        hallOfFame = new HallOfFamePanel();
        this.add(hallOfFame);
    }


}
