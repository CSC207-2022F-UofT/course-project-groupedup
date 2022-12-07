package apply_to_group_test;

import use_cases.apply_to_group_use_case.*;
import entities.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
public class ApplyToGroupInteractorTest {

    /**
     * Populates testing repository with user and group entities
     * @return populated repository for testing
     */
    private ApplyToGroupDsGateway initialize() {

        User testUser = new NormalUser("Ipek", "dance",
                "testUser", "ipek691@gmail.com", new UserPublicProfile());

        CurrentUser currentUser = CurrentUser.getInstance();
        currentUser.setUser(testUser);
        Group group = new NormalGroup("Ipek's group");

        User testUser2 = new NormalUser("Ted", "soccer",
                "testUser2", "ted98@gmail.com", new UserPublicProfile());
        currentUser.setUser(testUser2);

        User testUser3 = new NormalUser("Freda", "tabletennis",
                "testUser3", "fredapan@gmail.com", new UserPublicProfile());
        testUser3.getGroups().put("Ipek's Group", "Ipek's Group");
        group.addMember(testUser3.getUsername());
        currentUser.setUser(testUser3);

        User testUser4 = new NormalUser("Araceli", "pilates",
                "TestUser4", "araceli@gmail.com", new UserPublicProfile());
        testUser4.getApplicationsList().put("Ipek's Group", "Ipek's Group");
        group.addMemberRequest(testUser4.getUsername());
        currentUser.setUser(testUser4);

        HashMap<String, User> users = new HashMap<>();
        users.put(testUser.getUsername(), testUser);
        users.put(testUser2.getUsername(), testUser2);
        users.put(testUser3.getUsername(), testUser3);
        users.put(testUser4.getUsername(), testUser4);

        HashMap<String, Group> groups = new HashMap<>();
        groups.put("Ipek's group", group);

        return new ApplyToGroupDataAccess(users, groups);
    }


    @Test
    public void applyToGroupSuccess() {
        ApplyToGroupDsGateway repo = initialize();
        ApplyToGroupOutputBoundary outputBoundary = new ApplyToGroupOutputBoundary() {
            @Override
            public void prepareFailView(String error) {
                Assertions.fail("Use case failure is unexpected");
            }

            @Override
            public void prepareSuccessView(ApplyToGroupResponseModel responseModel) {
                String username = responseModel.getUsername();
                String groupName = responseModel.getGroupName();

                Group group = repo.getGroup(groupName);

                Assertions.assertTrue(group.getMemberRequests(repo.loadUsers()).containsKey(username));

                Assertions.assertTrue(repo.getUser(username).getApplicationsList()
                        .containsKey(groupName));
            }
        };

        ApplyToGroupInputBoundary interactor = new ApplyToGroupInteractor(repo, outputBoundary);
        ApplyToGroupRequestModel inputData = new ApplyToGroupRequestModel("Ted",
                "Ipek's group");

        interactor.applyToGroup(inputData);
    }

    @Test
    public void GroupNotFoundFailure() {

        ApplyToGroupDsGateway repo = initialize();
        ApplyToGroupOutputBoundary outputBoundary = new ApplyToGroupOutputBoundary(){

            @Override
            public void prepareFailView(String error) {
                Assertions.assertEquals(InteractorMessages.GROUP_DOES_NOT_EXIST, error);
            }

            @Override
            public void prepareSuccessView(ApplyToGroupResponseModel responseModel) {
                Assertions.fail("Use case success is unexpected.");
            }
        };

        ApplyToGroupInputBoundary interactor = new ApplyToGroupInteractor(repo, outputBoundary);
        ApplyToGroupRequestModel inputData = new ApplyToGroupRequestModel("Ted",
                "nonexistent");
        interactor.applyToGroup(inputData);
    }

    @Test
    public void UserInGroupFailure() {

        ApplyToGroupDsGateway repo = initialize();
        ApplyToGroupOutputBoundary outputBoundary = new ApplyToGroupOutputBoundary() {
            @Override
            public void prepareFailView(String error) {
                Assertions.assertEquals(InteractorMessages.USER_IN_GROUP, error);
            }

            @Override
            public void prepareSuccessView(ApplyToGroupResponseModel responseModel) {
                Assertions.fail("Use case success is unexpected.");
            }
        };

        ApplyToGroupInputBoundary interactor = new ApplyToGroupInteractor(repo, outputBoundary);
        ApplyToGroupRequestModel inputData = new ApplyToGroupRequestModel("Freda",
                "Ipek's group");

        interactor.applyToGroup(inputData);
    }

    @Test
    public void UserInApplicationsFailure() {

        ApplyToGroupDsGateway repo = initialize();
        ApplyToGroupOutputBoundary outputBoundary = new ApplyToGroupOutputBoundary() {

            @Override
            public void prepareFailView(String error) {
                Assertions.assertEquals(InteractorMessages.USER_IN_APPLICATIONS, error);
            }

            @Override
            public void prepareSuccessView(ApplyToGroupResponseModel responseModel) {
                Assertions.fail("Use case success is unexpected.");
            }
        };

        ApplyToGroupInputBoundary interactor = new ApplyToGroupInteractor(repo, outputBoundary);
        ApplyToGroupRequestModel inputData = new ApplyToGroupRequestModel("Araceli",
                "Ipek's group");

        interactor.applyToGroup(inputData);
    }
}
