package homework.view;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * A panel that shows sthe Hall of Fame
 */
public class HallOfFamePanel extends JPanel {

    JLabel title;
    JList<String> champList;
    JButton backButton;

    public HallOfFamePanel() {
        super();
        this.setBackground(Color.black);
        this.setLayout(null);
        initTitle();
        initButton();
    }


    /**
     * Shows the list of players currently in the Hall of Fame
     */
    public void showHallOfFame() {
        DefaultListModel<String> listModel = new DefaultListModel<>();
        ArrayList<Player> list = Player.readHallOfFame();
        for (Player player : list) {
            listModel.addElement(player.toString());
        }
        champList = new JList<>(listModel);
        champList.setBounds(390, 190, 500, 400);
        champList.setFont(new Font("Ubuntu", Font.BOLD, 28));
        champList.setBackground(Color.black);
        champList.setForeground(Color.white);
        DefaultListCellRenderer renderer = (DefaultListCellRenderer) champList.getCellRenderer();
        renderer.setHorizontalAlignment(SwingConstants.CENTER);
        renderer.setFocusable(false);
        this.add(champList);
    }

    /**
     * Initialises the Back button
     */
    private void initButton() {
        backButton = new JButton("Back");
        backButton.setBounds(600, 590, 80, 30);
        this.add(backButton);
    }

    /**
     * Initialises the Title of the panel
     */
    private void initTitle() {
        title = new JLabel("Hall Of Fame");
        title.setBackground(Color.black);
        title.setForeground(Color.white);
        title.setFont(new Font("Ubuntu", Font.BOLD, 48));
        title.setBounds(390, 50, 500, 130);
        title.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(title);
    }
}
