package pending_list_tests;

import Entities.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pending_list_screens.*;
import view_pending_list.*;

import java.util.HashMap;

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

        screen = new PendingListScreen(groupName);
    }

    @Test
    public void test() {
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

        ViewPendingListOutputBoundary presenter = new ViewPendingListPresenter(screen) {
            @Override
            public void prepareSuccessView(ViewPendingListResponseModel usernamesList) {

            }
        };
    }
}
