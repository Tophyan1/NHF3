package homework.view;

import javax.swing.*;
import java.awt.*;

/**
 * Dialog window notifying the player that (s)he won
 */
public class winDialog extends JDialog {
    JTextField nameField;
    JButton OKButton;
    JLabel winLabel;
    JLabel nameLabel;

    public winDialog(Window owner) {
        super(owner);
        initComponents();
    }

    /**
     * Initialises the components
     */
    private void initComponents() {
        nameField = new JTextField();
        OKButton = new JButton();
        winLabel = new JLabel();
        nameLabel = new JLabel();

        //======== this ========
        var contentPane = getContentPane();

        //---- button1 ----
        OKButton.setText("OK");

        //---- winLabel
        //----
        winLabel.setText("You have Won!");
        winLabel.setHorizontalAlignment(SwingConstants.CENTER);
        winLabel.setFont(winLabel
                .getFont().deriveFont(winLabel
                        .getFont().getStyle() | Font.BOLD, 31f));

        //---- nameLabel
        //----
        nameLabel.setText("Please Enter Your Name!");
        nameLabel.setHorizontalAlignment(SwingConstants.CENTER);

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
                contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                                .addGap(160, 160, 160)
                                .addComponent(OKButton)
                                .addContainerGap(160, Short.MAX_VALUE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                                .addGap(74, 74, 74)
                                .addGroup(contentPaneLayout.createParallelGroup()
                                        .addComponent(nameField, GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                                        .addComponent(winLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(nameLabel, GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE))
                                .addGap(74, 74, 74))
        );
        contentPaneLayout.setVerticalGroup(
                contentPaneLayout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(winLabel, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(nameLabel, GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(nameField, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31)
                                .addComponent(OKButton)
                                .addGap(41, 41, 41))
        );
        pack();
        setLocationRelativeTo(getOwner());
    }
}