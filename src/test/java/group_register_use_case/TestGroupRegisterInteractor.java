package group_register_use_case;

import Entities.*;
import group_creation_screens.GroupRegisterPresenter;
import group_creation_use_case.*;
import org.junit.jupiter.api.Test;
import group_creation_screens.InMemoryFileGroup;

import static org.junit.jupiter.api.Assertions.*;

class TestGroupRegisterInteractor {

    @Test
    void test_use_case_success() {
        GroupDSGateway groupRepository = new InMemoryFileGroup();
        CurrentUser currentUser1 = CurrentUser.getInstance();
        UserPublicProfile testProfile = new UserPublicProfile();
        User testUser = new NormalUser("testUser", "testUser", "testUser", "testUser",
                testProfile);
        currentUser1.setUser(testUser);
        GroupRegisterOutputBoundary presenter = new GroupRegisterPresenter() {
            @Override
            public GroupRegisterResponseModel prepareSuccessView(GroupRegisterResponseModel group) {
                assertEquals("Sohee's study group", group.getGroupName());
                assertTrue(groupRepository.existsByIdentifier("Sohee's study group"));
                return null;
            }

            @Override
            public GroupRegisterResponseModel prepareFailView(String error) {
                fail("Use case failure is unexpected.");
                return null;
            }
        };

        GroupFactory groupFactory = new GroupFactory();
        GroupRegisterInputBoundary interactor = new GroupRegisterInteractor(
                groupRepository, presenter, groupFactory);

        // 2) Input data — we can make this up for the test. Normally it would
        // be created by the Controller.
        GroupRegisterRequestModel inputData = new GroupRegisterRequestModel(
                "Sohee's study group");

        // 3) Run the use case
        interactor.create(inputData);
    }

    @Test
    void test_use_case_group_exists() {
        GroupDSGateway groupRepository = new InMemoryFileGroup();
        CurrentUser currentUser1 = CurrentUser.getInstance();
        UserPublicProfile testProfile = new UserPublicProfile();
        User testUser = new NormalUser("testUser", "testUser", "testUser", "testUser",
                testProfile);
        currentUser1.setUser(testUser);

        GroupRegisterOutputBoundary presenter = new GroupRegisterPresenter() {
            @Override
            public GroupRegisterResponseModel prepareSuccessView(GroupRegisterResponseModel group) {
                fail("Use case success is unexpected");
                return null;
            }

            @Override
            public GroupRegisterResponseModel prepareFailView(String error) {
                System.out.println(error);
                return null;
            }
        };

        GroupFactory groupFactory = new GroupFactory();
        GroupRegisterInputBoundary interactor = new GroupRegisterInteractor(
                groupRepository, presenter, groupFactory);
        GroupRegisterRequestModel inputData = new GroupRegisterRequestModel(
                "Sohee's study group");
        Group group = new NormalGroup("Sohee's study group");
        GroupRegisterDSRequestModel existingData = new GroupRegisterDSRequestModel(group,group.getGroupName());

        groupRepository.save(existingData);

        interactor.create(inputData);
    }
    @Test
    void test_use_case_group_name_empty() {
        GroupDSGateway groupRepository = new InMemoryFileGroup();
        CurrentUser currentUser1 = CurrentUser.getInstance();
        UserPublicProfile testProfile = new UserPublicProfile();
        User testUser = new NormalUser("testUser", "testUser", "testUser", "testUser",
                testProfile);
        currentUser1.setUser(testUser);

        GroupRegisterOutputBoundary presenter = new GroupRegisterPresenter() {
            @Override
            public GroupRegisterResponseModel prepareSuccessView(GroupRegisterResponseModel group) {
                fail("Use case success is unexpected");
                return null;
            }

            @Override
            public GroupRegisterResponseModel prepareFailView(String error) {
                System.out.println(error);
                return null;
            }
        };

        GroupFactory groupFactory = new GroupFactory();
        GroupRegisterInputBoundary interactor = new GroupRegisterInteractor(
                groupRepository, presenter, groupFactory);
        GroupRegisterRequestModel inputData = new GroupRegisterRequestModel(
                "");

        interactor.create(inputData);
    }
}
