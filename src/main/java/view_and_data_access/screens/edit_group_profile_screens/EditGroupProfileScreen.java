package view_and_data_access.screens.edit_group_profile_screens;

import controllers_presenters_and_screen_boundaries.edit_group_profile_adapters.EditGroupProfileController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditGroupProfileScreen extends JFrame implements ActionListener{
    EditGroupProfileController editController;
    JButton saveEdits = new JButton("Save Edits");
    JButton exit = new JButton("Exit");

    public EditGroupProfileScreen() {
        this.setVisible(true);
        this.setSize(600, 500);
         JPanel main = new JPanel();
         main.setLayout(new BorderLayout());

         JPanel menubar = new JPanel();
         menubar.setPreferredSize(new Dimension(main.getWidth(), 32));
         JLabel title = new JLabel("Edit Group Profile");
         menubar.add(title);

         menubar.add(exit);

        menubar.add(saveEdits);

         main.add(menubar, BorderLayout.NORTH);

         /*Adding options*/
        JPanel preferences = new JPanel();
        preferences.setLayout(new BoxLayout(preferences, BoxLayout.Y_AXIS));

        JLabel locationLabel = new JLabel("Location: ");
        JPanel locationOptions = new JPanel();
        JRadioButton locationOption1 = new JRadioButton("Online");
        JRadioButton locationOption2 = new JRadioButton("In-person");
        locationOptions.add(locationOption1);
        locationOptions.add(locationOption2);

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
            this.add(main);
            exit.addActionListener(this);
            exit.setBounds(5, 5, 5 ,5);
            this.add(exit);
            saveEdits.addActionListener(this);
            saveEdits.setBounds(50, 50, 5 ,5);
            this.add(saveEdits);
        }

        @Override
        public void actionPerformed(ActionEvent evt) {
            if (evt.getSource() == this.exit) {
                this.dispose();
                //new LeaveGroupScreen("Julia");
            }
            if (evt.getSource() == this.saveEdits) {
                this.dispose();
                //new CancelAppScreen("Julia");
            }
            }

}