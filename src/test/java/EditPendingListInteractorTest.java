import Entities.*;
import edit_pending_list.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pending_list_screens.PendingListDataAccess;

public class EditPendingListInteractorTest {
    @Test
    public void addOrRemoveUser() {
        String username = "sharonh";
        String groupName = "csc207";
        User user = new NormalUser(username, "pw", "Sharon", "syt.hsieh@mail.utoronto.ca",
                new UserPublicProfile());

        // added this so Group entity doesn't cause an error when setting group leader
        CurrentUser currentUser1 = CurrentUser.getInstance();
        UserPublicProfile testProfile = new UserPublicProfile();
        User testUser = new NormalUser("testUser", "testUser", "testUser", "testUser",
                testProfile);
        currentUser1.setUser(testUser);

        Group group = new NormalGroup(groupName);
        EditPendingListDsGateway repository = new PendingListDataAccess(username, user, groupName, group);
        user.getApplicationsList().put(groupName, group);
        group.addRequest(username);

        EditPendingListOutputBoundary presenter = new EditPendingListOutputBoundary() {
            @Override
            public EditPendingListResponseModel prepareSuccessView(EditPendingListResponseModel responseModel) {
                String responseGroupName = responseModel.getGroupName();
                String responseUsername = responseModel.getUsername();
                Assertions.assertTrue(repository.groupInUser(responseGroupName, responseUsername));
                Assertions.assertTrue(repository.userInGroup(responseUsername, responseGroupName));
                Assertions.assertFalse(repository.groupInApplications(responseGroupName, responseUsername));
                Assertions.assertFalse(repository.userInMemberRequests(responseUsername, responseGroupName));
                return null;
            }

            @Override
            public EditPendingListResponseModel prepareFailView(String error) {
                Assertions.fail("Use case failure is unexpected.");
                return null;
            }
        };

        EditPendingListInputBoundary interactor = new EditPendingListInteractor(repository, presenter);
        EditPendingListRequestModel inputData = new EditPendingListRequestModel(username, groupName,
                true);
        interactor.addOrRemoveUser(inputData);

    }
}
