package pending_list_tests;

import Entities.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pending_list_screens.GroupMembersScreen;
import pending_list_screens.GroupMembersScreenBoundary;
import pending_list_screens.ViewGroupMembersController;
import pending_list_screens.ViewGroupMembersPresenter;
import view_group_members.*;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Tests for the view group members use case
 */

public class ViewGroupMembersTest {
    String username;
    String groupName;
    User user;
    Group group;
    CurrentUser currentUser;
    User testUser;
    HashMap<String, User> userMap;
    HashMap<String, Group> groupMap;
    ViewGroupMembersDsGateway repository;
    ViewGroupMembersInputBoundary interactor;
    ViewGroupMembersOutputBoundary presenter;
    ViewGroupMembersController controller;
    GroupMembersScreenBoundary screen;

    @BeforeEach
    void beforeEach() {
        username = "sharonh";
        groupName = "csc207";
        user = new NormalUser(username, "pw", "Sharon", "syt.hsieh@mail.utoronto.ca",
                new UserPublicProfile());
        testUser = new NormalUser("testUser", "testUser", "testUser", "testUser",
                new UserPublicProfile());
        currentUser = CurrentUser.getInstance();
        currentUser.setUser(testUser);
        group = new NormalGroup(groupName);
        userMap = new HashMap<>();
        userMap.put(username, user);
        groupMap = new HashMap<>();
        groupMap.put(groupName, group);
        user.addGroup(groupName);
        group.addMember(username);
        repository = new PendingListDataAccess(userMap, groupMap);

        screen = new GroupMembersScreen();
    }

    @Test
    public void testMembersListRetrieval() {
        ArrayList<String> members = new ArrayList<>(group.getGroupMembers(userMap).keySet());
        ViewGroupMembersOutputBoundary presenter = new ViewGroupMembersPresenter(screen) {
            @Override
            public void prepareSuccessView(ViewGroupMembersResponseModel usernamesList) {
                Assertions.assertEquals(usernamesList.getGroupMembers(), members);
            }
        };
        ViewGroupMembersRequestModel requestModel = new ViewGroupMembersRequestModel(groupName);
        interactor = new ViewGroupMembersInteractor(repository, presenter);
        interactor.getGroupMembers(requestModel);
//        controller = new ViewGroupMembersController(interactor);
//        controller.getGroupMembers(groupName);
    }

    @Test
    public void testGroupDoesntExist() {
        groupMap = new HashMap<>();
        repository = new PendingListDataAccess(userMap, groupMap);
        ViewGroupMembersRequestModel requestModel = new ViewGroupMembersRequestModel(groupName);
        interactor = new ViewGroupMembersInteractor(repository, presenter);
        RuntimeException thrown = Assertions.assertThrows(RuntimeException.class, () -> {
            interactor.getGroupMembers(requestModel);
//            controller = new ViewGroupMembersController(interactor);
//            controller.getGroupMembers(groupName);
        });
        Assertions.assertEquals("This group doesn't exist.", thrown.getMessage());
    }

}