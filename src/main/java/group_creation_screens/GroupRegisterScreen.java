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

        JLabel title = new JLabel("Group Register Screen");
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
        this.add(new JLabel("Choose groupname"));
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
            JOptionPane.showMessageDialog(this, "%s created.".format(groupname.getText()));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
}
