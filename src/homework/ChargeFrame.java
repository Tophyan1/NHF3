package homework;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;

public class ChargeFrame extends JFrame {
    MenuPanel menu;
    HallOfFamePanel hallOfFame;
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

        this.menu.hall.addActionListener(actionEvent -> layout.next(ChargeFrame.this.getContentPane()));

        this.hallOfFame.backButton.addActionListener(actionEvent -> layout.previous((ChargeFrame.this.getContentPane())));
    }


}
