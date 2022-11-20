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
     * The main Group Register Screen where the User who is logged in can enter the name of the
     * group they want to create and can press a register button to create the group.
     * Error messages pop up if an exception is thrown. A message also pops up upon successful
     * creation of the group. If the User wants to return to the previous screen, the cancel
     * button will take them back.
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
     * If the group was successfully created, the controller will trigger the group creation use case.
     * Otherwise, an exception will be thrown.
     */
    public void actionPerformed(ActionEvent evt) {
        System.out.println("Click " + evt.getActionCommand());

        try {
            groupRegisterController.create(groupname.getText());
            JOptionPane.showMessageDialog(this, (groupname.getText()) + " was successfully created.");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
}
