package homework;

//Used JFormDesigner

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class GamePanel extends JPanel {
    JPanel controlPanel;
    ButtonPanel panel1;
    JLabel nameLabel;
    JLabel scoreLabel;
    JLabel triesLAbel;
    JButton resetButton;
    JLabel lvlNrLabel;
    JButton saveButton;
    JButton quitButton;
    JButton startButton;
    LevelPanel levelPanel;
    Game game;

    public GamePanel() {
        initComponents();
    }

    private static void initButton(JButton button, String s) {
        button.setText(s);
    }

    static void initLabel(JLabel label, String s) {
        label.setText(s);
        label.setForeground(Color.white);
    }

    private void initComponents() {

        game = new Game();
        controlPanel = new JPanel();
        panel1 = new ButtonPanel();
        nameLabel = new JLabel();
        scoreLabel = new JLabel();
        triesLAbel = new JLabel();
        resetButton = new JButton();
        lvlNrLabel = new JLabel();
        saveButton = new JButton();
        quitButton = new JButton();
        startButton = new JButton();
        levelPanel = new LevelPanel(game.getLevel());


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

        addMouseListenerToLevelPanel();

    }

    private void addMouseListenerToLevelPanel() {
        levelPanel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                game.getLevel().addParticle(new Particle(new Point(mouseEvent.getPoint()), panel1.charge));
                levelPanel.repaint();
            }

            @Override
            public void mousePressed(MouseEvent mouseEvent) {
            }

            @Override
            public void mouseReleased(MouseEvent mouseEvent) {
            }

            @Override
            public void mouseEntered(MouseEvent mouseEvent) {
            }

            @Override
            public void mouseExited(MouseEvent mouseEvent) {
            }
        });
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
        initLabelsAndButtons();
        GroupLayout controlPanelLayout = new GroupLayout(controlPanel);
        controlPanel.setLayout(controlPanelLayout);
        controlPanelHorizontalGroupSetup(controlPanelLayout);
        controlPanelVerticalGroupSetup(controlPanelLayout);
        addMouseListenerToPanel1();
        addActionListenerToSaveButton();
        addActionListenerToResetButton();
    }

    private void initLabelsAndButtons() {
        //---- nameLabel ----
        initLabel(nameLabel, game.getPlayer().getName());

        //---- scoreLabel ----
        initLabel(scoreLabel, "Score: " + game.getPlayer().getScore());

        //---- triesLAbel ----
        initLabel(triesLAbel, "Tries: " + game.getLevel().getTryNumber());

        //---- resetButton ----
        initButton(resetButton, "Remove");

        //---- lvlNrLabel ----
        initLabel(lvlNrLabel, "Level " + game.getLevel().getLevelNumber());
        lvlNrLabel.setHorizontalAlignment(SwingConstants.CENTER);

        //---- saveButton ----
        initButton(saveButton, "Save");

        //---- quitButton ----
        initButton(quitButton, "Quit");

        //---- startButton ----
        initButton(startButton, "START!");
        startButton.setFont(startButton.getFont().deriveFont(startButton.getFont().getStyle() | Font.BOLD));
    }

    private void addActionListenerToResetButton() {
        resetButton.addActionListener(actionEvent -> {
            game.getLevel().removeLastParticle();
            levelPanel.repaint();
        });
    }

    private void addActionListenerToSaveButton() {
        saveButton.addActionListener(actionEvent -> {
            FileOutputStream fos = null;
            try {
                fos = new FileOutputStream("resources/SaveGame.dat");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            ObjectOutputStream oos = null;
            try {
                oos = new ObjectOutputStream(fos);
            } catch (IOException e) {
                e.printStackTrace();
            }
            game.save(oos);
        });
    }

    private void addMouseListenerToPanel1() {
        panel1.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                panel1.charge *= -1;
                panel1.repaint();
            }

            @Override
            public void mousePressed(MouseEvent mouseEvent) {
            }

            @Override
            public void mouseReleased(MouseEvent mouseEvent) {
            }

            @Override
            public void mouseEntered(MouseEvent mouseEvent) {
            }

            @Override
            public void mouseExited(MouseEvent mouseEvent) {
            }
        });
    }

    private void controlPanelVerticalGroupSetup(GroupLayout controlPanelLayout) {
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

    private void controlPanelHorizontalGroupSetup(GroupLayout controlPanelLayout) {
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
    }

    public void updatePlayerData() {
        initLabel(nameLabel, game.getPlayer().getName());
        initLabel(scoreLabel, "Score: " + game.getPlayer().getScore());
    }

}
