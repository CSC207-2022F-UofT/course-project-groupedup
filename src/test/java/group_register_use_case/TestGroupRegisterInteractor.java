package group_register_use_case;

import Entities.*;
import group_creation_screens.GroupRegisterPresenter;
import group_creation_use_case.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import group_creation_screens.InMemoryFileGroup;

import static org.junit.jupiter.api.Assertions.*;

class TestGroupRegisterInteractor {
    @BeforeEach
    void beforeEach(){
        CurrentUser currentUser1 = CurrentUser.getInstance();
        UserPublicProfile testProfile = new UserPublicProfile();
        User testUser = new NormalUser("testUser", "testUser", "testUser", "testUser",
                testProfile);
        currentUser1.setUser(testUser);
    }

    @Test
    void test_use_case_success() {
        NewGroupDSGateway groupRepository = new InMemoryFileGroup();

        GroupRegisterOutputBoundary presenter = new GroupRegisterPresenter(){
            @Override
            public void prepareSuccessView(GroupRegisterResponseModel groupResponseModel) {
                assertEquals("Sohee's study group", groupResponseModel.getGroupName());
                assertTrue(groupRepository.groupIdentifierExists("Sohee's study group"));
            }

            @Override
            public void prepareFailView(String error) {
                fail("Use case failure is unexpected.");
            }
        };

        GroupFactory groupFactory = new GroupFactory();
        GroupRegisterInputBoundary interactor = new GroupRegisterInteractor(
                groupRepository, presenter, groupFactory);

        GroupRegisterRequestModel inputData = new GroupRegisterRequestModel(
                "Sohee's study group");

        interactor.create(inputData);
    }

    @Test
    void test_use_case_success_different_group() {
        NewGroupDSGateway groupRepository = new InMemoryFileGroup();
        GroupRegisterOutputBoundary presenter = new GroupRegisterPresenter(){
            @Override
            public void prepareSuccessView(GroupRegisterResponseModel groupResponseModel) {
                assertEquals("Sohee's study group", groupResponseModel.getGroupName());
                assertTrue(groupRepository.groupIdentifierExists("Sohee's study group"));
            }

            @Override
            public void prepareFailView(String error) {
                fail("Use case failure is unexpected.");
            }
        };


        GroupFactory groupFactory = new GroupFactory();
        GroupRegisterInputBoundary interactor = new GroupRegisterInteractor(
                groupRepository, presenter, groupFactory);

        GroupRegisterRequestModel inputData = new GroupRegisterRequestModel(
                "Sohee's study group");
        Group group = new NormalGroup("John's study group");
        GroupRegisterDSRequestModel existingData = new GroupRegisterDSRequestModel(group,group.getGroupName());

        groupRepository.saveNewGroups(existingData);

        interactor.create(inputData);
    }

    @Test
    void test_use_case_group_exists() {
        NewGroupDSGateway groupRepository = new InMemoryFileGroup();
        GroupRegisterOutputBoundary presenter = new GroupRegisterPresenter(){
            @Override
            public void prepareSuccessView(GroupRegisterResponseModel groupResponseModel) {
                fail("Use case success is unexpected");
            }

            @Override
            public void prepareFailView(String error) {
                System.out.println(error);
            }
        };

        GroupFactory groupFactory = new GroupFactory();
        GroupRegisterInputBoundary interactor = new GroupRegisterInteractor(
                groupRepository, presenter, groupFactory);
        GroupRegisterRequestModel inputData = new GroupRegisterRequestModel(
                "Sohee's study group");
        Group group = new NormalGroup("Sohee's study group");
        GroupRegisterDSRequestModel existingData = new GroupRegisterDSRequestModel(group,group.getGroupName());

        groupRepository.saveNewGroups(existingData);

        interactor.create(inputData);
    }
    @Test
    void test_use_case_group_name_empty() {
        NewGroupDSGateway groupRepository = new InMemoryFileGroup();

        GroupRegisterOutputBoundary presenter = new GroupRegisterPresenter(){
            @Override
            public void prepareSuccessView(GroupRegisterResponseModel groupResponseModel) {
                fail("Use case success is unexpected");
            }

            @Override
            public void prepareFailView(String error) {
                System.out.println(error);
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
