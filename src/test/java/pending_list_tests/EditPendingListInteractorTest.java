package pending_list_tests;

import Entities.*;
import edit_pending_list.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pending_list_screens.EditPendingListPresenter;
import pending_list_screens.PendingListDataAccess;

import java.util.HashMap;

public class EditPendingListInteractorTest {
    @Test
    public void addUser() {
        String username = "sharonh";
        String groupName = "csc207";
        User user = new NormalUser(username, "pw", "Sharon", "syt.hsieh@mail.utoronto.ca",
                new UserPublicProfile());

        // added this so Group entity doesn't cause an error when setting group leader
        CurrentUser currentUser = CurrentUser.getInstance();
        User testUser = new NormalUser("testUser", "testUser", "testUser", "testUser",
                new UserPublicProfile());
        currentUser.setUser(testUser);

        Group group = new NormalGroup(groupName);
        HashMap<String, User> userMap = new HashMap<>();
        userMap.put(username, user);
        HashMap<String, Group> groupMap = new HashMap<>();
        groupMap.put(groupName, group);
        EditPendingListDsGateway repository = new PendingListDataAccess(userMap, groupMap);

        // imitates ApplyToGroup use case, I'll use Ipek's methods when she merges them
        user.getApplicationsList().put(groupName, group);
        group.addRequest(username);

        EditPendingListOutputBoundary presenter = new EditPendingListPresenter() {
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
                Assertions.assertTrue(repository.groupInUser(responseGroupName, responseUsername));
                Assertions.assertTrue(repository.userInGroup(responseUsername, responseGroupName));
                Assertions.assertFalse(repository.groupInApplications(responseGroupName, responseUsername));
                Assertions.assertFalse(repository.userInMemberRequests(responseUsername, responseGroupName));
            }

            @Override
            public void prepareFailView(String error) {
                Assertions.fail("Use case failure is unexpected.");
            }
        };

        EditPendingListInputBoundary interactor = new EditPendingListInteractor(repository, presenter);
        EditPendingListRequestModel inputData = new EditPendingListRequestModel(username, groupName,
                true);
        interactor.addOrRemoveUser(inputData);
    }

    @Test
    public void removeUser() {
        String username = "sharonh";
        String groupName = "csc207";
        User user = new NormalUser(username, "pw", "Sharon", "syt.hsieh@mail.utoronto.ca",
                new UserPublicProfile());

        // added this so Group entity doesn't cause an error when setting group leader
        CurrentUser currentUser = CurrentUser.getInstance();
        User testUser = new NormalUser("testUser", "testUser", "testUser", "testUser",
                new UserPublicProfile());
        currentUser.setUser(testUser);

        Group group = new NormalGroup(groupName);
        HashMap<String, User> userMap = new HashMap<>();
        userMap.put(username, user);
        HashMap<String, Group> groupMap = new HashMap<>();
        groupMap.put(groupName, group);
        EditPendingListDsGateway repository = new PendingListDataAccess(userMap, groupMap);

        // imitates ApplyToGroup use case, I'll use Ipek's methods when she merges them
        user.getApplicationsList().put(groupName, group);
        group.addRequest(username);

        EditPendingListOutputBoundary presenter = new EditPendingListPresenter() {
            @Override
            public void prepareAcceptedView(EditPendingListResponseModel responseModel) {
                String responseGroupName = responseModel.getGroupName();
                String responseUsername = responseModel.getUsername();
                Assertions.assertFalse(repository.groupInUser(responseGroupName, responseUsername));
                Assertions.assertFalse(repository.userInGroup(responseUsername, responseGroupName));
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

        EditPendingListInputBoundary interactor = new EditPendingListInteractor(repository, presenter);
        EditPendingListRequestModel inputData = new EditPendingListRequestModel(username, groupName,
                false);
        interactor.addOrRemoveUser(inputData);
    }
}
