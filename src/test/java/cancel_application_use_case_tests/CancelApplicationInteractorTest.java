package cancel_application_use_case_tests;

import use_cases.cancel_application_use_case.*;
import entities.*;
import controllers_presenters_and_screen_boundaries.cancel_application_adapters.CancelApplicationController;
import controllers_presenters_and_screen_boundaries.cancel_application_adapters.CancelApplicationPresenter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

public class CancelApplicationInteractorTest {

    /**
     * Populates testing repository with user and group entities
     * @return populated repository for testing
     */
    private CancelApplicationDsGateway initialize() {
        User testUser = new NormalUser("Bob", "testUser", "testUser", "testUser",
                new UserPublicProfile());

        CurrentUser currentUser = CurrentUser.getInstance();
        currentUser.setUser(testUser);
        Group group = new NormalGroup("Bob's group");

        User testUser2 = new NormalUser("testUser2", "testUser2", "testUser2",
                "testUser2", new UserPublicProfile());
        testUser2.getApplicationsList().put("Bob's group", "Bob's group");
        group.addRequest(testUser2.getUsername());

        User testUser3 = new NormalUser("aarya", "aarya", "Aarya", "aarya@gmail.com",
                new UserPublicProfile());
        testUser3.getApplicationsList().put("Bob's group", "Bob's group");

        User testUser4 = new NormalUser("testUser4", "testUser4", "testUser4",
                "testUser4", new UserPublicProfile());
        group.addRequest(testUser4.getUsername());

        HashMap<String, User> users = new HashMap<>();
        users.put(testUser.getUsername(), testUser);
        users.put(testUser2.getUsername(), testUser2);
        users.put(testUser3.getUsername(), testUser3);
        users.put(testUser4.getUsername(), testUser4);

        HashMap<String, Group> groups = new HashMap<>();
        groups.put("Bob's group", group);

        return new CancelApplicationDataAccess(users, groups);
    }
    @Test
    public void cancelApplicationSuccess() {

        CancelApplicationDsGateway repository = initialize();
        CancelApplicationOutputBoundary presenter = new CancelApplicationOutputBoundary() {
            @Override
            public void prepareFailureView(String error) {
                Assertions.fail("Use case failure is unexpected.");
            }

            @Override
            public void prepareSuccessView(CancelApplicationResponseModel responseModel) {
                String username = responseModel.getUsername();
                String groupName = responseModel.getGroupname();

                Assertions.assertFalse(repository.getGroup(groupName)
                        .getMemberRequests(repository.loadUsers()).containsKey(username));

                Assertions.assertFalse(repository.getUser(username).getApplicationsList()
                        .containsKey(groupName));
            }
        };
        CancelApplicationInputBoundary interactor = new CancelApplicationInteractor(repository, presenter);
        CancelApplicationRequestModel inputData = new CancelApplicationRequestModel("testUser2",
                "Bob's group");

        interactor.cancelApplication(inputData);
    }

    @Test
    public void GroupDoesNotExistFailure() {

        CancelApplicationDsGateway repository = initialize();
        CancelApplicationOutputBoundary presenter = new CancelApplicationPresenter();
        CancelApplicationInputBoundary interactor = new CancelApplicationInteractor(repository, presenter);

        RuntimeException thrown = Assertions.assertThrows(RuntimeException.class, () -> {
            CancelApplicationController controller = new CancelApplicationController(interactor);
            controller.cancelApplication("testUser2", "asdf");
        });
        Assertions.assertEquals("This group does not exist.", thrown.getMessage());
    }

    @Test
    public void UserNotInRequestsFailure() {

        CancelApplicationDsGateway repository = initialize();
        CancelApplicationOutputBoundary presenter = new CancelApplicationOutputBoundary() {
            @Override
            public void prepareFailureView(String error) {
                Assertions.assertEquals("The group has already rejected your application.", error);
            }

            @Override
            public void prepareSuccessView(CancelApplicationResponseModel responseModel) {
                Assertions.fail("Use case success is unexpected.");
            }
        };

        CancelApplicationInputBoundary interactor = new CancelApplicationInteractor(repository, presenter);
        CancelApplicationRequestModel inputData = new CancelApplicationRequestModel("aarya",
                "Bob's group");

        interactor.cancelApplication(inputData);
    }

    @Test
    public void GroupNotInApplicationsFailure() {

        CancelApplicationDsGateway repository = initialize();
        CancelApplicationOutputBoundary presenter = new CancelApplicationPresenter();
        CancelApplicationInputBoundary interactor = new CancelApplicationInteractor(repository, presenter);

        RuntimeException thrown = Assertions.assertThrows(RuntimeException.class, () -> {
            CancelApplicationController controller = new CancelApplicationController(interactor);
            controller.cancelApplication("testUser4", "Bob's group");
        });

        Assertions.assertEquals("Group is not in user's applications list.", thrown.getMessage());
    }
}
