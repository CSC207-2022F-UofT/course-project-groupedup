package cancel_application_screens;

import Entities.*;
import cancel_application_use_case.CancelApplicationDsGateway;
import cancel_application_use_case.CancelApplicationInputBoundary;
import cancel_application_use_case.CancelApplicationInteractor;
import cancel_application_use_case.CancelApplicationOutputBoundary;
import view_group_profile_use_case.ViewGroupProfileDsGateway;
import view_group_profile_use_case.ViewGroupProfileInputBoundary;
import view_group_profile_use_case.ViewGroupProfileInteractor;
import view_group_profile_use_case.ViewGroupProfileOutputBoundary;
import view_user_applications_use_case.*;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;

public class ViewApplicationsListPresenter implements ViewApplicationsListOutputBoundary {
    private final ApplicationsListScreenBoundary applicationListScreen;

    /**
     * The presenter class for the view applications list use case.
     * @param screen the initial empty applications list screen
     */
    public ViewApplicationsListPresenter(ApplicationsListScreenBoundary screen) {
        this.applicationListScreen = screen;
    }

    @Override
    public void prepareSuccessView(ViewApplicationsListResponseModel responseModel) {
        String username = responseModel.getUsername();

        // another fake data access for testing
        User testUser = new NormalUser("Bob", "testUser", "testUser", "testUser",
                new UserPublicProfile());

        CurrentUser currentUser = CurrentUser.getInstance();
        currentUser.setUser(testUser);

        Group group = new NormalGroup("Bob's group");
        Group group2 = new NormalGroup("Paul's Fan Club");
        Group group3 = new NormalGroup("Group 47");

        User user = new NormalUser(username, "test", "test", "test", new UserPublicProfile());
        user.getApplicationsList().put("Bob's group", "Bob's group");
        user.getApplicationsList().put("Paul's Fan Club", "Paul's Fan Club");
        user.getApplicationsList().put("Group 47", "Group 47");

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

        CancelApplicationDsGateway dsGateway = new CancelApplicationDataAccess(users, groups);
        CancelApplicationOutputBoundary presenter = new CancelApplicationPresenter();
        CancelApplicationInputBoundary inputBoundary = new CancelApplicationInteractor(dsGateway, presenter);
        CancelApplicationController controller = new CancelApplicationController(inputBoundary);

        ViewGroupProfileDsGateway dsGateway2 = new CancelApplicationDataAccess(users, groups);
        GroupProfileScreenBoundary groupProfileScreen = new GroupProfileScreen(username);
        ViewGroupProfileOutputBoundary presenter2 = new ViewGroupProfilePresenter(groupProfileScreen);
        ViewGroupProfileInputBoundary inputBoundary2 = new ViewGroupProfileInteractor(dsGateway2, presenter2);
        ViewGroupProfileController controller2 = new ViewGroupProfileController(inputBoundary2);

        DefaultListModel<String> userApplicationsModel = new DefaultListModel<>();
        ArrayList<String> groupNames = responseModel.getApplicationsList();

        for (String groupName : groupNames) {
            userApplicationsModel.addElement(groupName);
        }

        JList<String> userApplications = new JList<>(userApplicationsModel);
        userApplications.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        userApplications.setSelectedIndex(0);
        userApplications.addListSelectionListener(applicationListScreen);
        userApplications.setVisibleRowCount(5);

        applicationListScreen.setUserApplications(userApplications);
        applicationListScreen.setUserApplicationsModel(userApplicationsModel);
        applicationListScreen.setCancelApplicationController(controller);
        applicationListScreen.setViewGroupController(controller2);
        applicationListScreen.view();
    }
}
