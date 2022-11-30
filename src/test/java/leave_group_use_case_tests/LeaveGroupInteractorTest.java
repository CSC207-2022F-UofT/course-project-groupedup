package leave_group_use_case_tests;

import Entities.*;
import leave_group_screens.LeaveGroupDataAccess;
import leave_group_use_case.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

public class LeaveGroupInteractorTest {
    @Test
    public void leaveGroupSuccess() {

        User testUser = new NormalUser("Bob", "testUser", "testUser", "testUser",
                new UserPublicProfile());

        CurrentUser currentUser = CurrentUser.getInstance();
        currentUser.setUser(testUser);
        String groupName = "Bob's group";
        Group group = new NormalGroup(groupName);

        User testUser2 = new NormalUser("testUser2", "testUser2", "testUser2", "testUser2",
                new UserPublicProfile());
        testUser2.getGroups().put(groupName, group);
        group.addMember(testUser2.getUsername());

        String username = "aarya";
        User user = new NormalUser(username, "aarya", "Aarya", "aarya@gmail.com",
                new UserPublicProfile());
        user.getGroups().put(groupName, group);
        group.addMember(user.getUsername());

        HashMap<String, User> users = new HashMap<>();
        users.put(testUser.getUsername(), testUser);
        users.put(testUser2.getUsername(), testUser2);
        users.put(user.getUsername(), user);

        HashMap<String, Group> groups = new HashMap<>();
        groups.put(groupName, group);

        LeaveGroupDsGateway repository = new LeaveGroupDataAccess(users, groups);

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
        LeaveGroupRequestModel inputData = new LeaveGroupRequestModel(username, groupName);

        interactor.leaveGroup(inputData);
    }
}
