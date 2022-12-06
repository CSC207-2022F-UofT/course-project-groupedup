package signup_login_tests;

import entities.CurrentUser;
import entities.NormalUser;
import entities.User;
import entities.UserPublicProfile;
import UserSignupLoginScreens.LogoutController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import use_cases.user_logout_use_case.LogoutInteractor;
import use_cases.user_logout_use_case.LogoutOutputBoundary;

public class LogoutInteractorTest {
    @Test
    public void checkUserProperlyLoggedOut(){
        CurrentUser currentUser = CurrentUser.getInstance();
        String testUsername = "test1";
        String password = "password";
        if (currentUser.getUser() != null){
            currentUser.deleteUser();
        }
        LogoutOutputBoundary presenter = new LogoutOutputBoundary() {
            @Override
            public void prepareSuccessView() {
                Assertions.assertNull(currentUser.getUser());
            }
        };
        User newTestUser = new NormalUser(testUsername, password, "testName", "email",
                new UserPublicProfile());
        currentUser.setUser(newTestUser);
        LogoutInteractor testInteractor = new LogoutInteractor(presenter);
        LogoutController testController = new LogoutController(testInteractor);
        testController.logout();
    }
}
