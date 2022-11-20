package view_user_public_profile_screens;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewUserPublicProfileScreen extends JFrame implements ActionListener {
    public ViewUserPublicProfileScreen(String username, String location, String meetingTime, String timeCommitment) {
        this.setVisible(true);
        this.setSize(500,500);

        JPanel mainPanel = new JPanel(new BorderLayout());

        /*Creating the top menu bar*/
        JPanel northPanel = new JPanel();
        JLabel title = new JLabel(username + "'s Public Profile");
        title.setFont(new Font("Serif", Font.PLAIN, 20));

        //TODO: Link screens using buttons
        JButton edit = new JButton("Edit");
        JButton exit = new JButton("Exit");
        northPanel.add(title);
        northPanel.add(edit);
        northPanel.add(exit);
        mainPanel.add(northPanel, BorderLayout.NORTH);


        /*Creating the public profile*/
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(3, 1));
        JLabel locationLabel = new JLabel("Location: " + location, SwingConstants.CENTER);
        JLabel meetingTimeLabel = new JLabel("Meeting Time: " + meetingTime, SwingConstants.CENTER);
        JLabel timeCommitmentLabel = new JLabel("Time Commitment: " + timeCommitment, SwingConstants.CENTER);
        centerPanel.add(locationLabel);
        centerPanel.add(meetingTimeLabel);
        centerPanel.add(timeCommitmentLabel);
        mainPanel.add(centerPanel, BorderLayout.CENTER);

        this.add(mainPanel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Click" + e.getActionCommand());
    }
}
