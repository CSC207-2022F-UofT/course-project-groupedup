package edit_group_profile_tests;

import use_cases.edit_group_profile_use_case.*;
import entities.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

class EditGroupProfileInteractorTest {
    private EditGroupProfileDsGateway initialize() {
        User testUser = new NormalUser("Julia", "testUser", "testUser", "testUser",
                new UserPublicProfile());

        CurrentUser currentUser = CurrentUser.getInstance();
        currentUser.setUser(testUser);
        Group group = new NormalGroup("Julia's group");
        group.getProfile().setCourseCode("CSC236");
        group.getProfile().setDescription("A new group for testing!");

        HashMap<String, String> p = new HashMap<>();
        p.put("Location", "Online");
        p.put("Meeting Time", "Monday");
        p.put("Time Commitment", "0-2 hours");

        group.getProfile().setPreferences(p);


        HashMap<String, Group> groups = new HashMap<>();
        groups.put("Julia's group", group);
        EditGroupProfileDataAccess dataAccess = new EditGroupProfileDataAccess(groups);

        return dataAccess;
    }

    @Test
    public void editProfileSuccess() {

        EditGroupProfileDsGateway repository = initialize();
        Group group = repository.findGroup("Julia's group");
        EditGroupProfileOutputBoundary presenter = new EditGroupProfileOutputBoundary() {
            @Override
            public void prepareSuccessView(EditGroupProfileResponseModel responseModel) {

                Assertions.assertEquals(group.getProfile().getCourseCode(), "CSC236");
                Assertions.assertEquals(group.getProfile().getDescription(),
                        "A new group!");
                Assertions.assertEquals(group.getProfile().getPreferences().get("Location"),
                        "In-Person");
                Assertions.assertEquals(group.getProfile().getPreferences().get("Meeting Time"),
                        "Tuesday");
                Assertions.assertEquals(group.getProfile().getPreferences().get("Time Commitment"),
                        "2-4 hours");
            }

            @Override
            public void prepareFailView(String error) {
                Assertions.fail("Use case failure is unexpected.");
            }
        };
        EditGroupProfileInputBoundary interactor = new EditGroupProfileInteractor(repository, presenter);
        EditGroupProfileRequestModel inputData = new EditGroupProfileRequestModel("Julia's group",
                "A new group!", "2-4 hours", "In-Person", "Tuesday",
                "CSC236");

        interactor.editGroup(inputData);
    }

    @Test
    public void groupNotFoundFailure() {

        EditGroupProfileDsGateway repository = initialize();
        Group group = repository.findGroup("Sohee's group");
        EditGroupProfileOutputBoundary presenter = new EditGroupProfileOutputBoundary() {
            @Override
            public void prepareFailView(String error) {
                Assertions.assertEquals(InteractorMessages.GROUP_DOES_NOT_EXIST, error);
            }

            @Override
            public void prepareSuccessView(EditGroupProfileResponseModel responseModel) {
                Assertions.fail("Use case success is unexpected.");
            }
        };

        EditGroupProfileInputBoundary interactor = new EditGroupProfileInteractor(repository, presenter);
        EditGroupProfileRequestModel inputData = new EditGroupProfileRequestModel("Sohee's group",
                "A new group!", "2-4 hours", "In-Person", "Tuesday",
                "CSC207");

        interactor.editGroup(inputData);

    }

    @Test
    public void courseCodeInvalidFailure() {

        EditGroupProfileDsGateway repository = initialize();
        Group group = repository.findGroup("Julia's group");
        EditGroupProfileOutputBoundary presenter = new EditGroupProfileOutputBoundary() {
            @Override
            public void prepareFailView(String error) {
                Assertions.assertEquals(InteractorMessages.INVALID_COURSE_CODE, error);
            }

            @Override
            public void prepareSuccessView(EditGroupProfileResponseModel responseModel) {
                Assertions.fail("Use case success is unexpected.");
            }
        };

        EditGroupProfileInputBoundary interactor = new EditGroupProfileInteractor(repository, presenter);
        EditGroupProfileRequestModel inputData = new EditGroupProfileRequestModel("Julia's group",
                "A new group!", "2-4 hours", "In-Person", "Tuesday",
                "aaaaaa");

        interactor.editGroup(inputData);

    }

    @Test
    public void descriptionBlankFailure() {

        EditGroupProfileDsGateway repository = initialize();

        EditGroupProfileOutputBoundary presenter = new EditGroupProfileOutputBoundary() {
            @Override
            public void prepareSuccessView(EditGroupProfileResponseModel responseModel) {
                Assertions.fail("Use case success is unexpected.");
            }
            @Override
            public void prepareFailView(String error) {
                Assertions.assertEquals(error, InteractorMessages.DESCRIPTION_BLANK);
            }
        };

        EditGroupProfileRequestModel requestModel = new EditGroupProfileRequestModel("Julia's Group", "",
                "2-4 hours", "In-Person", "Monday", "CSC236");

        EditGroupProfileInputBoundary interactor = new EditGroupProfileInteractor(repository, presenter);

        interactor.editGroup(requestModel);
    }

    @Test
    public void courseBlankFailure() {

        EditGroupProfileDsGateway repository = initialize();

        EditGroupProfileOutputBoundary presenter = new EditGroupProfileOutputBoundary() {
            @Override
            public void prepareSuccessView(EditGroupProfileResponseModel responseModel) {
                Assertions.fail("Use case success is unexpected.");
            }
            @Override
            public void prepareFailView(String error) {
                Assertions.assertEquals(error, InteractorMessages.COURSE_BLANK);
            }
        };

        EditGroupProfileRequestModel requestModel = new EditGroupProfileRequestModel("Julia's Group",
                "Welcome to Julia's group!", "2-4 hours",
                "In-Person", "Monday", "");

        EditGroupProfileInputBoundary interactor = new EditGroupProfileInteractor(repository, presenter);

        interactor.editGroup(requestModel);
    }

    @Test
    public void preferencesBlankFailure() {

        EditGroupProfileDsGateway repository = initialize();

        EditGroupProfileOutputBoundary presenter = new EditGroupProfileOutputBoundary() {
            @Override
            public void prepareSuccessView(EditGroupProfileResponseModel responseModel) {
                Assertions.fail("Use case success is unexpected.");
            }
            @Override
            public void prepareFailView(String error) {
                Assertions.assertEquals(error, InteractorMessages.PREFERENCES_BLANK);
            }
        };

        EditGroupProfileRequestModel requestModel = new EditGroupProfileRequestModel("Julia's Group",
                "Welcome to Julia's group!", "",
                "In-Person", "Monday", "CSC236");

        EditGroupProfileInputBoundary interactor = new EditGroupProfileInteractor(repository, presenter);

        interactor.editGroup(requestModel);
    }

}
