package pending_list_tests;

import Entities.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pending_list_screens.*;
import view_pending_list.*;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Tests for the view pending list use case
 */

public class ViewPendingListTest {
    String username;
    String groupName;
    User user;
    Group group;
    CurrentUser currentUser;
    User testUser;
    HashMap<String, User> userMap;
    HashMap<String, Group> groupMap;
    ViewPendingListDsGateway repository;
    ViewPendingListInputBoundary interactor;
    ViewPendingListOutputBoundary presenter;
    ViewPendingListController controller;
    PendingListScreenBoundary screen;

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
        user.getApplicationsList().put(groupName, groupName);
        group.addRequest(username);
        repository = new PendingListDataAccess(userMap, groupMap);

        screen = new PendingListScreen();
    }

    @Test
    public void testPendingListRetrieval() {
        ArrayList<String> requests = new ArrayList<>();
        requests.add(username);
        ViewPendingListOutputBoundary presenter = new ViewPendingListPresenter(screen) {
            @Override
            public void prepareSuccessView(ViewPendingListResponseModel usernamesList) {
                Assertions.assertEquals(usernamesList.getUsernamesList(), requests);
            }
        };
        interactor = new ViewPendingListInteractor(repository, presenter);
        controller = new ViewPendingListController(interactor);
        screen.setViewPendingListController(controller);
        controller.getUsernames(groupName);
    }

    @Test
    public void testGroupDoesntExist() {
        groupMap = new HashMap<>();
        repository = new PendingListDataAccess(userMap, groupMap);
        interactor = new ViewPendingListInteractor(repository, presenter);
        RuntimeException thrown = Assertions.assertThrows(RuntimeException.class, () -> {
            controller = new ViewPendingListController(interactor);
            screen.setViewPendingListController(controller);
            controller.getUsernames(groupName);
        });
        Assertions.assertEquals("This group doesn't exist.", thrown.getMessage());
    }
}
