package group_creation_screens;

import edit_group_profile_screens.EditGroupProfileScreenBoundary;

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
public class NewGroupPageScreen extends JPanel implements NewGroupScreenBoundary {
    EditGroupProfileScreenBoundary editGroupScreen;
    JButton homePage = new JButton("Home Page");
    JButton editGroup = new JButton("Edit Group Information");
    JButton pendingList = new JButton("Pending Group List");
    JLabel groupNameText = new JLabel();
    CardLayout cardLayout;
    JPanel screens;
    String groupName;

    GroupRegisterController groupRegisterController;


    public NewGroupPageScreen(EditGroupProfileScreenBoundary editGroupScreen, CardLayout cardLayout, JPanel screens) {
        this.editGroupScreen = editGroupScreen;
        this.cardLayout = cardLayout;
        this.screens = screens;
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
            editGroupScreen.setGroupName(groupName);
            cardLayout.show(screens, "editGroupScreen");
        }
        else if (evt.getSource() == pendingList){
            // CONNECT WITH PENDING LIST

        }
    }

    public void build() {

        homePage.addActionListener(this);


        editGroup.addActionListener(this);


        pendingList.addActionListener(this);

        this.add(groupNameText);
        this.add(homePage);
        this.add(editGroup);
        this.add(pendingList);



        this.setSize(500, 500);

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
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
