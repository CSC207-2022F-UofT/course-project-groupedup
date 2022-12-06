package cancel_application_use_case_tests;

import Entities.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import view_group_profile_screens.ViewGroupProfileController;
import view_group_profile_use_case.*;

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
    ViewGroupProfileErrorMessages errorMessages = new ViewGroupProfileErrorMessages();
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
        Assertions.assertEquals(errorMessages.getGroupDoesNotExist(), thrown.getMessage());
    }
}
