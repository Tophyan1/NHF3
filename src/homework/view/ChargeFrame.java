package homework.view;

import javax.swing.*;
import java.awt.*;

public class ChargeFrame extends JFrame {

    private CardLayout layout = new CardLayout();


    public ChargeFrame() throws HeadlessException {
        this.setTitle("Charge!");
        this.setLayout(layout);
    }
}
