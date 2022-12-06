package leave_group_use_case_tests;

import use_cases.view_my_groups_use_case.*;
import entities.*;
import controllers_presenters_and_screen_boundaries.leave_and_view_my_groups_adapters.ViewMyGroupsController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import view_my_groups_use_case.*;

import java.util.HashMap;

/**
 * Tests for view my groups list use case
 */
public class ViewMyGroupsTest {
    String username;
    User user;
    User testUser;
    CurrentUser currentUser;
    Group testGroup;
    Group testGroup2;
    Group testGroup3;
    HashMap<String, User> userMap;
    HashMap<String, Group> groupMap;
    LeaveGroupDataAccess repository;
    ViewMyGroupsInputBoundary interactor;
    ViewMyGroupsOutputBoundary presenter;
    ViewMyGroupsController controller;
    ViewMyGroupsErrorMessages errorMessages = new ViewMyGroupsErrorMessages();

    @BeforeEach
    void beforeEach() {
        username = "aarya";
        user = new NormalUser(username, "pw", "aarya", "aarya@mail.utoronto.ca",
                new UserPublicProfile());
        currentUser = CurrentUser.getInstance();
        currentUser.setUser(user);
        testGroup3 = new NormalGroup("testGroup3");

        testUser = new NormalUser("testUser", "testUser", "testUser", "testUser",
                new UserPublicProfile());
        currentUser = CurrentUser.getInstance();
        currentUser.setUser(testUser);

        testGroup = new NormalGroup("testGroup");
        testGroup2 = new NormalGroup("testGroup2");
        user.getGroups().put(testGroup.getGroupName(), testGroup.getGroupName());
        user.getGroups().put(testGroup2.getGroupName(), testGroup2.getGroupName());
        testGroup.addMember(username);
        testGroup2.addMember(username);

        userMap = new HashMap<>();
        userMap.put(username, user);
        userMap.put(testUser.getUsername(), testUser);

        groupMap = new HashMap<>();
        groupMap.put(testGroup.getGroupName(), testGroup);
        groupMap.put(testGroup2.getGroupName(), testGroup2);
        groupMap.put(testGroup3.getGroupName(), testGroup3);

        repository = new LeaveGroupDataAccess(userMap, groupMap);
    }

    @Test
    public void testMyGroupsRetrieval() {
        HashMap<String, Boolean>  groups = new HashMap<>();
        groups.put(testGroup3.getGroupName(), true);
        groups.put(testGroup.getGroupName(), false);
        groups.put(testGroup2.getGroupName(), false);

        ViewMyGroupsOutputBoundary presenter = new ViewMyGroupsOutputBoundary() {
            @Override
            public void prepareSuccessView(ViewMyGroupsResponseModel groupAndStatus) {
                Assertions.assertEquals(groupAndStatus.getGroupAndStatus(), groups);
            }
        };
        interactor = new ViewMyGroupsInteractor(repository, presenter);
        controller = new ViewMyGroupsController(interactor);
        controller.viewMyGroups(username);
    }

    @Test
    public void testUserDoesNotExist() {
        userMap = new HashMap<>();
        repository = new LeaveGroupDataAccess(userMap, groupMap);
        interactor = new ViewMyGroupsInteractor(repository, presenter);
        RuntimeException thrown = Assertions.assertThrows(RuntimeException.class, () -> {
            controller = new ViewMyGroupsController(interactor);
            controller.viewMyGroups(username);
        });
        Assertions.assertEquals(errorMessages.getUserDoesNotExist(), thrown.getMessage());
    }
}
