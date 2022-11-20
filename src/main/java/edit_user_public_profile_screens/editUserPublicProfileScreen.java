package edit_user_public_profile_screens;
import edit_user_public_profile_usecase.editUserPublicProfileResponseModel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JRadioButtonMenuItem;

import static javax.swing.JOptionPane.showMessageDialog;

public class editUserPublicProfileScreen extends JFrame implements ActionListener{
    JLabel title = new JLabel("Edit User Public Profile");

    JPanel locationMenu = new JPanel();

    /*The course preferences chosen by user */
    JTextField coursePreferences = new JTextField(15);

    /*The location chosen by user */
    JCheckBoxMenuItem locationOption1 = new JCheckBoxMenuItem("Online");

    JCheckBoxMenuItem locationOption2 = new JCheckBoxMenuItem("In-person");

    JCheckBoxMenuItem meetingTimeOption1 = new JCheckBoxMenuItem("Morning");
    JCheckBoxMenuItem meetingTimeOption2 = new JCheckBoxMenuItem("Afternoon");
    JCheckBoxMenuItem meetingTimeOption3 = new JCheckBoxMenuItem("Evening");

    JRadioButtonMenuItem timeCommitmentOption1 = new JRadioButtonMenuItem("0-2 hours");
    JRadioButtonMenuItem timeCommitmentOption2 = new JRadioButtonMenuItem("2-4 hours");
    JRadioButtonMenuItem timeCommitmentOption3 = new JRadioButtonMenuItem("5+ hours");

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}

// Frameworks/Drivers layer

public class RegisterScreen extends JPanel implements ActionListener {
    /**
     * The username chosen by the user
     */
    JTextField username = new JTextField(15);
    /**
     * The password
     */
    JPasswordField password = new JPasswordField(15);
    /**
     * The second password to make sure the user understands
     */
    JPasswordField repeatPassword = new JPasswordField(15);

    /**
     * The controller
     */
    UserRegisterController userRegisterController;

    /**
     * A window with a title and a JButton.
     */
    public RegisterScreen(UserRegisterController controller) {

        this.userRegisterController = controller;

        JLabel title = new JLabel("Register Screen");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        LabelTextPanel usernameInfo = new LabelTextPanel(
                new JLabel("Choose username"), username);
        LabelTextPanel passwordInfo = new LabelTextPanel(
                new JLabel("Choose password"), password);
        LabelTextPanel repeatPasswordInfo = new LabelTextPanel(
                new JLabel("Enter password again"), repeatPassword);

        JButton signUp = new JButton("Sign up");
        JButton cancel = new JButton("Cancel");

        JPanel buttons = new JPanel();
        buttons.add(signUp);
        buttons.add(cancel);

        signUp.addActionListener(this);
        cancel.addActionListener(this);

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(title);
        this.add(usernameInfo);
        this.add(passwordInfo);
        this.add(repeatPasswordInfo);
        this.add(buttons);

    }

    /**
     * React to a button click that results in evt.
     */
    public void actionPerformed(ActionEvent evt) {
        System.out.println("Click " + evt.getActionCommand());

        try {
            userRegisterController.create(username.getText(),
                    String.valueOf(password.getPassword()),
                    String.valueOf(repeatPassword.getPassword()));
            JOptionPane.showMessageDialog(this, "%s created.".formatted(username.getText()));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
}
