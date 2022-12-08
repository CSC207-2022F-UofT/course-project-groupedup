package edit_user_public_profile_tests;
import entities.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import use_cases.edit_user_public_profile_use_case.*;

import java.util.HashMap;

public class EditUserPublicProfileInteractorTest {
    private EditUserPublicProfileDSGateway initialize() {
        User testUser = new NormalUser("Hannah", "test", "Hannah", "testUser",
                new UserPublicProfile());
        CurrentUser currentUser = CurrentUser.getInstance();
        currentUser.setUser(testUser);

        HashMap<String, String> test_preferences = new HashMap<>();
        test_preferences.put("Location", "");
        test_preferences.put("Meeting Time", "");
        test_preferences.put("Time Commitment", "");
        testUser.getUserPublicProfile().setPreferences(test_preferences);

        HashMap<String, User> userMap = new HashMap<>();
        userMap.put(testUser.getUsername(), testUser);

        return new UserPublicProfileDataAccess(userMap);
    }

    @Test
    public void testEditUserProfileSuccess() {
        EditUserPublicProfileDSGateway gateway = initialize();
        User test_user = gateway.getUser("Hannah");

        EditUserPublicProfileOutputBoundary presenter = new EditUserPublicProfileOutputBoundary() {
            @Override
            public void prepareSuccessView(EditUserPublicProfileResponseModel EditedChanges) {
                Assertions.assertEquals(test_user.getUserPublicProfile().getBiography(), "Hi, " +
                        "looking to join a group!");
                Assertions.assertEquals(test_user.getUserPublicProfile().getCoursePreferences(), "CSC207, " +
                        "CSC209");
                Assertions.assertEquals(test_user.getUserPublicProfile().getPreferences().get("Location"),
                        "In-Person");
                Assertions.assertEquals(test_user.getUserPublicProfile().getPreferences().get("Meeting Time"),
                        "Monday");
                Assertions.assertEquals(test_user.getUserPublicProfile().getPreferences().get("Time Commitment"),
                        "0-2 hours");
            }

            @Override
            public void prepareFailView(String error) {
                Assertions.fail("User Profile was not updated correctly.");
            }
        };

        EditUserPublicProfileRequestModel requestModel = new EditUserPublicProfileRequestModel("Hannah",
                "Hi, looking to join a group!",
                "CSC207, CSC209",
                "In-Person",
                "Monday",
                "0-2 hours");
        EditUserPublicProfileInputBoundary interactor = new EditUserPublicProfileInteractor(gateway, presenter);
        interactor.saveEdits(requestModel);
    }

    @Test
    public void testEditUserProfileFailedBioEmpty() {
        EditUserPublicProfileDSGateway gateway = initialize();

        EditUserPublicProfileOutputBoundary presenter = new EditUserPublicProfileOutputBoundary() {
            @Override
            public void prepareSuccessView(EditUserPublicProfileResponseModel EditedChanges) {
                Assertions.fail("User Profile passed even though user's bio was left empty.");
            }

            @Override
            public void prepareFailView(String error) {
                Assertions.assertEquals(error, "Biography was left blank.");
            }
        };

        EditUserPublicProfileRequestModel requestModel = new EditUserPublicProfileRequestModel("Hannah",
                "",
                "CSC207, CSC209",
                "In-Person",
                "Monday",
                "0-2 hours");
        EditUserPublicProfileInputBoundary interactor = new EditUserPublicProfileInteractor(gateway, presenter);
        interactor.saveEdits(requestModel);
    }

    @Test
    public void testEditUserProfileFailedPreferencesEmpty() {
        EditUserPublicProfileDSGateway gateway = initialize();

        EditUserPublicProfileOutputBoundary presenter = new EditUserPublicProfileOutputBoundary() {
            @Override
            public void prepareSuccessView(EditUserPublicProfileResponseModel EditedChanges) {
                Assertions.fail("User Profile passed even though user's preference was left empty.");
            }

            @Override
            public void prepareFailView(String error) {
                Assertions.assertEquals(error, "Preferences was left blank.");
            }
        };

        EditUserPublicProfileRequestModel requestModel = new EditUserPublicProfileRequestModel("Hannah",
                "Hello",
                "CSC207, CSC209",
                "",
                "Monday",
                "0-2 hours");
        EditUserPublicProfileInputBoundary interactor = new EditUserPublicProfileInteractor(gateway, presenter);
        interactor.saveEdits(requestModel);
    }

    @Test
    public void testEditUserProfileFailedPreferences2Empty() {
        EditUserPublicProfileDSGateway gateway = initialize();

        EditUserPublicProfileOutputBoundary presenter = new EditUserPublicProfileOutputBoundary() {
            @Override
            public void prepareSuccessView(EditUserPublicProfileResponseModel EditedChanges) {
                Assertions.fail("User Profile passed even though user's preference was left empty.");
            }

            @Override
            public void prepareFailView(String error) {
                Assertions.assertEquals(error, "Preferences was left blank.");
            }
        };

        EditUserPublicProfileRequestModel requestModel = new EditUserPublicProfileRequestModel("Hannah",
                "Hello",
                "CSC207, CSC209",
                "Online",
                "",
                "0-2 hours");
        EditUserPublicProfileInputBoundary interactor = new EditUserPublicProfileInteractor(gateway, presenter);
        interactor.saveEdits(requestModel);
    }

    @Test
    public void testEditUserProfileFailedPreferences3Empty() {
        EditUserPublicProfileDSGateway gateway = initialize();

        EditUserPublicProfileOutputBoundary presenter = new EditUserPublicProfileOutputBoundary() {
            @Override
            public void prepareSuccessView(EditUserPublicProfileResponseModel EditedChanges) {
                Assertions.fail("User Profile passed even though user's preference was left empty.");
            }

            @Override
            public void prepareFailView(String error) {
                Assertions.assertEquals(error, "Preferences was left blank.");
            }
        };

        EditUserPublicProfileRequestModel requestModel = new EditUserPublicProfileRequestModel("Hannah",
                "Hello",
                "CSC207, CSC209",
                "Online",
                "Monday",
                "");
        EditUserPublicProfileInputBoundary interactor = new EditUserPublicProfileInteractor(gateway, presenter);
        interactor.saveEdits(requestModel);
    }

    @Test
    public void testEditUserProfileFailedCourseCodesEmpty() {
        EditUserPublicProfileDSGateway gateway = initialize();

        EditUserPublicProfileOutputBoundary presenter = new EditUserPublicProfileOutputBoundary() {
            @Override
            public void prepareSuccessView(EditUserPublicProfileResponseModel EditedChanges) {
                Assertions.fail("User Profile passed even though user's course preference was left empty.");
            }

            @Override
            public void prepareFailView(String error) {
                Assertions.assertEquals(error, "Course preferences was left blank.");
            }
        };

        EditUserPublicProfileRequestModel requestModel = new EditUserPublicProfileRequestModel("Hannah",
                "Hello",
                "",
                "In-Person",
                "Monday",
                "0-2 hours");
        EditUserPublicProfileInputBoundary interactor = new EditUserPublicProfileInteractor(gateway, presenter);
        interactor.saveEdits(requestModel);
    }

    @Test
    public void testEditUserProfileFailedUserNotFound() {
        EditUserPublicProfileDSGateway gateway = initialize();

        EditUserPublicProfileOutputBoundary presenter = new EditUserPublicProfileOutputBoundary() {
            @Override
            public void prepareSuccessView(EditUserPublicProfileResponseModel EditedChanges) {
                Assertions.fail(InteractorMessages.USER_DOES_NOT_EXIST);
            }

            @Override
            public void prepareFailView(String error) {
                Assertions.assertEquals(error, InteractorMessages.USER_DOES_NOT_EXIST);
            }
        };

        EditUserPublicProfileRequestModel requestModel = new EditUserPublicProfileRequestModel("John",
                "Hello",
                "CSC207, CSC209",
                "In-Person",
                "Monday",
                "0-2 hours");
        EditUserPublicProfileInputBoundary interactor = new EditUserPublicProfileInteractor(gateway, presenter);
        interactor.saveEdits(requestModel);
    }
}
