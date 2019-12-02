package homework;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    JPanel controlPanel;
    JPanel panel1;
    JLabel nameLabel;
    JLabel scoreLabel;
    JLabel triesLAbel;
    JButton resetButton;
    JLabel lvlNrLabel;
    JButton saveButton;
    JButton quitButton;
    JButton startButton;
    JPanel levelPanel;
    Game game;

    public GamePanel() {
        initComponents();
    }

    private static void initButton(JButton button, String s) {
        button.setText(s);
    }

    private static void initLabel(JLabel label, String s) {
        label.setText(s);
        label.setForeground(Color.white);
    }

    private void initComponents() {

        controlPanel = new JPanel();
        panel1 = new JPanel();
        nameLabel = new JLabel();
        scoreLabel = new JLabel();
        triesLAbel = new JLabel();
        resetButton = new JButton();
        lvlNrLabel = new JLabel();
        saveButton = new JButton();
        quitButton = new JButton();
        startButton = new JButton();
        levelPanel = new JPanel();
        game = new Game();

        //======== this ========
        setPreferredSize(new Dimension(1280, 720));


        //======== controlPanel ========
        controlPanelSetup();

        //======== levelPanel ========
        {
            levelPanel.setBackground(Color.black);
            GroupLayout levelPanelLayout = new GroupLayout(levelPanel);
            levelPanel.setLayout(levelPanelLayout);
            levelPanelLayout.setHorizontalGroup(
                    levelPanelLayout.createParallelGroup()
                            .addGap(0, 0, Short.MAX_VALUE)
            );
            levelPanelLayout.setVerticalGroup(
                    levelPanelLayout.createParallelGroup()
                            .addGap(0, 645, Short.MAX_VALUE)
            );
        }

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup()
                        .addComponent(controlPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(levelPanel, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup()
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(controlPanel, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(levelPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );

    }

    private void controlPanelSetup() {
        controlPanel.setBackground(Color.black);
        //======== panel1 ========
        {

            panel1.setLayout(null);

            {
                // compute preferred size
                Dimension preferredSize = new Dimension();
                for (int i = 0; i < panel1.getComponentCount(); i++) {
                    Rectangle bounds = panel1.getComponent(i).getBounds();
                    preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                    preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                }
                Insets insets = panel1.getInsets();
                preferredSize.width += insets.right;
                preferredSize.height += insets.bottom;
                panel1.setMinimumSize(preferredSize);
                panel1.setPreferredSize(preferredSize);
            }
        }

        //---- nameLabel ----
        initLabel(nameLabel, "PLAYERNAME");

        //---- scoreLabel ----
        initLabel(scoreLabel, "SCORE");

        //---- triesLAbel ----
        initLabel(triesLAbel, "TRIES");

        //---- resetButton ----
        initButton(resetButton, "Reset");

        //---- lvlNrLabel ----
        initLabel(lvlNrLabel, "LEVEL");
        lvlNrLabel.setHorizontalAlignment(SwingConstants.CENTER);

        //---- saveButton ----
        initButton(saveButton, "Save");

        //---- quitButton ----
        initButton(quitButton, "Quit");

        //---- startButton ----
        initButton(startButton, "START!");
        startButton.setFont(startButton.getFont().deriveFont(startButton.getFont().getStyle() | Font.BOLD));

        GroupLayout controlPanelLayout = new GroupLayout(controlPanel);
        controlPanel.setLayout(controlPanelLayout);
        controlPanelLayout.setHorizontalGroup(
                controlPanelLayout.createParallelGroup()
                        .addGroup(controlPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(controlPanelLayout.createParallelGroup()
                                        .addComponent(nameLabel, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)
                                        .addGroup(controlPanelLayout.createSequentialGroup()
                                                .addComponent(scoreLabel, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(triesLAbel, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)))
                                .addGroup(controlPanelLayout.createParallelGroup()
                                        .addGroup(controlPanelLayout.createSequentialGroup()
                                                .addGap(177, 177, 177)
                                                .addComponent(resetButton))
                                        .addGroup(controlPanelLayout.createSequentialGroup()
                                                .addGap(134, 134, 134)
                                                .addComponent(lvlNrLabel, GroupLayout.PREFERRED_SIZE, 164, GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 92, Short.MAX_VALUE)
                                .addComponent(panel1, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
                                .addGap(58, 58, 58)
                                .addComponent(startButton, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 110, Short.MAX_VALUE)
                                .addGroup(controlPanelLayout.createParallelGroup()
                                        .addComponent(saveButton, GroupLayout.Alignment.TRAILING)
                                        .addComponent(quitButton, GroupLayout.Alignment.TRAILING))
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        controlPanelLayout.setVerticalGroup(
                controlPanelLayout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, controlPanelLayout.createSequentialGroup()
                                .addGroup(controlPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addComponent(panel1, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
                                        .addGroup(controlPanelLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addGroup(controlPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                        .addComponent(startButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addGroup(GroupLayout.Alignment.LEADING, controlPanelLayout.createSequentialGroup()
                                                                .addGroup(controlPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                                        .addComponent(nameLabel, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(resetButton))
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(controlPanelLayout.createParallelGroup()
                                                                        .addComponent(scoreLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addComponent(lvlNrLabel, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addComponent(triesLAbel, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                                        .addGroup(GroupLayout.Alignment.LEADING, controlPanelLayout.createSequentialGroup()
                                                                .addGap(0, 0, Short.MAX_VALUE)
                                                                .addComponent(saveButton)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(quitButton)
                                                                .addGap(0, 0, Short.MAX_VALUE)))))
                                .addContainerGap())
        );
    }

}
