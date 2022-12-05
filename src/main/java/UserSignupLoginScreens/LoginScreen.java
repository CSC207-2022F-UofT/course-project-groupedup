package UserSignupLoginScreens;

import userloginusecase.LoginInputPackage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The screen for displaying to the user for log in information
 * code name "login page"
 */

public class LoginScreen extends JPanel implements ActionListener, LoginScreenInterface{

    private JButton loginButton;

    private JButton goToRegistrationButton;
    private JTextField username;
    private JPasswordField password;
    private JLabel usernameLabel;
    private JLabel passwordLabel;
    private LabelTextPanel usernameInfo;
    private LabelTextPanel passwordInfo;
    private JLabel title;

    private JPanel screens;
    private CardLayout cardLayout;
    private LoginController loginController;

    public LoginScreen(JPanel screens, CardLayout cardLayout) {
        this.screens = screens;
        this.cardLayout = cardLayout;
        this.initializeComponents();
        this.initializeFrame();
    }

    private void initializeComponents() {
        this.title = new JLabel("LOGINSCREEN");
        this.title.setBounds(220, 100, 100, 100);

        this.username = new JTextField(15);
        this.usernameLabel = new JLabel("Input username");
        this.usernameInfo = new LabelTextPanel(this.usernameLabel, this.username);
        this.usernameInfo.setBounds(0, 200, 300, 30);

        this.password = new JPasswordField(15);
        this.passwordLabel = new JLabel("Input password");
        this.passwordInfo = new LabelTextPanel(this.passwordLabel, this.password);
        this.passwordInfo.setBounds(0, 230, 300, 30);

        this.loginButton = new JButton();
        this.loginButton.setText("Login");
        this.loginButton.setBounds(220, 400,100, 30);
        this.goToRegistrationButton = new JButton();
        this.goToRegistrationButton.setText("Register New User");
        this.goToRegistrationButton.setBounds(220, 450,100, 30);

        this.loginButton.addActionListener(this);
        this.goToRegistrationButton.addActionListener(this);

    }
    private void initializeFrame() {
        this.add(this.title);
        this.add(this.usernameInfo);
        this.add(this.passwordInfo);
        this.add(this.loginButton);
        this.add(this.goToRegistrationButton);
        this.setVisible(true);
    }


    /**
     * React to a button click that results in evt.
     */
    public void actionPerformed(ActionEvent evt) {
        if(evt.getSource() == this.loginButton) {
            LoginInputPackage inputPackage =
                    new LoginInputPackage(username.getText(), String.valueOf(password.getPassword()));
            this.loginController.login(inputPackage);
//            this.matchController.asdsadhjksdjkhfdshjkfsdjkfdjskfkjhsdf
        }
        else if (evt.getSource() == this.goToRegistrationButton){
            this.cardLayout.show(screens, "user registration");
        }
    }

    @Override
    public void switchScreen(String screenName) {
        this.cardLayout.show(screens, screenName);
    }

    @Override
    public void setView(LoginController controller) {
        this.loginController = controller;
        this.screens.add(this, "login page");
    }

    @Override
    public void resetFields() {
        this.password.setText("");
        this.username.setText("");
    }

}
