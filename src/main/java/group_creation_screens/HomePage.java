package group_creation_screens;
import Entities.*;
import cancel_application_screens.*;
import cancel_application_screens.ViewApplicationsListController;
import cancel_application_screens.ViewApplicationsListPresenter;
import leave_group_screens.*;
import view_my_groups_use_case.ViewMyGroupsDsGateway;
import view_my_groups_use_case.ViewMyGroupsInputBoundary;
import view_my_groups_use_case.ViewMyGroupsInteractor;
import view_my_groups_use_case.ViewMyGroupsOutputBoundary;
import view_user_applications_use_case.ViewApplicationsListDsGateway;
import view_user_applications_use_case.ViewApplicationsListInputBoundary;
import view_user_applications_use_case.ViewApplicationsListInteractor;
import view_user_applications_use_case.ViewApplicationsListOutputBoundary;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

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
    ApplicationsListScreenBoundary applicationListScreen;
    MyGroupsScreenBoundary myGroupsScreen;
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

        this.applicationListScreen = new ApplicationsListScreen(username);
        this.myGroupsScreen = new MyGroupsScreen(username);
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
            // This is me making a fake data access for testing
            User testUser = new NormalUser("Bob", "testUser", "testUser", "testUser",
                    new UserPublicProfile());

            CurrentUser currentUser = CurrentUser.getInstance();
            currentUser.setUser(testUser);
            Group group = new NormalGroup("Bob's group");
            Group group2 = new NormalGroup("Paul's Fan Club");
            Group group3 = new NormalGroup("Group 47");

            group.getProfile().setDescription("bobby's club.");

            group2.getProfile().setCourseCode("CSC207");
            group2.getProfile().setDescription("Hi guys. My name is Paul Gries and I am 52 years old and I have" +
                    " brown hair and blue eyes. I made this group because I think it would be nice to get together" +
                    " with abstract people and talk about things in the abstract sense. BTW i love art, especially" +
                    " drawing arrows :)");
            HashMap<String, String> preferences = new HashMap<>();
            preferences.put("Time Commitment", "8 hrs/week");
            preferences.put("Location", "Brennan Hall");
            preferences.put("Meeting Time", "2-3pm");
            group2.getProfile().setPreferences(preferences);

            HashMap<String, String> preferences2 = new HashMap<>();
            preferences2.put("Time Commitment", "as long as u get it done on time..");
            preferences2.put("Location", "Paul's house");
            preferences2.put("Meeting Time", "2am - 4am");
            group3.getProfile().setPreferences(preferences2);

            User user = new NormalUser("test", "test", "test", "test", new UserPublicProfile());
            user.getApplicationsList().put("Bob's group", "Bob's group");
            user.getApplicationsList().put("Paul's Fan Club", "Paul's Fan Club");
            user.getApplicationsList().put("Group 47", "Group 47");

            group.addRequest(user.getUsername());
            group2.addRequest(user.getUsername());
            group3.addRequest(user.getUsername());

            HashMap<String, User> users = new HashMap<>();
            users.put(testUser.getUsername(), testUser);
            users.put(user.getUsername(), user);

            HashMap<String, Group> groups = new HashMap<>();
            groups.put("Bob's group", group);
            groups.put("Paul's Fan Club", group2);
            groups.put("Group 47", group3);

            ViewApplicationsListDsGateway dsGateway = new CancelApplicationDataAccess(users, groups);

            ViewApplicationsListOutputBoundary presenter = new ViewApplicationsListPresenter(applicationListScreen);
            ViewApplicationsListInputBoundary inputBoundary = new ViewApplicationsListInteractor(dsGateway, presenter);
            ViewApplicationsListController controller = new ViewApplicationsListController(inputBoundary);
            controller.viewApplicationsList(username);
        } else if (evt.getSource() == myGroups) {
            // another fake data access for testing
            User testUser = new NormalUser("Bob", "testUser", "testUser", "testUser",
                    new UserPublicProfile());

            CurrentUser currentUser = CurrentUser.getInstance();
            currentUser.setUser(testUser);

            Group group = new NormalGroup("Bob's group");
            Group group2 = new NormalGroup("Paul's Fan Club");

            User user = new NormalUser(username, "test", "test", "test", new UserPublicProfile());
            currentUser.setUser(user);
            Group group3 = new NormalGroup("Group 47");
            user.getGroups().put("Bob's group", "Bob's group");
            user.getGroups().put("Paul's Fan Club", "Paul's Fan Club");

            group.getProfile().setDescription("bobby's club.");
            group2.getProfile().setCourseCode("CSC207");
            group2.getProfile().setDescription("Hi guys. My name is Paul Gries and I am 52 years old and I have" +
                    " brown hair and blue eyes. I made this group because I think it would be nice to get together" +
                    " with abstract people and talk about things in the abstract sense. BTW i love art, especially" +
                    " drawing arrows :)");
            HashMap<String, String> preferences = new HashMap<>();
            preferences.put("Time Commitment", "8 hrs/week");
            preferences.put("Location", "Brennan Hall");
            preferences.put("Meeting Time", "2-3pm");
            group2.getProfile().setPreferences(preferences);

            HashMap<String, String> preferences2 = new HashMap<>();
            preferences2.put("Time Commitment", "as long as u get it done on time..");
            preferences2.put("Location", "Paul's house");
            preferences2.put("Meeting Time", "2am - 4am");
            group3.getProfile().setPreferences(preferences2);

            group.addMember(user.getUsername());
            group2.addMember(user.getUsername());
            group3.addMember(user.getUsername());

            HashMap<String, User> users = new HashMap<>();
            users.put(testUser.getUsername(), testUser);
            users.put(user.getUsername(), user);

            HashMap<String, Group> groups = new HashMap<>();
            groups.put("Bob's group", group);
            groups.put("Paul's Fan Club", group2);
            groups.put("Group 47", group3);

            ViewMyGroupsDsGateway dsGateway = new LeaveGroupDataAccess(users, groups);

            ViewMyGroupsOutputBoundary presenter = new ViewMyGroupsPresenter(myGroupsScreen);
            ViewMyGroupsInputBoundary inputBoundary = new ViewMyGroupsInteractor(dsGateway, presenter);
            ViewMyGroupsController controller = new ViewMyGroupsController(inputBoundary);
            controller.viewMyGroups(username);
        }
    }
}
