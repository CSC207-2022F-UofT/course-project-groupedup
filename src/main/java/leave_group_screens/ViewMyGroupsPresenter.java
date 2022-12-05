package leave_group_screens;

import Entities.*;
import leave_group_use_case.LeaveGroupDsGateway;
import leave_group_use_case.LeaveGroupInputBoundary;
import leave_group_use_case.LeaveGroupInteractor;
import leave_group_use_case.LeaveGroupOutputBoundary;
import view_group_profile_screens.GroupProfileScreen;
import view_group_profile_screens.GroupProfileScreenBoundary;
import view_group_profile_screens.ViewGroupProfileController;
import view_group_profile_screens.ViewGroupProfilePresenter;
import view_group_profile_use_case.ViewGroupProfileDsGateway;
import view_group_profile_use_case.ViewGroupProfileInputBoundary;
import view_group_profile_use_case.ViewGroupProfileInteractor;
import view_group_profile_use_case.ViewGroupProfileOutputBoundary;
import view_my_groups_use_case.ViewMyGroupsOutputBoundary;
import view_my_groups_use_case.ViewMyGroupsResponseModel;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;

public class ViewMyGroupsPresenter implements ViewMyGroupsOutputBoundary {
    private final MyGroupsScreenBoundary myGroupsScreen;

    /**
     * The presenter class for the view my groups use case.
     * @param screen the initial empty groups list screen
     */
    public ViewMyGroupsPresenter(MyGroupsScreenBoundary screen) {
        this.myGroupsScreen = screen;
    }

    @Override
    public void prepareSuccessView(ViewMyGroupsResponseModel groupAndStatus) {
        String username = groupAndStatus.getUsername();

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

        LeaveGroupDsGateway dsGateway = new LeaveGroupDataAccess(users, groups);
        LeaveGroupOutputBoundary presenter = new LeaveGroupPresenter();
        LeaveGroupInputBoundary inputBoundary = new LeaveGroupInteractor(dsGateway, presenter);
        LeaveGroupController controller = new LeaveGroupController(inputBoundary);

        ViewGroupProfileDsGateway dsGateway2 = new LeaveGroupDataAccess(users, groups);
        GroupProfileScreenBoundary groupProfileScreen = new GroupProfileScreen(username);
        ViewGroupProfileOutputBoundary presenter2 = new ViewGroupProfilePresenter(groupProfileScreen);
        ViewGroupProfileInputBoundary inputBoundary2 = new ViewGroupProfileInteractor(dsGateway2, presenter2);
        ViewGroupProfileController controller2 = new ViewGroupProfileController(inputBoundary2);

        DefaultListModel<String> myGroupsModel = new DefaultListModel<>();
        ArrayList<String> groupNames = new ArrayList<>(groupAndStatus.getGroupAndStatus().keySet());

        for (String groupName : groupNames) {
            myGroupsModel.addElement(groupName);
        }

        JList<String> myGroups = new JList<>(myGroupsModel);
        myGroups.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        myGroups.setSelectedIndex(0);
        myGroups.addListSelectionListener(myGroupsScreen);
        myGroups.setVisibleRowCount(5);

        myGroupsScreen.setMyGroups(myGroups);
        myGroupsScreen.setMyGroupsModel(myGroupsModel);
        myGroupsScreen.setLeaveGroupController(controller);
        myGroupsScreen.setViewGroupProfileController(controller2);
        myGroupsScreen.setGroupStatusMapping(groupAndStatus.getGroupAndStatus());
        myGroupsScreen.view();
    }
}
