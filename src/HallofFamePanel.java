import javax.swing.*;
import java.awt.*;

public class HallofFamePanel extends JPanel {
    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JButton button1;
    private JLabel title;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JLabel label5;
    private JLabel label6;
    private JLabel label7;
    private JLabel label8;
    private JLabel label9;
    private JLabel label10;

    public HallofFamePanel() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        button1 = new JButton();
        title = new JLabel();
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        label4 = new JLabel();
        label5 = new JLabel();
        label6 = new JLabel();
        label7 = new JLabel();
        label8 = new JLabel();
        label9 = new JLabel();
        label10 = new JLabel();

        //======== this ========
        setBackground(Color.black);
        setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.TitledBorder(new javax.swing.
                border.EmptyBorder(0, 0, 0, 0), "JF\u006frmDesi\u0067ner Ev\u0061luatio\u006e", javax.swing.border.TitledBorder.CENTER
                , javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialo\u0067", java.awt.Font
                .BOLD, 12), java.awt.Color.red), getBorder()));
        addPropertyChangeListener(
                new java.beans.PropertyChangeListener() {
                    @Override
                    public void propertyChange(java.beans.PropertyChangeEvent e) {
                        if ("borde\u0072"
                                .equals(e.getPropertyName())) throw new RuntimeException();
                    }
                });

        //---- button1 ----
        button1.setText("Back");

        //---- title ----
        title.setText("Hall of Fame");
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setBackground(Color.black);
        title.setFont(title.getFont().deriveFont(title.getFont().getStyle() | Font.BOLD, title.getFont().getSize() + 20f));

        //---- label1 ----
        label1.setText("1 person");
        label1.setHorizontalAlignment(SwingConstants.CENTER);
        label1.setBackground(Color.black);

        //---- label2 ----
        label2.setText("1 person");
        label2.setHorizontalAlignment(SwingConstants.CENTER);
        label2.setBackground(Color.black);

        //---- label3 ----
        label3.setText("1 person");
        label3.setHorizontalAlignment(SwingConstants.CENTER);
        label3.setBackground(Color.black);

        //---- label4 ----
        label4.setText("1 person");
        label4.setHorizontalAlignment(SwingConstants.CENTER);
        label4.setBackground(Color.black);

        //---- label5 ----
        label5.setText("1 person");
        label5.setHorizontalAlignment(SwingConstants.CENTER);
        label5.setBackground(Color.black);

        //---- label6 ----
        label6.setText("1 person");
        label6.setHorizontalAlignment(SwingConstants.CENTER);
        label6.setBackground(Color.black);

        //---- label7 ----
        label7.setText("1 person");
        label7.setHorizontalAlignment(SwingConstants.CENTER);
        label7.setBackground(Color.black);

        //---- label8 ----
        label8.setText("1 person");
        label8.setHorizontalAlignment(SwingConstants.CENTER);
        label8.setBackground(Color.black);

        //---- label9 ----
        label9.setText("1 person");
        label9.setHorizontalAlignment(SwingConstants.CENTER);
        label9.setBackground(Color.black);

        //---- label10 ----
        label10.setText("1 person");
        label10.setHorizontalAlignment(SwingConstants.CENTER);
        label10.setBackground(Color.black);

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(390, 390, 390)
                                                .addComponent(title, GroupLayout.PREFERRED_SIZE, 500, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                .addGap(439, 439, 439)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                                                        .addComponent(button1)
                                                        .addComponent(label1, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(label2, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(label3, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(label4, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(label5, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(label6, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(label7, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(label8, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(label9, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(label10, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE))))
                                .addGap(390, 390, 390))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup()
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap(75, Short.MAX_VALUE)
                                .addComponent(title, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(label1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(label2, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(label3, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(label4, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(label5, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(label6, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(label7, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(label8, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(label9, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(label10, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                                .addComponent(button1)
                                .addGap(84, 84, 84))
        );
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
