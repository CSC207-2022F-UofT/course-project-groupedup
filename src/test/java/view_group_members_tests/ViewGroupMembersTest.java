package view_group_members_tests;

import entities.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import interface_adapters.pending_list_adapters.ViewGroupMembersController;
import pending_list_tests.PendingListDataAccess;
import use_cases.view_group_members_use_case.*;

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
    }

    @Test
    public void testMembersListRetrieval() {
        ArrayList<String> members = new ArrayList<>(group.getGroupMembers(userMap).keySet());
        ViewGroupMembersOutputBoundary presenter = new ViewGroupMembersOutputBoundary() {
            @Override
            public void prepareSuccessView(ViewGroupMembersResponseModel groupMembers) {
                Assertions.assertEquals(groupMembers.getGroupMembers(), members);
            }
        };
        interactor = new ViewGroupMembersInteractor(repository, presenter);
        controller = new ViewGroupMembersController(interactor);
        controller.getGroupMembers(groupName);
    }

    @Test
    public void testGroupDoesntExist() {
        groupMap = new HashMap<>();
        repository = new PendingListDataAccess(userMap, groupMap);
        interactor = new ViewGroupMembersInteractor(repository, presenter);
        RuntimeException thrown = Assertions.assertThrows(RuntimeException.class, () -> {
            controller = new ViewGroupMembersController(interactor);
            controller.getGroupMembers(groupName);
        });
        Assertions.assertEquals("This group doesn't exist.", thrown.getMessage());
    }

}
