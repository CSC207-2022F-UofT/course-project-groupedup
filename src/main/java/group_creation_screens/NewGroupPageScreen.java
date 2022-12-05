package group_creation_screens;

import edit_group_profile_screens.EditGroupProfileScreenBoundary;
import pending_list_screens.*;
import pending_list_screens.ViewGroupMembersController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * After successful creation of a group, this page will display the newly created Group.
 * The User can then click on the 'Edit Group Information' button if they want to edit
 * the group's profile and add more details. Otherwise, they can click the 'Home Page'
 * button and go back to the home page. They can also click the 'Pending group list' button
 * to see which users want to join their group.
 */
public class NewGroupPageScreen extends JPanel implements ActionListener {
    JButton homePage = new JButton("Home Page");
    JButton editGroup = new JButton("Edit Group Information");
    JButton pendingList = new JButton("Pending List");
    JButton membersList = new JButton("Group Members");
    JLabel groupNameText = new JLabel();
    String groupName;
    //    PendingListScreenBoundary pendingListScreen;
    CardLayout cardLayout;
    JPanel screens;
    GroupRegisterController groupRegisterController;

    Integer SCREEN_SIZE = 500;

    ViewPendingListController viewPendingListController;
    ViewGroupMembersController viewGroupMembersController;
    EditGroupProfileScreenBoundary editGroupScreen;


    public NewGroupPageScreen(CardLayout cardLayout, JPanel screens, ViewPendingListController viewPendingListController,
                              ViewGroupMembersController viewGroupMembersController, EditGroupProfileScreenBoundary editGroupScreen) {
        this.cardLayout = cardLayout;
        this.screens = screens;
        this.viewPendingListController = viewPendingListController;
        this.viewGroupMembersController = viewGroupMembersController;
        this.editGroupScreen = editGroupScreen;
        build();

    }

    /**
     * React to a button click that results in evt.
     *
     * The homepage button will take them back to the use case.
     * The edit group button will allow them to edit/add more information about this group.
     * The pending list button will allow them to see which users applied to their group.
     */

    public void actionPerformed(ActionEvent evt) {

        System.out.println("Click " + evt.getActionCommand());
        if (evt.getSource() == homePage){
                cardLayout.show(screens, "homepage");

        }
        else if (evt.getSource() == editGroup){
            // CONNECT JULIA'S USE CASE
            editGroupScreen.setGroupName(groupName);
            cardLayout.show(screens, "editGroupScreen");
        }
        else if (evt.getSource() == pendingList){
            // CONNECT WITH PENDING LIST
            viewPendingListController.getUsernames(groupName);
        }
        else if (evt.getSource() == membersList) {
            viewGroupMembersController.getGroupMembers(groupName);
        }
    }

    /**
     * Initializes all the components of the screen and adds them to the JPanel.
     */
    public void build() {
        groupNameText.setText("Group's name: " + groupName);

        homePage.addActionListener(this);
        editGroup.addActionListener(this);
        pendingList.addActionListener(this);

        editGroup.addActionListener(this);

        pendingList.addActionListener(this);

        membersList.addActionListener(this);

        this.add(groupNameText);
        this.add(homePage);
        this.add(editGroup);
        this.add(pendingList);
        this.setSize(SCREEN_SIZE, SCREEN_SIZE);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(membersList);

    }

    /**
     *
     * @param screenName
     */
    public void switchScreen(String screenName) {

    }

    /**
     * Initializes the screens controller and adds this screen to the cardLayout stack.
     * @param groupRegisterController
     */
    public void setView(GroupRegisterController groupRegisterController) {
        this.groupRegisterController = groupRegisterController;
        this.screens.add(this, "newGroupPageScreen");
    }

    /**
     * Initializes the screens groupName attribute.
     * @param groupName
     */
    public void setGroupName(String groupName){
        this.groupName = groupName;
        groupNameText.setText("Group's name: " + groupName);
    }

    /**
     * Displays a pop-up error message.
     * @param error
     */
    public void prepareFailView(String error) {
        JOptionPane.showMessageDialog(this, error);

    }



}
