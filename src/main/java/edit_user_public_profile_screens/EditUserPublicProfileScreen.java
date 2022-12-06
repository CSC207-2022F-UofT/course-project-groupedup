package edit_user_public_profile_screens;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class EditUserPublicProfileScreen extends JPanel implements ActionListener, EditUserPublicProfileScreenBoundary {
    CardLayout cardLayout;
    JPanel screens;
    EditUserPublicProfileController editUserPublicProfileController;
    String username;

    ArrayList<JToggleButton> locationButtons = new ArrayList<>();
    ArrayList<JToggleButton> meetingTimeButtons = new ArrayList<>();
    ArrayList<JToggleButton> timeCommitmentButtons = new ArrayList<>();

    String meeting_time = "";
    String time_commit = "";
    String location = "";

    JButton submit = new JButton("Submit");
    JButton exit = new JButton("Exit");
    JTextField bio = new JTextField("Enter your updated biography here.");
    JTextField courseCodes = new JTextField("Enter the codes of the courses you are interested in here.");


    public EditUserPublicProfileScreen(CardLayout cardLayout, JPanel screens) {
        this.setSize(300, 300);
        this.cardLayout = cardLayout;
        this.screens = screens;
        this.buildButtons();
        this.buildScrollPane();
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.submit){

            for (JToggleButton button: locationButtons) {
                if (button.isSelected()) {
                    this.location = button.getText();
                }
            }

            for (JToggleButton button: meetingTimeButtons) {
                if (button.isSelected()) {
                    this.meeting_time = button.getText();
                }
            }

            for (JToggleButton button: timeCommitmentButtons) {
                if (button.isSelected()) {
                    this.time_commit = button.getText();
                }
            }

            try{
                this.editUserPublicProfileController.editedChanges(username, bio.getText(), courseCodes.getText(),
                        this.time_commit, this.location, this.meeting_time);
            } catch (Exception error) {
                JOptionPane.showMessageDialog(this, "Failure to Save Changes!");
            }
        }


        if(e.getSource() == this.exit) {
            cardLayout.show(screens,"homepage");
        }
    }

    @Override
    public void setController(EditUserPublicProfileController editUserPublicProfileController) {
        this.editUserPublicProfileController = editUserPublicProfileController;
    }

    @Override
    public void setUsername(String username) {
        this.username = username;
    }


    @Override
    public void buildButtons() {
        this.setLayout(new BorderLayout());

        /*Making screen*/
        JPanel menubar = new JPanel();
        JLabel title = new JLabel("Edit " + username + "'s Public Profile");
        Font font = new Font("Century Gothic", Font.BOLD,20);
        title.setFont(font);
        menubar.add(title);

        exit.addActionListener(this);
        exit.setBounds(100,100,200,40);
        menubar.add(exit);

        this.add(menubar, BorderLayout.NORTH);

        submit.addActionListener(this);
        submit.setBounds(100,100,100,40);
        this.add(submit, BorderLayout.SOUTH);
    }


    public JPanel buildTimeCommitmentOptions() {
        JPanel timeCommitment = new JPanel();
        ButtonGroup timeCommitmentOptions = new ButtonGroup();
        JRadioButton timeCommitmentOption1 = new JRadioButton("0-2 hours");
        timeCommitmentOption1.addActionListener(this);

        JRadioButton timeCommitmentOption2 = new JRadioButton("2-4 hours");
        timeCommitmentOption2.addActionListener(this);

        JRadioButton timeCommitmentOption3 = new JRadioButton("5+ hours");
        timeCommitmentOption3.addActionListener(this);

        timeCommitment.add(timeCommitmentOption1);
        timeCommitment.add(timeCommitmentOption2);
        timeCommitment.add(timeCommitmentOption3);

        /*Adding to button group*/
        timeCommitmentOptions.add(timeCommitmentOption1);
        timeCommitmentOptions.add(timeCommitmentOption2);
        timeCommitmentOptions.add(timeCommitmentOption3);

        timeCommitmentButtons.add(timeCommitmentOption1);
        timeCommitmentButtons.add(timeCommitmentOption2);
        timeCommitmentButtons.add(timeCommitmentOption3);
        return timeCommitment;
    }

    public JPanel buildLocationOptions() {
        JPanel location = new JPanel();
        ButtonGroup locationOptions = new ButtonGroup();
        JRadioButton locationOnline = new JRadioButton("Online");
        locationOnline.addActionListener(this);
        JRadioButton locationInPerson = new JRadioButton("In-Person");
        locationInPerson.addActionListener(this);
        location.add(locationOnline);
        location.add(locationInPerson);
        locationOptions.add(locationOnline);
        locationOptions.add(locationInPerson);
        locationButtons.add(locationOnline);
        locationButtons.add(locationInPerson);
        return location;
    }

    public JPanel buildMeetingTimeOptions() {
        JPanel meetingTime = new JPanel();
        ButtonGroup meetingTimeOptions = new ButtonGroup();
        JRadioButton meetingTimeMorning = new JRadioButton("Morning");
        meetingTimeMorning.addActionListener(this);
        JRadioButton meetingTimeAfternoon = new JRadioButton("Afternoon");
        meetingTimeAfternoon.addActionListener(this);
        JRadioButton meetingTimeEvening = new JRadioButton("Evening");
        meetingTimeEvening.addActionListener(this);

        meetingTime.add(meetingTimeMorning);
        meetingTime.add(meetingTimeAfternoon);
        meetingTime.add(meetingTimeEvening);
        meetingTimeOptions.add(meetingTimeMorning);
        meetingTimeOptions.add(meetingTimeAfternoon);
        meetingTimeOptions.add(meetingTimeEvening);
        meetingTimeButtons.add(meetingTimeMorning);
        meetingTimeButtons.add(meetingTimeAfternoon);
        meetingTimeButtons.add(meetingTimeEvening);

        return meetingTime;
    }

    @Override
    public void buildScrollPane() {
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setViewportView(buildProfileInfo());
        this.add(scrollPane, BorderLayout.CENTER);
    }

    @Override
    public JPanel buildProfileInfo() {
        /*Adding options to change profile information*/
        JPanel profileInfo = new JPanel();
        profileInfo.setLayout(new GridLayout(5, 2));

        /*Profile bio*/
        JLabel bioLabel = new JLabel("Bio:", SwingConstants.CENTER);
        bio.setBounds(100,100,200,40);

        /*Profile course codes*/
        JLabel courseCodesLabel = new JLabel("Course Codes:", SwingConstants.CENTER);
        courseCodes.setBounds(100,100,200,40);

        /*Preferred time commitment*/
        JLabel timeCommitmentLabel = new JLabel("Time Commitment: ", SwingConstants.CENTER);

        /*Preferred location*/
        JLabel locationLabel = new JLabel("Location: ", SwingConstants.CENTER);

        /*Preferred meeting time*/
        JLabel meetingTimeLabel = new JLabel("Meeting Time: ", SwingConstants.CENTER);

        profileInfo.add(bioLabel);
        profileInfo.add(bio);

        profileInfo.add(courseCodesLabel);
        profileInfo.add(courseCodes);

        profileInfo.add(timeCommitmentLabel);
        profileInfo.add(buildTimeCommitmentOptions());

        profileInfo.add(locationLabel);
        profileInfo.add(buildLocationOptions());

        profileInfo.add(meetingTimeLabel);
        profileInfo.add(buildMeetingTimeOptions());

        return profileInfo;
    }
}