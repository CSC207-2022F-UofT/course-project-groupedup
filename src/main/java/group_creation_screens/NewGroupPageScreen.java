package group_creation_screens;

import pending_list_screens.*;
import pending_list_screens.ViewGroupMembersController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;


/**
 * After successful creation of a group, this page will display the newly created Group.
 * The User can then click on the 'Edit Group Information' button if they want to edit
 * the group's profile and add more details. Otherwise, they can click the 'Home Page'
 * button and go back to the home page. They can also click the 'Pending group list' button
 * to see which users want to join their group.
 */
public class NewGroupPageScreen extends JPanel implements NewGroupScreenBoundary {
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
    ViewPendingListController viewPendingListController;
    ViewGroupMembersController viewGroupMembersController;

    public NewGroupPageScreen(CardLayout cardLayout, JPanel screens, ViewPendingListController viewPendingListController,
                              ViewGroupMembersController viewGroupMembersController) {
        this.cardLayout = cardLayout;
        this.screens = screens;
        this.viewPendingListController = viewPendingListController;
        this.viewGroupMembersController = viewGroupMembersController;
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
            try {
                cardLayout.show(screens, "homepage");

            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, e.getMessage());
            }
        }
        else if (evt.getSource() == editGroup){
            // CONNECT JULIA'S USE CASE
        }
        else if (evt.getSource() == pendingList){
            // CONNECT WITH PENDING LIST
            viewPendingListController.getUsernames(groupName);
        }
        else if (evt.getSource() == membersList) {
            viewGroupMembersController.getGroupMembers(groupName);
        }
    }

    public void build() {
        groupNameText.setText("Group's name: " + groupName);

        homePage.addActionListener(this);

        editGroup.addActionListener(this);

        pendingList.addActionListener(this);

        membersList.addActionListener(this);

        this.add(groupNameText);
        this.add(homePage);
        this.add(editGroup);
        this.add(pendingList);
        this.add(membersList);

        this.setSize(500, 500);
//        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    }

    @Override
    public void switchScreen(String screenName) {

    }

    @Override
    public void setView(GroupRegisterController groupRegisterController) {
        this.groupRegisterController = groupRegisterController;
        this.screens.add(this, "newGroupPageScreen");
    }

    public void setGroupName(String groupName){
        this.groupName = groupName;
        groupNameText.setText("Group's name: " + groupName);
    }
}
