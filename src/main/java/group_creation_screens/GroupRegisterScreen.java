package group_creation_screens;

import group_creation_use_case.GroupRegisterRequestModel;

import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.*;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class GroupRegisterScreen implements ActionListener {
    JFrame frame = new JFrame();

    JTextField groupname = new JTextField(15);

    GroupRegisterController groupRegisterController;
    // Creating the buttons
    JButton registerGroup = new JButton("Register Group");
    JButton cancel = new JButton("Cancel");
    JLabel groupNameText = new JLabel("Choose your group's name: ");

    /**
     * The main Group Register Screen where the User who is logged in can enter the name of the
     * group they want to create and can press a register button to create the group.
     * Error messages pop up if an exception is thrown. A message also pops up upon successful
     * creation of the group. If the User wants to return to the previous screen, the cancel
     * button will take them back.
     */
    public GroupRegisterScreen(GroupRegisterController groupRegisterController) {
        this.groupRegisterController = groupRegisterController;


        // Buttons can listen to the frame
        registerGroup.setBounds(100, 150, 200, 40);
        registerGroup.setFocusable(false);
        registerGroup.addActionListener(this);
        cancel.setBounds(100, 200, 200, 40);
        cancel.addActionListener(this);
        frame.add(registerGroup);
        frame.add(cancel);
        groupNameText.setBounds(100, 50, 200, 40);


        groupname.setBounds(100, 75, 200, 40);

        frame.add(groupNameText);
        frame.add(groupname);
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setVisible(true);

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
                //groupRegisterController.create(groupname.getText());

                JOptionPane.showMessageDialog(frame, (groupname.getText()) + " was successfully created.");

                NewGroupPageScreen nextScreen = new NewGroupPageScreen(groupname.getText(), groupRegisterController);
                frame.dispose();

            } catch (Exception e) {
                JOptionPane.showMessageDialog(frame, e.getMessage());
            }
        }
        else if (evt.getSource() == cancel){
            System.out.println("Click " + evt.getActionCommand());

            // Go back to screen before this

        }


    }
}
