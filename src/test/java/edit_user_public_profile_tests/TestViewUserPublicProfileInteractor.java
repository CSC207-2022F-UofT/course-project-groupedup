package edit_user_public_profile_tests;
import entities.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import use_cases.view_user_public_profile_use_case.*;

import java.util.HashMap;

public class TestViewUserPublicProfileInteractor {
    /**
     * Initializing an imitation repo for tests.
     * @return view user public profile gateway.
     */
    private ViewUserPublicProfileDSGateway initialize() {
        User testUser = new NormalUser("Hannah", "test", "Hannah", "testUser",
                new UserPublicProfile());
        CurrentUser currentUser = CurrentUser.getInstance();
        currentUser.setUser(testUser);

        HashMap<String, String> test_preferences = new HashMap<>();
        test_preferences.put("Location", "Online");
        test_preferences.put("Meeting Time", "Monday");
        test_preferences.put("Time Commitment", "0-2 hours");
        testUser.getUserPublicProfile().setPreferences(test_preferences);

        HashMap<String, User> userMap = new HashMap<>();
        userMap.put(testUser.getUsername(), testUser);

        return new UserPublicProfileDataAccess(userMap);
    }

    /**
     * Testing whether the user's profile was viewed successfully
     */
    @Test
    public void testViewUserProfileSuccess() {
        ViewUserPublicProfileDSGateway gateway = initialize();
        User test_user = gateway.getUser("Hannah");

        ViewUserPublicProfileOutputBoundary presenter = new ViewUserPublicProfileOutputBoundary() {
            @Override
            public void prepareSuccessView(ViewUserPublicProfileResponseModel viewUserProfileResponse) {
                Assertions.assertEquals(viewUserProfileResponse.getUsername(), test_user.getUsername());
            }
        };
        ViewUserPublicProfileInteractor interactor = new ViewUserPublicProfileInteractor(gateway, presenter);
        ViewUserPublicProfileRequestModel requestModel = new ViewUserPublicProfileRequestModel("Hannah");
        interactor.showUserProfile(requestModel);
    }

    /**
     * Testing if view user's profile failed if user does not exist.
     */
    @Test
    public void testUserDoesNotExist() {
        ViewUserPublicProfileDSGateway gateway = initialize();

        ViewUserPublicProfileOutputBoundary presenter = new ViewUserPublicProfileOutputBoundary() {
            @Override
            public void prepareSuccessView(ViewUserPublicProfileResponseModel viewUserProfileResponse) {
                Assertions.fail("Test passed even though user does not exist.");
            }
        };

        ViewUserPublicProfileInteractor interactor = new ViewUserPublicProfileInteractor(gateway, presenter);
        ViewUserPublicProfileRequestModel requestModel = new ViewUserPublicProfileRequestModel("John");

        RuntimeException thrown = Assertions.assertThrows(RuntimeException.class, () -> {
            interactor.showUserProfile(requestModel);
        });
        Assertions.assertEquals(InteractorMessages.USER_DOES_NOT_EXIST, thrown.getMessage());
    }
}
