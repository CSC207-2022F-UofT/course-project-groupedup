package group_creation_screens;
import cancel_application_screens.ViewApplicationsListController;
import leave_group_screens.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This is the HomePage which the User who is logged in will see.
 * Here the matching algorithm will be displayed and the user can click
 * the 'Create a group' button to create a new group, through the group
 * creation use case.
 *
 */
public class HomePage extends JPanel implements ActionListener{
    JButton groupCreation = new JButton("Create a group");
    JButton myApplications = new JButton("My Applications");
    JButton myGroups = new JButton("My Groups");
    String username;
    ViewApplicationsListController viewApplicationsListController;
    ViewMyGroupsController viewMyGroupsController;
    CardLayout cardLayout;
    JPanel screens;
    JLabel title = new JLabel("Welcome to Grouped Up!");

    Integer screenSize = 500;

    public HomePage(CardLayout cardLayout, JPanel screens, String username){

        this.cardLayout = cardLayout;
        this.screens = screens;
        this.username = username;

        groupCreation.addActionListener(this);
        myApplications.addActionListener(this);
        myGroups.addActionListener(this);

        this.add(title);
        this.add(groupCreation);
        this.add(myApplications);
        this.add(myGroups);

        this.setSize(screenSize, screenSize);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    }

    /**
     * If the button which is clicked is the group creation button, then the
     * group creation screen will show up.
     *
     * @param evt the event to be processed
     */
    public void actionPerformed(ActionEvent evt) {
        System.out.println("Click " + evt.getActionCommand());

        if (evt.getSource() == groupCreation) {
            this.cardLayout.show(screens, "groupRegisterScreen");
        } else if (evt.getSource() == myApplications) {
            viewApplicationsListController.viewApplicationsList(username);
        } else if (evt.getSource() == myGroups) {
            viewMyGroupsController.viewMyGroups(username);
        }
    }

    public void setViewApplicationsListController(ViewApplicationsListController viewApplicationsListController) {
        this.viewApplicationsListController = viewApplicationsListController;
    }

    public void setViewMyGroupsController(ViewMyGroupsController viewMyGroupsController) {
        this.viewMyGroupsController = viewMyGroupsController;
    }
}
