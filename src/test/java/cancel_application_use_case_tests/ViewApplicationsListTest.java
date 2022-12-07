package cancel_application_use_case_tests;


import entities.*;
import controllers_presenters_and_screen_boundaries.cancel_application_adapters.ViewApplicationsListController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import use_cases.view_user_applications_use_case.ViewApplicationsListInputBoundary;
import use_cases.view_user_applications_use_case.ViewApplicationsListInteractor;
import use_cases.view_user_applications_use_case.ViewApplicationsListOutputBoundary;
import use_cases.view_user_applications_use_case.ViewApplicationsListResponseModel;
import use_cases.view_user_applications_use_case.ViewApplicationsListErrorMessages;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Tests for view applications list use case
 */
public class ViewApplicationsListTest {
    String username;
    User user;
    User testUser;
    CurrentUser currentUser;
    Group testGroup;
    Group testGroup2;
    HashMap<String, User> userMap;
    HashMap<String, Group> groupMap;
    CancelApplicationDataAccess repository;
    ViewApplicationsListController controller;
    ViewApplicationsListInputBoundary interactor;
    ViewApplicationsListOutputBoundary presenter;
    ViewApplicationsListErrorMessages errorMessages = new ViewApplicationsListErrorMessages();

    @BeforeEach
    void beforeEach() {
        username = "aarya";
        user = new NormalUser(username, "pw", "aarya", "aarya@mail.utoronto.ca",
                new UserPublicProfile());

        testUser = new NormalUser("testUser", "testUser", "testUser", "testUser",
                new UserPublicProfile());
        currentUser = CurrentUser.getInstance();
        currentUser.setUser(testUser);

        testGroup = new NormalGroup("testGroup");
        testGroup2 = new NormalGroup("testGroup2");
        user.getApplicationsList().put(testGroup.getGroupName(), testGroup.getGroupName());
        user.getApplicationsList().put(testGroup2.getGroupName(), testGroup2.getGroupName());
        testGroup.addRequest(username);
        testGroup2.addRequest(username);

        userMap = new HashMap<>();
        userMap.put(username, user);
        userMap.put(testUser.getUsername(), testUser);

        groupMap = new HashMap<>();
        groupMap.put(testGroup.getGroupName(), testGroup);
        groupMap.put(testGroup2.getGroupName(), testGroup2);

        repository = new CancelApplicationDataAccess(userMap, groupMap);
    }

    @Test
    public void testApplicationsListRetrieval() {
        ArrayList<String> applications = new ArrayList<>();
        applications.add(testGroup2.getGroupName());
        applications.add(testGroup.getGroupName());

        ViewApplicationsListOutputBoundary presenter = new ViewApplicationsListOutputBoundary() {
            @Override
            public void prepareSuccessView(ViewApplicationsListResponseModel responseModel) {
                Assertions.assertEquals(responseModel.getApplicationsList(), applications);
            }
        };

        interactor = new ViewApplicationsListInteractor(repository, presenter);
        controller = new ViewApplicationsListController(interactor);
        controller.viewApplicationsList(username);
    }

    @Test
    public void testUserDoesNotExist() {
        userMap = new HashMap<>();
        repository = new CancelApplicationDataAccess(userMap, groupMap);
        interactor = new ViewApplicationsListInteractor(repository, presenter);
        RuntimeException thrown = Assertions.assertThrows(RuntimeException.class, () -> {
            controller = new ViewApplicationsListController(interactor);
            controller.viewApplicationsList(username);
        });
        Assertions.assertEquals(errorMessages.getUserDoesNotExist(), thrown.getMessage());
    }
}
