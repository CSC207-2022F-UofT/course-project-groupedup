package pending_list_tests;

import controllers_presenters_and_screen_boundaries.pending_list_adapters.ViewPendingListController;
import use_cases.view_pending_list_use_case.*;
import entities.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import view_pending_list_use_case.*;

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
    }

    @Test
    public void testPendingListRetrieval() {
        ArrayList<String> requests = new ArrayList<>();
        requests.add(username);
        ViewPendingListOutputBoundary presenter = new ViewPendingListOutputBoundary() {
            @Override
            public void prepareSuccessView(ViewPendingListResponseModel usernamesList) {
                Assertions.assertEquals(usernamesList.getUsernamesList(), requests);
            }
        };
//        ViewPendingListOutputBoundary presenter = new ViewPendingListPresenter(screen) {
//            @Override
//            public void prepareSuccessView(ViewPendingListResponseModel usernamesList) {
//                Assertions.assertEquals(usernamesList.getUsernamesList(), requests);
//            }
//        };
        interactor = new ViewPendingListInteractor(repository, presenter);
        controller = new ViewPendingListController(interactor);
        controller.getUsernames(groupName);
    }

    @Test
    public void testGroupDoesntExist() {
        groupMap = new HashMap<>();
        repository = new PendingListDataAccess(userMap, groupMap);
        interactor = new ViewPendingListInteractor(repository, presenter);
        RuntimeException thrown = Assertions.assertThrows(RuntimeException.class, () -> {
            controller = new ViewPendingListController(interactor);
            controller.getUsernames(groupName);
        });
        Assertions.assertEquals("This group doesn't exist.", thrown.getMessage());
    }
}
