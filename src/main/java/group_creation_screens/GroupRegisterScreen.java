package group_creation_screens;

import group_creation_use_case.GroupRegisterRequestModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static javax.swing.JOptionPane.showMessageDialog;


public class GroupRegisterScreen extends JPanel implements ActionListener {

    JTextField groupname = new JTextField(15);
    GroupRegisterController groupRegisterController;

    /**
     * A window with a title and a JButton.
     */
    public GroupRegisterScreen(GroupRegisterController controller) {

        this.groupRegisterController = controller;

        JLabel title = new JLabel("Register your new group");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton registerGroup = new JButton("Register Group");
        JButton cancel = new JButton("Cancel");

        JPanel buttons = new JPanel();
        buttons.add(registerGroup);
        buttons.add(cancel);

        registerGroup.addActionListener(this);
        cancel.addActionListener(this);

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(title);
        JLabel groupNameText = new JLabel("Choose your group's name");
        groupNameText.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.add(groupNameText);
        this.add(groupname);
        this.add(buttons);

    }


    /**
     * React to a button click that results in evt.
     */
    public void actionPerformed(ActionEvent evt) {
        System.out.println("Click " + evt.getActionCommand());

        try {
            groupRegisterController.create(groupname.getText());
            JOptionPane.showMessageDialog(this, (groupname.getText()) + " was successfully created.");
            /**
             * JFrame application = new JFrame("Group Creation Screen");
             *             CardLayout cardLayout = new CardLayout();
             *             JPanel screens = new JPanel(cardLayout);
             *             application.add(screens);
             *             NewGroupPageScreen newGroupPageScreen = new NewGroupPageScreen();
             *             screens.add(newGroupPageScreen, "welcome");
             *             cardLayout.show(screens, "register");
             *             application.pack();
             *             application.setVisible(true);
             */

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
}
