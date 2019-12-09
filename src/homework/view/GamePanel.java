package homework.view;

import javax.swing.*;
import java.awt.*;

/**
 * A panel consisting of a control panel and the level panel
 */
public class GamePanel extends JPanel {
    JPanel controlPanel;
    JButton removeButton;
    JButton startButton;
    JButton saveButton;
    JButton quitButton;
    LevelPanel levelPanel;

    public GamePanel() {
        initComponents();
    }

    /**
     * Initialises the components
     * Used JFormDesigner to generate code
     */
    private void initComponents() {

        controlPanel = new JPanel();
        removeButton = new JButton();
        startButton = new JButton();
        saveButton = new JButton();
        quitButton = new JButton();
        levelPanel = new LevelPanel();

        this.
                //======== this ========
                        setPreferredSize(new Dimension(1280, 720));
        setBackground(new Color(187, 187, 187));


        //======== controlPanel ========
        {

            //---- removeButton ----
            removeButton.setText("Remove");

            //---- startButton ----
            startButton.setText("Start!");

            //---- saveButton ----
            saveButton.setText("Save");

            //---- quitButton ----
            quitButton.setText("Quit");

            GroupLayout controlPanelLayout = new GroupLayout(controlPanel);
            controlPanel.setLayout(controlPanelLayout);
            controlPanel.setBackground(Color.black);
            controlPanelLayout.setHorizontalGroup(
                    controlPanelLayout.createParallelGroup()
                            .addGroup(controlPanelLayout.createSequentialGroup()
                                    .addGap(254, 254, 254)
                                    .addComponent(removeButton, GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE)
                                    .addGap(123, 123, 123)
                                    .addComponent(startButton, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(saveButton, GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(quitButton, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE)
                                    .addContainerGap(276, Short.MAX_VALUE))
            );
            controlPanelLayout.setVerticalGroup(
                    controlPanelLayout.createParallelGroup()
                            .addGroup(controlPanelLayout.createSequentialGroup()
                                    .addContainerGap()
                                    .addGroup(controlPanelLayout.createParallelGroup()
                                            .addComponent(startButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addGroup(controlPanelLayout.createSequentialGroup()
                                                    .addGroup(controlPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                            .addComponent(removeButton, GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE)
                                                            .addComponent(saveButton, GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE)
                                                            .addComponent(quitButton, GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE))
                                                    .addGap(0, 0, Short.MAX_VALUE)))
                                    .addContainerGap())
            );
        }

        //======== levelPanel ========
        {

            GroupLayout levelPanelLayout = new GroupLayout(levelPanel);
            levelPanel.setLayout(levelPanelLayout);
            levelPanelLayout.setHorizontalGroup(
                    levelPanelLayout.createParallelGroup()
                            .addGap(0, 1280, Short.MAX_VALUE)
            );
            levelPanelLayout.setVerticalGroup(
                    levelPanelLayout.createParallelGroup()
                            .addGap(0, 634, Short.MAX_VALUE)
            );
        }

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup()
                        .addComponent(controlPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(levelPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup()
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(controlPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(levelPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

    }


}
