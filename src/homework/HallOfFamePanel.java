package homework;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class HallOfFamePanel extends JPanel {
    JButton backButton;
    JLabel title;
    JLabel label1;
    JLabel label2;
    JLabel label3;
    JLabel label4;
    JLabel label5;
    JLabel label6;
    JLabel label7;
    JLabel label8;
    JLabel label9;
    JLabel label10;
    Player[] players;

    public HallOfFamePanel() {
        initComponents();
    }

    private static void setUpPersonsLabel(JLabel label, String s) {
        label.setText(s);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setBackground(Color.black);
    }

    private void initComponents() {

        backButton = new JButton();
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
        players = new Player[10];


        readPlayerDataFromText();


        //======== this ========
        setBackground(Color.black);

        //---- button1 ----
        backButton.setText("Back");

        //---- title ----
        setUpPersonsLabel(title, "Hall of Fame");
        title.setFont(title.getFont().deriveFont(title.getFont().getStyle() | Font.BOLD, title.getFont().getSize() + 20f));


        setUpAllPersonsLabels();

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        setUpHorizontalGroups(layout);
        setUpVerticalGroups(layout);

    }

    private void readPlayerDataFromText() {
        FileReader fr = null;
        try {
            fr = new FileReader("HallOfFame.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        BufferedReader br = new BufferedReader(fr);
        for (int i = 0; i < 10; ++i) {
            String line = null;
            try {
                line = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            String[] fields = line.split(" ", 2);
            players[i] = new Player(fields[1], Integer.getInteger(fields[0]));
        }
    }

    private void setUpVerticalGroups(GroupLayout layout) {
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
                                .addComponent(backButton)
                                .addGap(84, 84, 84))
        );
    }

    private void setUpHorizontalGroups(GroupLayout layout) {
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
                                                        .addComponent(backButton)
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
    }

    private void setUpAllPersonsLabels() {
        //---- label1 ----
        setUpPersonsLabel(label1, players[0].toString());

        //---- label2 ----
        setUpPersonsLabel(label2, players[1].toString());

        //---- label3 ----
        setUpPersonsLabel(label3, players[2].toString());

        //---- label4 ----
        setUpPersonsLabel(label4, players[3].toString());

        //---- label5 ----
        setUpPersonsLabel(label5, players[4].toString());

        //---- label6 ----
        setUpPersonsLabel(label6, players[5].toString());

        //---- label7 ----
        setUpPersonsLabel(label7, players[6].toString());

        //---- label8 ----
        setUpPersonsLabel(label8, players[7].toString());

        //---- label9 ----
        setUpPersonsLabel(label9, players[8].toString());

        //---- label10 ----
        setUpPersonsLabel(label10, players[9].toString());
    }

}

