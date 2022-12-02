package UserSignupLoginScreens;

import Entities.AllControllers;
import userloginusecase.LoginInputPackage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginScreen extends JFrame implements ActionListener {

    private JButton loginButton;

    private JButton goToRegistrationButton;
    private JFrame jframe;
    private JTextField username;
    private JPasswordField password;
    private JLabel usernameLabel;
    private JLabel passwordLabel;
    private LabelTextPanel usernameInfo;
    private LabelTextPanel passwordInfo;
    private JLabel title;

    private LoginController loginController;

    public LoginScreen() {
        AllControllers allControllers = AllControllers.getInstance();
        loginController = allControllers.getLoginController();

        this.initializeValues();
        this.initializeComponents();
        this.initializeFrame();
    }

    private void initializeValues() {
        this.jframe = new JFrame();
        int HEIGHT = 640;
        int WIDTH = 640;
        this.jframe.setSize(WIDTH, HEIGHT);
        this.jframe.setResizable(false);
        this.jframe.getContentPane().setBackground(new Color(255, 255, 255));
        this.jframe.setLayout(null);
        this.jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.jframe.setLocationRelativeTo(null);
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
        this.jframe.add(this.title);
        this.jframe.add(this.usernameInfo);
        this.jframe.add(this.passwordInfo);
        this.jframe.add(this.loginButton);
        this.jframe.add(this.goToRegistrationButton);
        this.jframe.setVisible(true);
    }


    /**
     * React to a button click that results in evt.
     */
    public void actionPerformed(ActionEvent evt) {
        if(evt.getSource() == this.loginButton) {
            this.jframe.dispose();
            LoginInputPackage inputPackage =
                    new LoginInputPackage(username.getText(), String.valueOf(password.getPassword()));
            this.loginController.login(inputPackage);
        }
        else if (evt.getSource() == this.goToRegistrationButton){
            this.jframe.dispose();
            new UserRegistrationScreen();
        }
    }
}
