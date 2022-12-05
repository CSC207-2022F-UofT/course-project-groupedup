package pending_list_tests;

import Entities.*;
import edit_pending_list.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pending_list_screens.EditPendingListController;
import pending_list_screens.EditPendingListPresenter;

import java.util.HashMap;

/**
 * Tests for the edit pending list use case
 */
public class EditPendingListTest {

    String username;
    String groupName;
    User user;
    Group group;
    CurrentUser currentUser;
    User testUser;
    HashMap<String, User> userMap;
    HashMap<String, Group> groupMap;
    EditPendingListDsGateway repository;
    EditPendingListInputBoundary interactor;
    EditPendingListOutputBoundary presenter;
    EditPendingListController controller;

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
    public void testAddUser() {
        presenter = new EditPendingListPresenter() {
            @Override
            public void prepareAcceptedView(EditPendingListResponseModel responseModel) {
                String responseGroupName = responseModel.getGroupName();
                String responseUsername = responseModel.getUsername();
                Assertions.assertTrue(repository.groupInUser(responseGroupName, responseUsername));
                Assertions.assertTrue(repository.userInGroup(responseUsername, responseGroupName));
                Assertions.assertFalse(repository.groupInApplications(responseGroupName, responseUsername));
                Assertions.assertFalse(repository.userInMemberRequests(responseUsername, responseGroupName));
                Assertions.assertEquals(responseModel.getUsername(), username);
                Assertions.assertEquals(responseModel.getGroupName(), groupName);
            }

            @Override
            public void prepareRejectedView(EditPendingListResponseModel responseModel) {
                Assertions.fail("User rejection is unexpected.");
            }

            @Override
            public void prepareFailView(String error) {
                Assertions.fail("Use case failure is unexpected.");
            }
        };
        interactor = new EditPendingListInteractor(repository, presenter);
        controller = new EditPendingListController(interactor);
        controller.rejectOrAcceptUser(username, groupName, true);
    }

    @Test
    public void testRemoveUser() {
        presenter = new EditPendingListPresenter() {
            @Override
            public void prepareAcceptedView(EditPendingListResponseModel responseModel) {
                Assertions.fail("User acceptance is unexpected.");
            }

            @Override
            public void prepareRejectedView(EditPendingListResponseModel responseModel) {
                String responseGroupName = responseModel.getGroupName();
                String responseUsername = responseModel.getUsername();
                Assertions.assertFalse(repository.groupInUser(responseGroupName, responseUsername));
                Assertions.assertFalse(repository.userInGroup(responseUsername, responseGroupName));
                Assertions.assertFalse(repository.groupInApplications(responseGroupName, responseUsername));
                Assertions.assertFalse(repository.userInMemberRequests(responseUsername, responseGroupName));
                Assertions.assertEquals(responseModel.getUsername(), username);
                Assertions.assertEquals(responseModel.getGroupName(), groupName);
            }

            @Override
            public void prepareFailView(String error) {
                Assertions.fail("Use case failure is unexpected.");
            }
        };
        interactor = new EditPendingListInteractor(repository, presenter);
        controller = new EditPendingListController(interactor);
        controller.rejectOrAcceptUser(username, groupName, false);
    }

    @Test
    public void testUserDoesntExist() {
        presenter = new EditPendingListPresenter() {
            @Override
            public void prepareAcceptedView(EditPendingListResponseModel responseModel) {
                Assertions.fail("User acceptance is unexpected.");
            }

            @Override
            public void prepareRejectedView(EditPendingListResponseModel responseModel) {
                Assertions.fail("User rejection is unexpected.");
            }

            @Override
            public void prepareFailView(String error) {
                Assertions.assertEquals(error, "This user no longer exists.");
            }
        };
        username = "null";
        interactor = new EditPendingListInteractor(repository, presenter);
        controller = new EditPendingListController(interactor);
        controller.rejectOrAcceptUser(username, groupName, true);
    }

    @Test
    public void testUserNotInRequests() {
        presenter = new EditPendingListPresenter() {
            @Override
            public void prepareAcceptedView(EditPendingListResponseModel responseModel) {
                Assertions.fail("User acceptance is unexpected.");
            }

            @Override
            public void prepareRejectedView(EditPendingListResponseModel responseModel) {
                Assertions.fail("User rejection is unexpected.");
            }

            @Override
            public void prepareFailView(String error) {
                Assertions.assertEquals(error, "This user has cancelled their join request.");
            }
        };
        group.removeFromRequests(username);
        interactor = new EditPendingListInteractor(repository, presenter);
        controller = new EditPendingListController(interactor);
        controller.rejectOrAcceptUser(username, groupName, true);
    }

    @Test
    public void testGroupDoesntExist() {
        groupMap = new HashMap<>();
        repository = new PendingListDataAccess(userMap, groupMap);
        interactor = new EditPendingListInteractor(repository, presenter);
        RuntimeException thrown = Assertions.assertThrows(RuntimeException.class, () -> {
            controller = new EditPendingListController(interactor);
            controller.rejectOrAcceptUser(username, groupName, true);
        });
        Assertions.assertEquals("This group doesn't exist.", thrown.getMessage());
    }

    @Test
    public void testGroupNotInApplications() {
        user.getApplicationsList().remove(groupName);
        repository.updateUser(user);
        interactor = new EditPendingListInteractor(repository, presenter);
        RuntimeException thrown = Assertions.assertThrows(RuntimeException.class, () -> {
            controller = new EditPendingListController(interactor);
            controller.rejectOrAcceptUser(username, groupName, true);
        });
        Assertions.assertEquals("This group is not in this user's application list.", thrown.getMessage());
    }

    @Test
    public void testGroupInUserOrUserInGroup() {
        user.addGroup(groupName);
        group.addMember(username);
        repository.updateUser(user);
        repository.updateGroup(group);
        interactor = new EditPendingListInteractor(repository, presenter);
        RuntimeException thrown = Assertions.assertThrows(RuntimeException.class, () -> {
            controller = new EditPendingListController(interactor);
            controller.rejectOrAcceptUser(username, groupName, true);
        });
        Assertions.assertEquals("This user is already in this group.", thrown.getMessage());
    }
}
