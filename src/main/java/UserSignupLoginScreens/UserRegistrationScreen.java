package UserSignupLoginScreens;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserRegistrationScreen extends JFrame implements ActionListener {

    private JButton loginButton;

    private JButton goToRegistrationButton;
    private JFrame jframe;
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

    public UserRegistrationScreen() {
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
        this.jframe.add(this.title);
        this.jframe.add(this.nameInfo);
        this.jframe.add(this.usernameInfo);
        this.jframe.add(this.passwordInfo);
        this.jframe.add(this.repeatPasswordInfo);
        this.jframe.add(this.emailInfo);
        this.jframe.add(this.goToRegistrationButton);
        this.jframe.add(this.loginButton);
        this.jframe.setVisible(true);
    }


    /**
     * React to a button click that results in evt.
     */
    public void actionPerformed(ActionEvent evt) {
        if(evt.getSource() == this.loginButton) {
            this.jframe.dispose();
            new LoginScreen();
        }
        else if (evt.getSource() == this.goToRegistrationButton){
            this.goToRegistrationButton.setText("bbbbbbbb");
        }
    }
}
