package group_creation_screens;

import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * The main Group Register Screen where the User who is logged in can enter the name of the
 * group they want to create and can press a register button to create the group.
 * Error messages pop up if an exception is thrown. A message also pops up upon successful
 * creation of the group. If the User wants to return to the previous screen, the cancel
 * button will take them back.
 */

public class GroupRegisterScreen extends JPanel implements GroupCreationScreenBoundary {
    NewGroupPageScreen newGroupPageScreen;
    JTextField groupName = new JTextField(15);

    GroupRegisterController groupRegisterController;
    // Creating the buttons
    JButton registerGroup = new JButton("Register Group");
    JButton cancel = new JButton("Cancel");
    CardLayout cardLayout;
    JPanel screens;


    public GroupRegisterScreen(NewGroupPageScreen newGroupPageScreen, CardLayout cardLayout, JPanel screens) {
        this.newGroupPageScreen = newGroupPageScreen;
        this.cardLayout = cardLayout;
        this.screens = screens;
        build();

    }


    /**
     * React to a button click that results in evt.
     * If the group was successfully created, the controller will trigger the group creation use case.
     * Otherwise, an exception will be thrown.
     * If the user presses the cancel button, they will be redirected to the homepage.
     */
    @Override
    public void actionPerformed(ActionEvent evt) {
        System.out.println("Click " + evt.getActionCommand());
        if (evt.getSource() == registerGroup){
                this.groupRegisterController.create(groupName.getText());

        }
        else if (evt.getSource() == cancel){
            System.out.println("Click " + evt.getActionCommand());
            cardLayout.show(screens,"homepage");

        }


    }

    /**
     * Initializes the components of the screen and adds them to this JPanel.
     */
    @Override
    public void build() {
        JLabel title = new JLabel("Enter your group's name: ");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        registerGroup.addActionListener(this);

        cancel.addActionListener(this);

        this.add(title);
        this.add(groupName);
        this.add(registerGroup);
        this.add(cancel);
        this.setSize(500, 500);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    }

    /**
     * Passes the group's name to the newGroupPageScreen.
     * Will change the screen from this one to the newGroupPageScreen.
     * @param groupName
     */
    @Override
    public void switchScreen(String groupName) {
        newGroupPageScreen.setGroupName(groupName);
        this.cardLayout.show(screens, "newGroupPageScreen");
    }

    /**
     * This will initialize the screens controller and add this screen
     * to the cardLayout stack.
     * @param groupRegisterController
     */
    @Override
    public void setView(GroupRegisterController groupRegisterController) {
        this.groupRegisterController = groupRegisterController;
        this.screens.add(this, "groupRegisterScreen");
    }

    /**
     * If the use case fails, the screen will display a failure pop up message.
     * @param error
     */
    @Override
    public void prepareFailView(String error) {
        JOptionPane.showMessageDialog(this, error);
    }


}
