package edit_group_profile_screens;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class EditGroupProfileScreen extends JPanel implements  EditGroupProfileScreenBoundary{
    EditGroupProfileScreenBoundary editGroupScreen;
    CardLayout cardLayout;
    JPanel screens;
    String groupName;
    EditGroupProfileController editGroupController;
    JTextField description = new JTextField(100);
    JTextField courseCode = new JTextField(10);
    JButton saveEdits = new JButton("Save Edits");
    JButton exit = new JButton("Exit");

    String meeting_time = "";
    String time_commit = "";
    String location = "";


    /**
     * After clicking on the edit group button on the group page, this page will display the preferences
     * the group leader can edit for their group.
     * The User can then click on the 'Exit' button if they want to go back to the group profile main page
     * Otherwise, they can enter/change their preferences and click on the 'Save Changes' button to save their changes.
     */

    public EditGroupProfileScreen(EditGroupProfileScreenBoundary editGroupScreen, CardLayout cardLayout, JPanel screens) {
        this.editGroupController = editGroupController;
        this.editGroupScreen = editGroupScreen;
        this.cardLayout = cardLayout;
        this.screens = screens;
        this.build();

    }
        @Override
        public void actionPerformed(ActionEvent evt) {
            if (evt.getSource() == this.saveEdits) {
                try{
                    this.editGroupController.editedChanges(groupName, description.getText(),
                            time_commit, location, meeting_time, courseCode.getText());
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, e.getMessage());
                }

            } else if (evt.getSource() == this.exit) {
                System.out.println("Click " + evt.getActionCommand());
                cardLayout.show(screens,"viewGroupProfile");
            }

            }

    public void build() {
        JLabel title = new JLabel("Edit Group Profile");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel descriptionText = new JLabel("Group Description: ");
        JLabel courseCodeText = new JLabel("Course Code: ");

        exit.addActionListener(this);
        saveEdits.addActionListener(this);


        descriptionText.setText("Group Description: " + description);
        courseCodeText.setText("Course Code: " + courseCode);

        this.add(title);
        this.add(description);
        this.add(descriptionText);
        this.add(saveEdits);
        this.add(exit);
        this.setSize(500, 500);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JPanel main = new JPanel();
        main.setLayout(new BorderLayout());

        /*Adding options*/
        //JPanel preferences = new JPanel();
        //preferences.setLayout(new BoxLayout(preferences, BoxLayout.Y_AXIS));

        JLabel locationLabel = new JLabel("Location: ");
        // JPanel locationOptions = new JPanel();
        JRadioButton locationOption1 = new JRadioButton("Online");
        JRadioButton locationOption2 = new JRadioButton("In-person");
        this.add(locationOption1);
        this.add(locationOption2);

        if (locationOption1.isSelected()) {
            location = "Online";
        } else if (locationOption2.isSelected()) {
            location = "In-person";
        }


        JLabel meetingTimeLabel = new JLabel("Meeting Time: ");
        //JPanel meetingTimeOptions = new JPanel();
        JRadioButton meetingTimeOption1 = new JRadioButton("Monday");
        JRadioButton meetingTimeOption2 = new JRadioButton("Tuesday");
        JRadioButton meetingTimeOption3 = new JRadioButton("Wednesday");
        JRadioButton meetingTimeOption4 = new JRadioButton("Thursday");
        JRadioButton meetingTimeOption5 = new JRadioButton("Friday");
        JRadioButton meetingTimeOption6 = new JRadioButton("Saturday");
        JRadioButton meetingTimeOption7 = new JRadioButton("Sunday");
        this.add(meetingTimeOption1);
        this.add(meetingTimeOption2);
        this.add(meetingTimeOption3);
        this.add(meetingTimeOption4);
        this.add(meetingTimeOption5);
        this.add(meetingTimeOption6);
        this.add(meetingTimeOption7);

        if (meetingTimeOption1.isSelected()) {
            meeting_time = "Monday";
        } else if (meetingTimeOption2.isSelected()) {
            meeting_time = "Tuesday";
        } else if (meetingTimeOption3.isSelected()) {
            meeting_time = "Wednesday";
        } else if (meetingTimeOption4.isSelected()) {
            meeting_time = "Thursday";
        } else if (meetingTimeOption5.isSelected()) {
            meeting_time = "Friday";
        } else if (meetingTimeOption6.isSelected()) {
            meeting_time = "Saturday";
        } else if (meetingTimeOption7.isSelected()) {
            meeting_time = "Sunday";
        }

        JLabel timeCommitmentLabel = new JLabel("Time Commitment: ");

        JRadioButton timeCommitmentOption1 = new JRadioButton("0-2 hours");
        JRadioButton timeCommitmentOption2 = new JRadioButton("2-4 hours");
        JRadioButton timeCommitmentOption3 = new JRadioButton("5+ hours");
        this.add(timeCommitmentOption1);
        this.add(timeCommitmentOption2);
        this.add(timeCommitmentOption3);

        if (timeCommitmentOption1.isSelected()) {
            time_commit = "0-2 hours";
        } else if (timeCommitmentOption2.isSelected()) {
            time_commit = "2-4 hours";
        } else if (timeCommitmentOption3.isSelected()) {
            time_commit = "5+ hours";
        }


        this.add(locationLabel);

        this.add(meetingTimeLabel);

        this.add(timeCommitmentLabel);

        this.add(description);

        this.add(courseCode);
    }

    public void setPreferences(HashMap<String, String> preferences) {
        this.location = preferences.get("Location");
        this.meeting_time = preferences.get("Meeting Time");
        this.time_commit = preferences.get("Time Commitment");
    }



    @Override
    public void switchScreen(HashMap<String, String> preferences) {
        editGroupScreen.setPreferences(preferences);
        editGroupScreen.setDescription(description.getText());
        editGroupScreen.setCourseCode(courseCode.getText());
        this.cardLayout.show(screens, "editGroupScreen");
    }

    @Override
    public void setView(EditGroupProfileController editGroupController) {
        this.editGroupController = editGroupController;
        this.screens.add(this, "editGroupProfileScreen");
    }


}

