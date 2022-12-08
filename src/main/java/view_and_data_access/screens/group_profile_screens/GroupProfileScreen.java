package view_and_data_access.screens.group_profile_screens;

import interface_adapters.view_group_profile_adapters.GroupProfileScreenBoundary;
import interface_adapters.view_group_profile_adapters.ViewGroupProfileController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

/**
 * The group profile screen. Displays the group's description and preferences.
 */
public class GroupProfileScreen extends JPanel implements GroupProfileScreenBoundary {
    String groupDescription;
    HashMap<String, String> groupPreferences;
    ViewGroupProfileController viewGroupProfileController;
    String groupName;
    String username;
    JLabel groupNameLabel = new JLabel();
    JTextArea textBox;
    CardLayout cardLayout;
    JScrollPane scrollPane = new JScrollPane();
    JPanel screens;
    JButton back = new JButton("Back");
    static int SCREEN_WIDTH = 500;
    static int SCREEN_HEIGHT = 500;

    /**
     * Initializes an empty group profile screen.
     */
    public GroupProfileScreen(CardLayout cardLayout, JPanel screens) {

        this.cardLayout = cardLayout;
        this.screens = screens;
        this.setBackground(new Color(182,202,218));
        setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
        back.addActionListener(new buttonPress());
        this.add(back);
        this.initializeComponents();
        this.buildScrollPane();

    }

    @Override
    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    @Override
    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public void setViewGroupProfileController(ViewGroupProfileController viewGroupProfileController) {
        this.viewGroupProfileController = viewGroupProfileController;
    }

    @Override
    public void setGroupDescription(String description) {
        this.groupDescription = description;
    }

    @Override
    public void setGroupPreferences(HashMap<String, String> preferences) {
        this.groupPreferences = preferences;
    }


    @Override
    public void initializeComponents() {
        this.add(groupNameLabel);
        this.textBox = new JTextArea();
        this.textBox.setSize(200,200);

        textBox.setLineWrap(true);
        textBox.setEditable(false);

    }

    @Override
    public void buildScrollPane() {
        scrollPane.setViewportView(textBox);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        this.add(scrollPane);
    }

    @Override
    public void setComponents() {
        groupNameLabel.setText(groupName);
        textBox.setText(this.groupDescription + "\n\n");

        for(String s : this.groupPreferences.keySet()) {
            textBox.append(s + ": " + this.groupPreferences.get(s) + "\n");
        }

        textBox.setLineWrap(true);
        textBox.setEditable(false);
        scrollPane.setViewportView(textBox);

    }

    private class buttonPress implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == back) {
                cardLayout.show(screens, "homepage");
            }

        }
    }
}
