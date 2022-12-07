package cancel_application_tests;

import use_cases.view_group_profile_use_case.*;
import entities.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import interface_adapters.view_group_profile_adapters.ViewGroupProfileController;

import java.util.HashMap;

/**
 * Tests for view group profile use case
 */
public class ViewGroupProfileTest {
    String username;
    User user;
    CurrentUser currentUser;
    Group testGroup;
    HashMap<String, User> userMap;
    HashMap<String, Group> groupMap;
    CancelApplicationDataAccess repository;
    ViewGroupProfileController controller;
    ViewGroupProfileInputBoundary interactor;
    ViewGroupProfileOutputBoundary presenter;
    String groupName;

    @BeforeEach
    void beforeEach() {
        username = "aarya";
        user = new NormalUser(username, "pw", "aarya", "aarya@mail.utoronto.ca",
                new UserPublicProfile());
        currentUser = CurrentUser.getInstance();
        currentUser.setUser(user);

        groupName = "testGroup";
        testGroup = new NormalGroup(groupName);

        userMap = new HashMap<>();
        userMap.put(username, user);

        groupMap = new HashMap<>();
        groupMap.put(testGroup.getGroupName(), testGroup);

        repository = new CancelApplicationDataAccess(userMap, groupMap);
    }

    @Test
    public void testGroupProfileSuccess() {

        ViewGroupProfileOutputBoundary presenter = new ViewGroupProfileOutputBoundary() {
            @Override
            public void prepareSuccessView(ViewGroupProfileResponseModel groupInfo) {
                Assertions.assertEquals(groupInfo.getGroupName(), groupInfo.getGroupName());
            }
        };

        interactor = new ViewGroupProfileInteractor(repository, presenter);
        controller = new ViewGroupProfileController(interactor);
        controller.viewGroup(groupName);
    }

    @Test
    public void testGroupDoesNotExist() {
        groupMap = new HashMap<>();
        repository = new CancelApplicationDataAccess(userMap, groupMap);
        interactor = new ViewGroupProfileInteractor(repository, presenter);
        RuntimeException thrown = Assertions.assertThrows(RuntimeException.class, () -> {
            controller = new ViewGroupProfileController(interactor);
            controller.viewGroup(groupName);
        });
        Assertions.assertEquals(InteractorMessages.GROUP_DOES_NOT_EXIST, thrown.getMessage());
    }
}
