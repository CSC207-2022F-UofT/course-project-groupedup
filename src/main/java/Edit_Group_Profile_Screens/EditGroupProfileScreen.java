package Edit_Group_Profile_Screens;
import Screens.CancelAppScreen;
import Screens.LeaveGroupScreen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditGroupProfileScreen extends JFrame implements ActionListener{
    EditGroupProfileController editController;
    String groupName;
    JButton saveEdits = new JButton("Save Edits");
    JButton exit = new JButton("Exit");

    public EditGroupProfileScreen(String groupName) {
        this.setVisible(true);
        this.setSize(700, 700);
        this.groupName = groupName;
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

        JTextField description = new JTextField("Description");

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

        preferences.add(description);


        main.add(preferences, BorderLayout.CENTER);
            this.add(main);
            saveEdits.addActionListener(this);
            saveEdits.setBounds(5, 5, 5 ,5);

        }

        @Override
        public void actionPerformed(ActionEvent evt) {
            if (evt.getSource() == this.saveEdits) {
                try{
                    JOptionPane.showMessageDialog(this, (groupName + " preferences were successfully saved."));
                    //this.dispose();
                    //EditGroupProfileScreen newScreen = new EditGroupProfileScreen(groupName);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, e.getMessage());
                }

            }

            }

}