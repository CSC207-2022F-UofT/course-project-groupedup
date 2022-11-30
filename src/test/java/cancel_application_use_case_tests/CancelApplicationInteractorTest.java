package cancel_application_use_case_tests;

import Entities.*;
import cancel_application_screens.CancelApplicationDataAccess;
import cancel_application_use_case.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CancelApplicationInteractorTest {
    @Test
    public void cancelApplicationSuccess() {

        User testUser = new NormalUser("testUser", "testUser", "testUser", "testUser",
                new UserPublicProfile());

        CurrentUser currentUser = CurrentUser.getInstance();
        currentUser.setUser(testUser);

        String groupName = "Bob's group";
        String username = "aarya";

        Group group = new NormalGroup(groupName);

        User user = new NormalUser(username, "aarya", "Aarya", "aarya@gmail.com",
                new UserPublicProfile());

        CancelApplicationDsGateway repository = new CancelApplicationDataAccess(username, user, groupName, group);

        user.getApplicationsList().put(groupName, group);
        group.addRequest(username);

        CancelApplicationOutputBoundary presenter = new CancelApplicationOutputBoundary() {
            @Override
            public void prepareFailureView(String error) {
                Assertions.fail("Use case failure is unexpected.");
            }

            @Override
            public void prepareSuccessView(CancelApplicationResponseModel responseModel) {
                String responseUsername = responseModel.getUsername();
                String responseGroupName = responseModel.getGroupname();

                Assertions.assertEquals(username, responseUsername);
                Assertions.assertEquals(groupName, responseGroupName);

                Assertions.assertFalse(group.getMemberRequests(repository.loadUsers()).containsKey(username));
                Assertions.assertFalse(repository.getUser(responseUsername).getApplicationsList().containsKey(responseGroupName));
            }
        };

        CancelApplicationInputBoundary interactor = new CancelApplicationInteractor(repository, presenter);
        CancelApplicationRequestModel inputData = new CancelApplicationRequestModel(username, groupName);

        interactor.cancelApplication(inputData);
    }
}
