package view_and_data_access.screens.group_profile_screens;

import interface_adapters.edit_group_profile_adapters.EditGroupProfileController;
import interface_adapters.edit_group_profile_adapters.EditGroupProfileScreenBoundary;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class EditGroupProfileScreen extends JPanel implements EditGroupProfileScreenBoundary {
    CardLayout cardLayout;
    JPanel screens;
    String groupName;

    EditGroupProfileController editGroupController;
    JTextField description = new JTextField(10);
    JTextField courseCode = new JTextField(10);
    JButton saveEdits = new JButton("Save Edits");
    JButton exit = new JButton("Exit");

    String meeting_time = "";
    String time_commit = "";
    String location = "";

    ArrayList<JRadioButton> locationList = new ArrayList<>();
    ArrayList<JRadioButton> timeCommitList = new ArrayList<>();
    ArrayList<JRadioButton> meetingTimeList = new ArrayList<>();

    /**
     * After clicking on the edit group button on the group page, this page will display the preferences
     * the group leader can edit for their group.
     * The User can then click on the 'Exit' button if they want to go back to the group profile main page
     * Otherwise, they can enter/change their preferences and click on the 'Save Changes' button to save their changes.
     */

    public EditGroupProfileScreen(CardLayout cardLayout, JPanel screens) {
        this.setSize(400, 200);
        this.cardLayout = cardLayout;
        this.screens = screens;
        this.build();

    }

    /** React to a button click that results in evt.
     * If the group profile was edited successfully, the controller will trigger the use case.
     * Otherwise, an exception will be thrown.
     * If the user presses the Exit button, they will be redirected to Group Profile page.
     */

    @Override
    public void actionPerformed(ActionEvent evt) {
        if (evt.getSource() == this.saveEdits) {

            for(JRadioButton button: locationList) {
                if (button.isSelected()) {
                    this.location = button.getText();

                }
            }
            for (JRadioButton button : meetingTimeList) {
                if (button.isSelected()) {
                    this.meeting_time = button.getText();
                }
            }
            for (JRadioButton button : timeCommitList) {
                if (button.isSelected()) {
                    this.time_commit = button.getText();
                    }
                }
            try{
                this.editGroupController.editedChanges(this.groupName, description.getText(),
                        this.time_commit, this.location, this.meeting_time, courseCode.getText());
            } catch (Exception error) {
                JOptionPane.showMessageDialog(this, "Failure to Save Changes!");
            }
        } else if (evt.getSource() == this.exit) {
            System.out.println("Click " + evt.getActionCommand());
            cardLayout.show(screens,"newGroupPageScreen");

        }

    }

    public void build() {
        JLabel title = new JLabel("Edit Group Profile");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel descriptionText = new JLabel("Group Description: ", SwingConstants.CENTER);
        descriptionText.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel courseCodeText = new JLabel("Course Code: ", SwingConstants.CENTER);

        exit.addActionListener(this);
        saveEdits.addActionListener(this);

        ButtonGroup b1 = new ButtonGroup();
        ButtonGroup b2 = new ButtonGroup();
        ButtonGroup b3 = new ButtonGroup();

        this.setLayout(new BoxLayout(this, 1));
        JPanel buttons = new JPanel();
        JPanel descriptionPanel = new JPanel();
        JPanel coursePanel = new JPanel();

        descriptionText.setText("Group Description: " + description.getText());
        courseCodeText.setText("Course Code: " + courseCode.getText());

        buttons.add(title);

        descriptionPanel.add(descriptionText);
        descriptionPanel.add(description);

        coursePanel.add(courseCodeText);
        coursePanel.add(courseCode);

        buttons.add(saveEdits);
        buttons.add(exit);

        this.add(buttons, BorderLayout.NORTH);

        JPanel preferences = new JPanel();
        preferences.setLayout(new GridLayout(4, 2));

        /*Adding options*/
        JLabel locationLabel = new JLabel("Location: ", SwingConstants.CENTER);
        JPanel locationOptions = new JPanel();
        locationOptions.setLayout(new GridLayout(1, 2));
        JRadioButton locationOption1 = new JRadioButton("Online");
        JRadioButton locationOption2 = new JRadioButton("In-Person");
        b1.add(locationOption1);
        b1.add(locationOption2);
        locationOptions.add(locationOption1);
        locationOptions.add(locationOption2);
        locationList.add(locationOption1);
        locationList.add(locationOption2);

        JLabel meetingTimeLabel = new JLabel("Meeting Time: ", SwingConstants.CENTER);
        JPanel meetingTimeOptions = new JPanel();
        meetingTimeOptions.setLayout(new GridLayout(4, 2));
        JRadioButton meetingTimeOption1 = new JRadioButton("Monday");
        JRadioButton meetingTimeOption2 = new JRadioButton("Tuesday");
        JRadioButton meetingTimeOption3 = new JRadioButton("Wednesday");
        JRadioButton meetingTimeOption4 = new JRadioButton("Thursday");
        JRadioButton meetingTimeOption5 = new JRadioButton("Friday");
        JRadioButton meetingTimeOption6 = new JRadioButton("Saturday");
        JRadioButton meetingTimeOption7 = new JRadioButton("Sunday");
        meetingTimeOptions.add(meetingTimeOption1);
        meetingTimeOptions.add(meetingTimeOption2);
        meetingTimeOptions.add(meetingTimeOption3);
        meetingTimeOptions.add(meetingTimeOption4);
        meetingTimeOptions.add(meetingTimeOption5);
        meetingTimeOptions.add(meetingTimeOption6);
        meetingTimeOptions.add(meetingTimeOption7);
        b2.add(meetingTimeOption1);
        b2.add(meetingTimeOption2);
        b2.add(meetingTimeOption3);
        b2.add(meetingTimeOption4);
        b2.add(meetingTimeOption5);
        b2.add(meetingTimeOption6);
        b2.add(meetingTimeOption7);
        meetingTimeList.add(meetingTimeOption1);
        meetingTimeList.add(meetingTimeOption2);
        meetingTimeList.add(meetingTimeOption3);
        meetingTimeList.add(meetingTimeOption4);
        meetingTimeList.add(meetingTimeOption5);
        meetingTimeList.add(meetingTimeOption6);
        meetingTimeList.add(meetingTimeOption7);

        JLabel timeCommitmentLabel = new JLabel("Time Commitment: ", SwingConstants.CENTER);
        JPanel timeCommitmentOptions = new JPanel();
        timeCommitmentOptions.setLayout(new GridLayout(1, 2));
        JRadioButton timeCommitmentOption1 = new JRadioButton("0-2 hours");
        JRadioButton timeCommitmentOption2 = new JRadioButton("2-4 hours");
        JRadioButton timeCommitmentOption3 = new JRadioButton("5+ hours");
        timeCommitmentOptions.add(timeCommitmentOption1);
        timeCommitmentOptions.add(timeCommitmentOption2);
        timeCommitmentOptions.add(timeCommitmentOption3);
        b3.add(timeCommitmentOption1);
        b3.add(timeCommitmentOption2);
        b3.add(timeCommitmentOption3);
        timeCommitList.add(timeCommitmentOption1);
        timeCommitList.add(timeCommitmentOption2);
        timeCommitList.add(timeCommitmentOption3);

        preferences.add(locationLabel);
        preferences.add(locationOptions);

        preferences.add(meetingTimeLabel);
        preferences.add(meetingTimeOptions);

        preferences.add(timeCommitmentLabel);
        preferences.add(timeCommitmentOptions);

        this.add(descriptionPanel, BorderLayout.SOUTH);
        this.add(coursePanel, BorderLayout.SOUTH);
        this.add(preferences, BorderLayout.CENTER);

    }

    @Override
    public void setView(EditGroupProfileController editGroupController) {
        this.editGroupController = editGroupController;
        this.screens.add(this, "editGroupProfileScreen");
    }

    @Override
    public void setEditGroupController(EditGroupProfileController editGroupController) {
        this.editGroupController = editGroupController;
    }

    @Override
    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    @Override
    public void resetFields() {
        this.groupName = "";
        this.courseCode.setText("");
        this.description.setText("");

        for(JRadioButton button: locationList) {
            button.setSelected(false);
        }
        for (JRadioButton button : meetingTimeList) {
            button.setSelected(false);
        }
        for (JRadioButton button : timeCommitList) {
            button.setSelected(false);
        }
    }

}
