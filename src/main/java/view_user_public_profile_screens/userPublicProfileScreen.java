package view_user_public_profile_screens;
import view_user_public_profile_usecase.viewUserPublicProfileResponseModel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JCheckBoxMenuItem;

public class userPublicProfileScreen extends JFrame implements ActionListener {
    public userPublicProfileScreen(String username, String location, String meetingTime, String timeCommitment) {
        JLabel title = new JLabel(username + "Public Profile");

        JButton editPublicProfile = new JButton("Edit public profile");
        editPublicProfile.addActionListener(this);

        JPanel main = new JPanel();
        main.setLayout(new BoxLayout(main, BoxLayout.Y_AXIS));

        main.add(title);
        main.add(message);
        main.add(buttons);
        this.setContentPane(main);

        this.pack();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
    }
}
