package homework;

import javax.swing.*;
import java.awt.*;

public class EnterNamePanel extends JPanel {
    JTextField nameTextField;
    JLabel label;
    JButton button1;

    public EnterNamePanel() {
        initComponents();
    }

    private void initComponents() {

        nameTextField = new JTextField();
        label = new JLabel();
        button1 = new JButton();

        //======== this ========
        setForeground(Color.white);

        //---- nameTextField ----
        nameTextField.setForeground(Color.white);

        //---- label ----
        label.setText("Please Enter Your Name!");
        label.setForeground(Color.white);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setFont(label.getFont().deriveFont(label.getFont().getSize() + 16f));

        //---- button1 ----
        button1.setText("OK");
        button1.setForeground(Color.white);

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup()
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup()
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(540, 540, 540)
                                                .addComponent(nameTextField, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(440, 440, 440)
                                                .addComponent(label, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(600, 600, 600)
                                                .addComponent(button1)))
                                .addContainerGap(440, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(125, 125, 125)
                                .addComponent(label, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 111, Short.MAX_VALUE)
                                .addComponent(nameTextField, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                                .addGap(114, 114, 114)
                                .addComponent(button1)
                                .addGap(210, 210, 210))
        );
    }

}
