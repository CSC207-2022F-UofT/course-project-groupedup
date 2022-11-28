package edit_user_public_profile_screens;
import view_user_public_profile_screens.ViewUserPublicProfileScreen;
import edit_user_public_profile_screens.EditUserPublicProfileController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditUserPublicProfileScreen extends JFrame implements ActionListener{
    EditUserPublicProfileController controller;
    JButton submit = new JButton("Submit");
    JButton exit = new JButton("Exit");
    JCheckBox locationOption1 = new JCheckBox("Online");
    JCheckBox locationOption2 = new JCheckBox("In-person");


    public EditUserPublicProfileScreen(EditUserPublicProfileController controller) {
        this.controller = controller;
        this.setVisible(true);
        this.setSize(500, 500);

        JPanel main = new JPanel();
        main.setLayout(new BorderLayout());

        JPanel menubar = new JPanel();
        JLabel title = new JLabel("Edit User Public Profile");
        menubar.add(title);

        exit.addActionListener(this);
        menubar.add(exit);

        main.add(menubar, BorderLayout.NORTH);

        /*Adding options*/
        JPanel preferences = new JPanel();
        preferences.setLayout(new GridLayout(0, 2));

        JLabel locationLabel = new JLabel("Location: ");
        JPanel locationOptions = new JPanel();
//        JCheckBox locationOption1 = new JCheckBox("Online");
//        JCheckBox locationOption2 = new JCheckBox("In-person");
        locationOptions.add(locationOption1);
        locationOptions.add(locationOption2);

        JLabel meetingTimeLabel = new JLabel("Meeting Time: ");
        JPanel meetingTimeOptions = new JPanel();
        JCheckBox meetingTimeOption1 = new JCheckBox("Morning");
        JCheckBox meetingTimeOption2 = new JCheckBox("Afternoon");
        JCheckBox meetingTimeOption3 = new JCheckBox("Evening");
        meetingTimeOptions.add(meetingTimeOption1);
        meetingTimeOptions.add(meetingTimeOption2);
        meetingTimeOptions.add(meetingTimeOption3);

        JLabel timeCommitmentLabel = new JLabel("Time Commitment: ");
        JPanel timeCommitmentOptions = new JPanel();
        ButtonGroup options = new ButtonGroup();
        JRadioButton timeCommitmentOption1 = new JRadioButton("0-2 hours");
        JRadioButton timeCommitmentOption2 = new JRadioButton("2-4 hours");
        JRadioButton timeCommitmentOption3 = new JRadioButton("5+ hours");
        timeCommitmentOptions.add(timeCommitmentOption1);
        timeCommitmentOptions.add(timeCommitmentOption2);
        timeCommitmentOptions.add(timeCommitmentOption3);
        options.add(timeCommitmentOption1);
        options.add(timeCommitmentOption2);
        options.add(timeCommitmentOption3);

        preferences.add(locationLabel);
        preferences.add(locationOptions);

        preferences.add(meetingTimeLabel);
        preferences.add(meetingTimeOptions);

        preferences.add(timeCommitmentLabel);
        preferences.add(timeCommitmentOptions);

        main.add(preferences, BorderLayout.CENTER);

        submit.addActionListener(this);
        submit.setBounds(100,100,200,40);
        main.add(submit, BorderLayout.SOUTH);

        this.add(main);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.submit){
            this.dispose();
            this.controller.editedChanges("test1", "jfdoajf","sjoajfd", "djsaofj",
                    "fkjdoajfd", "fdnsgjf");
            new ViewUserPublicProfileScreen("hello", "jfdoajf", "fkjdoajfd", "fdnsgjf");
        }

        if(e.getSource() == this.exit) {
            this.dispose();
            new ViewUserPublicProfileScreen("djsaojfd", "djsoajf", "djsoajf", "kdsaojf");
        }
    }
}