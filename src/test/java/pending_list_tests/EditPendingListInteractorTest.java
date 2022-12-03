package pending_list_tests;

import Entities.*;
import edit_pending_list.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pending_list_screens.EditPendingListPresenter;
import pending_list_screens.PendingListDataAccess;

import java.util.HashMap;

/**
 * Tests for the edit pending list use case
 */
public class EditPendingListInteractorTest {
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

        presenter = new EditPendingListPresenter() {
            @Override
            public void prepareAcceptedView(EditPendingListResponseModel responseModel) {
                String responseGroupName = responseModel.getGroupName();
                String responseUsername = responseModel.getUsername();
                Assertions.assertTrue(repository.groupInUser(responseGroupName, responseUsername));
                Assertions.assertTrue(repository.userInGroup(responseUsername, responseGroupName));
                Assertions.assertFalse(repository.groupInApplications(responseGroupName, responseUsername));
                Assertions.assertFalse(repository.userInMemberRequests(responseUsername, responseGroupName));
            }

            public void prepareRejectedView(EditPendingListResponseModel responseModel) {
                String responseGroupName = responseModel.getGroupName();
                String responseUsername = responseModel.getUsername();
                Assertions.assertFalse(repository.groupInUser(responseGroupName, responseUsername));
                Assertions.assertFalse(repository.userInGroup(responseUsername, responseGroupName));
                Assertions.assertFalse(repository.groupInApplications(responseGroupName, responseUsername));
                Assertions.assertFalse(repository.userInMemberRequests(responseUsername, responseGroupName));
            }

            @Override
            public void prepareFailView(String error) {
                Assertions.fail("Use case failure is unexpected.");
            }
        };
    }

    @Test
    public void testAddUser() {
        interactor = new EditPendingListInteractor(repository, presenter);
        EditPendingListRequestModel inputData = new EditPendingListRequestModel(username, groupName,
                true);
        interactor.addOrRemoveUser(inputData);
    }

    @Test
    public void testRemoveUser() {
        interactor = new EditPendingListInteractor(repository, presenter);
        EditPendingListRequestModel inputData = new EditPendingListRequestModel(username, groupName,
                false);
        interactor.addOrRemoveUser(inputData);
    }

    @Test
    public void testUserDoesntExist() {

    }

    @Test
    public void testGroupDoesntExist() {
        groupMap = new HashMap<>();
        repository = new PendingListDataAccess(userMap, groupMap);
        interactor = new EditPendingListInteractor(repository, presenter);
        RuntimeException thrown = Assertions.assertThrows(RuntimeException.class, () -> {
            EditPendingListRequestModel inputData = new EditPendingListRequestModel(username, groupName,
                    false);
            interactor.addOrRemoveUser(inputData);
        });
        Assertions.assertEquals("This group doesn't exist.", thrown.getMessage());
    }

    @Test
    public void testUserNotInRequests() {

    }

    @Test
    public void testGroupNotInApplications() {
        user.getApplicationsList().remove(groupName);
        repository.updateUser(user);
        interactor = new EditPendingListInteractor(repository, presenter);
        RuntimeException thrown = Assertions.assertThrows(RuntimeException.class, () -> {
            EditPendingListRequestModel inputData = new EditPendingListRequestModel(username, groupName,
                    false);
            interactor.addOrRemoveUser(inputData);
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
            EditPendingListRequestModel inputData = new EditPendingListRequestModel(username, groupName,
                    false);
            interactor.addOrRemoveUser(inputData);
        });
        Assertions.assertEquals("This user is already in this group.", thrown.getMessage());
    }
}
