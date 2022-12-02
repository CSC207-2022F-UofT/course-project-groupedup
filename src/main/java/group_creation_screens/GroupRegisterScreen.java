package group_creation_screens;

import group_creation_use_case.GroupRegisterRequestModel;

import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class GroupRegisterScreen extends JPanel implements ActionListener {

    JTextField groupname = new JTextField(15);

    GroupRegisterController groupRegisterController;
    // Creating the buttons
    JButton registerGroup = new JButton("Register Group");
    JButton cancel = new JButton("Cancel");

    /**
     * The main Group Register Screen where the User who is logged in can enter the name of the
     * group they want to create and can press a register button to create the group.
     * Error messages pop up if an exception is thrown. A message also pops up upon successful
     * creation of the group. If the User wants to return to the previous screen, the cancel
     * button will take them back.
     */
    public GroupRegisterScreen(GroupRegisterController groupRegisterController) {
        this.groupRegisterController = groupRegisterController;

        JLabel title = new JLabel("Enter your group's name: ");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        registerGroup.addActionListener(this);

        cancel.addActionListener(this);

        this.add(title);
        this.add(groupname);
        this.add(registerGroup);
        this.add(cancel);
        this.setSize(500, 500);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

    }


    /**
     * React to a button click that results in evt.
     * If the group was successfully created, the controller will trigger the group creation use case.
     * Otherwise, an exception will be thrown.
     */
    @Override
    public void actionPerformed(ActionEvent evt) {
        System.out.println("Click " + evt.getActionCommand());
        if (evt.getSource() == registerGroup){
            try {
                this.groupRegisterController.create(groupname.getText());


            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, e.getMessage());
            }
        }
        else if (evt.getSource() == cancel){
            System.out.println("Click " + evt.getActionCommand());

            // TO DO: Go back to screen before this

        }


    }
}
