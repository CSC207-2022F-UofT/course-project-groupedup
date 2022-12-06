package edit_group_profile_screens;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class EditGroupProfileScreens extends JPanel implements edit_group_profile_screens.EditGroupProfileScreenBoundary {
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
    // hahahahahahahaha

    public EditGroupProfileScreens(CardLayout cardLayout, JPanel screens) {
        this.setSize(400, 500);
        //this.editGroupController = editGroupController;
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
                    String buttonSelected = button.getText();
                    if (buttonSelected.equals("Online") | buttonSelected.equals("In-person")) {
                        this.location = buttonSelected;
                    }
                }
            }
            for (JRadioButton button : meetingTimeList) {
                if (button.isSelected()) {
                    String buttonSelected = button.getText();
                    if (buttonSelected.equals("Monday") | buttonSelected.equals("Tuesday")
                            | buttonSelected.equals("Wednesday") | buttonSelected.equals("Thursday")
                            | buttonSelected.equals("Friday") | buttonSelected.equals("Saturday")
                            | buttonSelected.equals("Sunday")) {
                        this.meeting_time = buttonSelected;
                    }
                }
            }
            for (JRadioButton button : timeCommitList) {
                if (button.isSelected()) {
                    String buttonSelected = button.getText();
                    if (buttonSelected.equals("0-2 hours") | buttonSelected.equals("2-4 hours")
                            | buttonSelected.equals("5+ hours")) {
                        this.time_commit = buttonSelected;
                    }
                }
            }
            try{
                this.editGroupController.editedChanges(this.groupName, description.getText(),
                        this.time_commit, this.location, this.meeting_time, courseCode.getText());
            } catch (Exception e) {
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

        JLabel descriptionText = new JLabel("Group Description: ");
        JLabel courseCodeText = new JLabel("Course Code: ");

        exit.addActionListener(this);
        saveEdits.addActionListener(this);

        ButtonGroup b1 = new ButtonGroup();
        ButtonGroup b2 = new ButtonGroup();
        ButtonGroup b3 = new ButtonGroup();

        JPanel main = new JPanel();
        main.setLayout(new BorderLayout());
        JPanel buttons = new JPanel();
        JPanel menubar = new JPanel();


        descriptionText.setText("Group Description: " + description.getText());
        courseCodeText.setText("Course Code: " + courseCode.getText());

        buttons.add(title);

        menubar.add(descriptionText);
        menubar.add(description);

        menubar.add(courseCodeText);
        menubar.add(courseCode);

        buttons.add(saveEdits);
        buttons.add(exit);

        main.add(buttons, BorderLayout.CENTER);

        this.add(main);

        JPanel preferences = new JPanel();
        preferences.setLayout(new GridLayout(3, 2));

        /*Adding options*/
        JLabel locationLabel = new JLabel("Location: ");
        JPanel locationOptions = new JPanel();
        JRadioButton locationOption1 = new JRadioButton("Online");
        JRadioButton locationOption2 = new JRadioButton("In-person");
        b1.add(locationOption1);
        b1.add(locationOption2);
        locationOptions.add(locationOption1);
        locationOptions.add(locationOption2);
        locationList.add(locationOption1);
        locationList.add(locationOption2);


        JLabel meetingTimeLabel = new JLabel("Meeting Time: ");
        JPanel meetingTimeOptions = new JPanel();
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

        JLabel timeCommitmentLabel = new JLabel("Time Commitment: ");
        JPanel timeCommitmentOptions = new JPanel();
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

        this.add(preferences, BorderLayout.CENTER);
        this.add(menubar, BorderLayout.CENTER);
    }

    @Override
    public void setView(EditGroupProfileController editGroupController) {
        this.editGroupController = editGroupController;
        this.screens.add(this, "editGroupProfileScreen");
    }

    @Override
    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

}
