package leave_group_use_case_tests;

import Entities.*;
import leave_group_screens.LeaveGroupDataAccess;
import leave_group_use_case.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

public class LeaveGroupInteractorTest {

    /**
     * Populates testing repository with user and group entities
     * @return populated repository for testing
     */
    private LeaveGroupDsGateway initialize() {
        User testUser = new NormalUser("Bob", "testUser", "testUser", "testUser",
                new UserPublicProfile());

        CurrentUser currentUser = CurrentUser.getInstance();
        currentUser.setUser(testUser);
        Group group = new NormalGroup("Bob's group");

        User testUser2 = new NormalUser("testUser2", "testUser2", "testUser2", "testUser2",
                new UserPublicProfile());
        testUser2.getGroups().put("Bob's group", "Bob's group");
        group.addMember(testUser2.getUsername());
        currentUser.setUser(testUser2);
        Group group2 = new NormalGroup("Woo");
        testUser2.removeGroup("Woo");

        User user = new NormalUser("aarya", "aarya", "Aarya", "aarya@gmail.com",
                new UserPublicProfile());
        user.getGroups().put("Bob's group", "Bob's group");
        group.addMember(user.getUsername());
        currentUser.setUser(user);
        Group group3 = new NormalGroup("Wee");
        group3.removeMember("aarya");

        HashMap<String, User> users = new HashMap<>();
        users.put(testUser.getUsername(), testUser);
        users.put(testUser2.getUsername(), testUser2);
        users.put(user.getUsername(), user);

        HashMap<String, Group> groups = new HashMap<>();
        groups.put("Bob's group", group);
        groups.put("Woo", group2);
        groups.put("Wee", group3);

        return new LeaveGroupDataAccess(users, groups);
    }
    @Test
    public void leaveGroupSuccess() {

        LeaveGroupDsGateway repository = initialize();
        LeaveGroupOutputBoundary presenter = new LeaveGroupOutputBoundary() {
            @Override
            public void prepareFailureView(String error) {
                Assertions.fail("Use case failure is unexpected.");
            }

            @Override
            public void prepareSuccessView(LeaveGroupResponseModel responseModel) {
                String responseUsername = responseModel.getUsername();
                String responseGroupName = responseModel.getGroupname();

                Group group = repository.getGroup(responseGroupName);

                Assertions.assertFalse(group.getGroupMembers(repository.loadUsers()).containsKey(responseUsername));
                Assertions.assertFalse(repository.getUser(responseUsername).getGroups().containsKey(responseGroupName));
            }
        };

        LeaveGroupInputBoundary interactor = new LeaveGroupInteractor(repository, presenter);
        LeaveGroupRequestModel inputData = new LeaveGroupRequestModel("aarya", "Bob's group");

        interactor.leaveGroup(inputData);
    }

    @Test
    public void GroupNotFoundFailure() {

        LeaveGroupDsGateway repository = initialize();
        LeaveGroupOutputBoundary presenter = new LeaveGroupOutputBoundary() {
            @Override
            public void prepareFailureView(String error) {
                Assertions.assertEquals("Group does not exist.", error);
            }

            @Override
            public void prepareSuccessView(LeaveGroupResponseModel responseModel) {
                Assertions.fail("Use case success is unexpected.");
            }
        };

        LeaveGroupInputBoundary interactor = new LeaveGroupInteractor(repository, presenter);
        LeaveGroupRequestModel inputData = new LeaveGroupRequestModel("aarya", "asdf");

        interactor.leaveGroup(inputData);
    }

    @Test
    public void UserNotInGroupFailure() {

        LeaveGroupDsGateway repository = initialize();
        LeaveGroupOutputBoundary presenter = new LeaveGroupOutputBoundary() {
            @Override
            public void prepareFailureView(String error) {
                Assertions.assertEquals("User is not in group.", error);
            }

            @Override
            public void prepareSuccessView(LeaveGroupResponseModel responseModel) {
                Assertions.fail("Use case success is unexpected.");
            }
        };

        LeaveGroupInputBoundary interactor = new LeaveGroupInteractor(repository, presenter);
        LeaveGroupRequestModel inputData = new LeaveGroupRequestModel("aarya", "Wee");

        interactor.leaveGroup(inputData);
    }

    @Test
    public void GroupNotInUserFailure() {

        LeaveGroupDsGateway repository = initialize();
        LeaveGroupOutputBoundary presenter = new LeaveGroupOutputBoundary() {
            @Override
            public void prepareFailureView(String error) {
                Assertions.assertEquals("Group is not in \"My Groups\" list.", error);
            }
            @Override
            public void prepareSuccessView(LeaveGroupResponseModel responseModel) {
                Assertions.fail("Use case success is unexpected.");
            }
        };

        LeaveGroupInputBoundary interactor = new LeaveGroupInteractor(repository, presenter);
        LeaveGroupRequestModel inputData = new LeaveGroupRequestModel("testUser2", "Woo");

        interactor.leaveGroup(inputData);
    }
}
