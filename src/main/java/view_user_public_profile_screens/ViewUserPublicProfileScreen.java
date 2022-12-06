package view_user_public_profile_screens;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class ViewUserPublicProfileScreen extends JFrame implements ActionListener, ViewUserPublicProfileScreenBoundary {
    CardLayout cardLayout;
    JPanel screens;

    String username;
    String bio;
    String courses;
    HashMap<String, String> userPreferences;

    ViewUserPublicProfileController controller;

    JButton edit = new JButton("Edit");
    JButton exit = new JButton("Exit");

    public ViewUserPublicProfileScreen(CardLayout cardlayout, JPanel screens) {
        this.screens = screens;
        this.cardLayout = cardlayout;
        this.setSize(500,500);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == edit) {
            cardLayout.show(null, "editUserProfileScreen");
        }

        if (e.getSource() == exit) {
            cardLayout.show(null, "homepage");
        }
    }

    @Override
    public void build() {
        JPanel mainPanel = new JPanel(new BorderLayout());

        /*Creating the top menu bar*/
        JPanel northPanel = new JPanel();
        JLabel title = new JLabel(username + "'s Public Profile");
        title.setFont(new Font("Serif", Font.PLAIN, 20));

        edit.addActionListener(this);
        exit.addActionListener(this);
        northPanel.add(title);
        northPanel.add(edit);
        northPanel.add(exit);
        mainPanel.add(northPanel, BorderLayout.NORTH);

        /*Creating the public profile*/
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(5, 1));
        JLabel bioLabel = new JLabel("Bio: " + bio, SwingConstants.CENTER);
        JLabel coursesLabel = new JLabel("Courses: " + courses, SwingConstants.CENTER);
        JLabel locationLabel = new JLabel("Location: " + userPreferences.get("Location"), SwingConstants.CENTER);
        JLabel meetingTimeLabel = new JLabel("Meeting Time: " + userPreferences.get("Meeting Time"), SwingConstants.CENTER);
        JLabel timeCommitmentLabel = new JLabel("Time Commitment: " + userPreferences.get("Time Commitment"), SwingConstants.CENTER);
        centerPanel.add(bioLabel);
        centerPanel.add(coursesLabel);
        centerPanel.add(locationLabel);
        centerPanel.add(meetingTimeLabel);
        centerPanel.add(timeCommitmentLabel);
        mainPanel.add(centerPanel, BorderLayout.CENTER);

        this.add(mainPanel);
    }

    @Override
    public void setController(ViewUserPublicProfileController viewUserPublicProfileController) {
        this.controller = viewUserPublicProfileController;
    }

    @Override
    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public void setBio(String bio) {
        this.bio = bio;
    }

    @Override
    public void setCourses(String courses) {
        this.courses = courses;
    }

    @Override
    public void setUserPreferences(HashMap<String,String> userPreferences) {
        this.userPreferences = userPreferences;
    }

    @Override
    public void view() {
        this.build();
        this.setVisible(true);
    }
}
