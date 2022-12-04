package group_creation_screens;

import Entities.*;
import MultiUsecaseUtil.SerializeDataAccess;
import UserRegistrationUsecase.UserRegistrationDSRequestPackage;
import edit_pending_list.EditPendingListDsGateway;
import edit_pending_list.EditPendingListInputBoundary;
import edit_pending_list.EditPendingListInteractor;
import edit_pending_list.EditPendingListOutputBoundary;
import pending_list_screens.*;
import view_pending_list.ViewPendingListDsGateway;
import view_pending_list.ViewPendingListInputBoundary;
import view_pending_list.ViewPendingListInteractor;
import view_pending_list.ViewPendingListOutputBoundary;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class NewGroupPageScreen extends JPanel implements ActionListener {
    JButton homePage = new JButton("Home Page");
    JButton editGroup = new JButton("Edit Group Information");
    JButton pendingList = new JButton("Pending List");
    JLabel groupNameText = new JLabel();
    String groupName;
    PendingListScreenBoundary pendingListScreen = new PendingListScreen();

    /**
     * After successful creation of a group, this page will display the newly created Group.
     * The User can then click on the 'Edit Group Information' button if they want to edit
     * the group's profile and add more details. Otherwise, they can click the 'Home Page'
     * button and go back to the home page.
     */
    public NewGroupPageScreen(String groupName) {

        this.groupName = groupName;

        groupNameText.setText("Group's name: " + groupName);

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

    /**
     * React to a button click that results in evt.
     */
    public void actionPerformed(ActionEvent evt) {

        System.out.println("Click " + evt.getActionCommand());
        if (evt.getSource() == homePage){
            try {
                // GO BACK TO HOMEPAGE

            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, e.getMessage());
            }
        }
        else if (evt.getSource() == editGroup){
            // CONNECT JULIA'S USE CASE
        }
        else if (evt.getSource() == pendingList){
            // CONNECT WITH PENDING LIST

//            SerializeDataAccess dataAccess = new SerializeDataAccess();
//            String username1 = "sharon";
//            User user1 = new NormalUser(username1, "test", "test", "test",
//                    new UserPublicProfile());
//            dataAccess.saveNewUser(new UserRegistrationDSRequestPackage(user1, user1.getUsername()));
//            user1.getApplicationsList().put(groupName, groupName);
//            dataAccess.updateUser(user1);
//
//            if (!dataAccess.groupIdentifierExists(groupName)) {System.out.println("hehe");};
//            Group group = dataAccess.getGroup(groupName);
//            group.addRequest(username1);
//            dataAccess.updateGroup(group);

            ViewPendingListDsGateway dsGateway = new SerializeDataAccess();
            ViewPendingListOutputBoundary presenter = new ViewPendingListPresenter(pendingListScreen);
            ViewPendingListInputBoundary viewPendingListInputBoundary = new ViewPendingListInteractor(
                    dsGateway, presenter);
            ViewPendingListController viewPendingListController = new ViewPendingListController(
                    viewPendingListInputBoundary);
            viewPendingListController.getUsernames(groupName);

            // This is me making a fake data access
//            String username = "sharon";
//            String username1 = "aarya";
//
//            User user = new NormalUser(username, "pw", "Sharon", "sharon@gmail.com",
//                    new UserPublicProfile());
//            User user1 = new NormalUser(username1, "pww", "Aarya", "aarya@gmail.com",
//                    new UserPublicProfile());
//            CurrentUser currentUser = CurrentUser.getInstance();
//            User testUser = new NormalUser("testUser", "testUser", "testUser", "testUser",
//                    new UserPublicProfile());
//            currentUser.setUser(testUser);
//
//            Group group = new NormalGroup(groupName);
//            group.addRequest(username);
//            group.addRequest(username1);
//
//            user.getApplicationsList().put(groupName, groupName);
//            user1.getApplicationsList().put(groupName, groupName);
//
//            HashMap<String, User> userMap = new HashMap<>();
//            userMap.put(username, user);
//            userMap.put(username1, user1);
//
//            HashMap<String, Group> groupMap = new HashMap<>();
//            groupMap.put(groupName, group);
        }
    }
}
