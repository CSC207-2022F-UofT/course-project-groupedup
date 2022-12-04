package cancel_application_screens;

import javax.swing.*;
import java.util.HashMap;

/**
 * The group profile screen.
 */
public class GroupProfileScreen extends JFrame implements GroupProfileScreenBoundary {
    String groupDescription;
    HashMap<String, String> groupPreferences;
    String groupName;
    String username;
    JTextArea textBox;

    /**
     * Initializes an empty group profile screen.
     * @param username the username of the current user
     */
    public GroupProfileScreen(String username) {
        setSize(400, 400);
        this.username = username;

        setVisible(false);
        this.initializeComponents();
        this.buildScrollPane();
    }

    @Override
    public void setGroupName(String groupName) {
        this.groupName = groupName;
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
    public void view() {
        this.setComponents();
        this.setVisible(true);
    }

    @Override
    public void initializeComponents() {

        this.textBox = new JTextArea();

        textBox.setLineWrap(true);
        textBox.setEditable(false);
    }

    @Override
    public void buildScrollPane() {
        JScrollPane scrollPane = new JScrollPane(textBox);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        this.add(scrollPane);
    }

    @Override
    public void setComponents() {

        textBox.setText(this.groupDescription + "\n\n");

        for(String s : this.groupPreferences.keySet()) {
            textBox.append(s + ": " + this.groupPreferences.get(s) + "\n");
        }

        textBox.setLineWrap(true);
        textBox.setEditable(false);
    }
}
