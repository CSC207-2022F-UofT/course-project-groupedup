package UserSignupLoginScreens;

import UserRegistrationUsecase.UserRegistrationInputPackage;
import userloginusecase.LoginInputPackage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * concrete implementation of user registration screen
 * code name "user registration"
 */

public class UserRegistrationScreen extends JPanel
        implements ActionListener, UserRegistrationScreenInterface {

    private JButton loginButton;

    private JButton goToRegistrationButton;
    private JTextField username;
    private JTextField name;
    private JTextField email;
    private JPasswordField password;
    private JPasswordField repeatPassword;
    private JLabel usernameLabel;
    private JLabel passwordLabel;
    private JLabel repeatPasswordLabel;
    private JLabel nameLabel;
    private JLabel emailLabel;
    private LabelTextPanel usernameInfo;
    private LabelTextPanel passwordInfo;
    private LabelTextPanel repeatPasswordInfo;
    private LabelTextPanel nameInfo;
    private LabelTextPanel emailInfo;
    private JLabel title;

    private JPanel screens;
    private CardLayout cardLayout;
    private UserRegistrationController userRegistrationController;

    public UserRegistrationScreen(JPanel screens, CardLayout cardLayout) {
        this.screens = screens;
        this.cardLayout = cardLayout;
        this.initializeComponents();
        this.initializeFrame();
    }

    private void initializeComponents() {
        this.title = new JLabel("REGISTRATION SCREEN");
        this.title.setBounds(220, 100, 300, 100);

        this.name = new JTextField(15);
        this.nameLabel = new JLabel("Input name");
        this.nameInfo = new LabelTextPanel(this.nameLabel, this.name);
        this.nameInfo.setBounds(0, 200, 300, 30);

        this.username = new JTextField(15);
        this.usernameLabel = new JLabel("Input username");
        this.usernameInfo = new LabelTextPanel(this.usernameLabel, this.username);
        this.usernameInfo.setBounds(0, 230, 300, 30);

        this.password = new JPasswordField(15);
        this.passwordLabel = new JLabel("Input password");
        this.passwordInfo = new LabelTextPanel(this.passwordLabel, this.password);
        this.passwordInfo.setBounds(0, 260, 300, 30);

        this.repeatPassword = new JPasswordField(15);
        this.repeatPasswordLabel = new JLabel("Input password again");
        this.repeatPasswordInfo = new LabelTextPanel(this.repeatPasswordLabel, this.repeatPassword);
        this.repeatPasswordInfo.setBounds(0, 290, 300, 30);

        this.email = new JTextField(15);
        this.emailLabel = new JLabel("Input email");
        this.emailInfo = new LabelTextPanel(this.emailLabel, this.email);
        this.emailInfo.setBounds(0, 320, 300, 30);

        this.goToRegistrationButton = new JButton();
        this.goToRegistrationButton.setText("Register New User");
        this.goToRegistrationButton.setBounds(220, 400,100, 30);
        this.loginButton = new JButton();
        this.loginButton.setText("Return To Login");
        this.loginButton.setBounds(220, 450,100, 30);

        this.loginButton.addActionListener(this);
        this.goToRegistrationButton.addActionListener(this);

    }
    private void initializeFrame() {
        this.add(this.title);
        this.add(this.nameInfo);
        this.add(this.usernameInfo);
        this.add(this.passwordInfo);
        this.add(this.repeatPasswordInfo);
        this.add(this.emailInfo);
        this.add(this.goToRegistrationButton);
        this.add(this.loginButton);
        this.setVisible(true);
    }


    /**
     * React to a button click that results in evt.
     */
    public void actionPerformed(ActionEvent evt) {
        if(evt.getSource() == this.loginButton) {
            this.cardLayout.show(screens, "login page");
        }
        else if (evt.getSource() == this.goToRegistrationButton){
            UserRegistrationInputPackage inputPackage = new UserRegistrationInputPackage(
                    name.getText(), username.getText(), String.valueOf(password.getPassword()),
                    String.valueOf(repeatPassword.getPassword()), email.getText());
            this.userRegistrationController.create(inputPackage);
        }
    }

    @Override
    public void switchScreen(String screenName) {
        this.cardLayout.show(screens, screenName);
    }

    @Override
    public void setView(UserRegistrationController controller) {
        this.userRegistrationController = controller;
        this.screens.add(this, "user registration");
    }

    @Override
    public void resetFields() {
        this.username.setText("");
        this.password.setText("");
        this.repeatPassword.setText("");
    }
}
