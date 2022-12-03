package signup_login_tests;

import Entities.CurrentUser;
import Entities.NormalUser;
import Entities.User;
import Entities.UserPublicProfile;
import UserRegistrationUsecase.UserRegistrationDSRequestPackage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import userloginusecase.LoginInputPackage;
import userloginusecase.LoginInteractor;
import userloginusecase.LoginOutputBoundary;
import userlogoutusecase.LogoutInteractor;
import userlogoutusecase.LogoutOutputBoundary;

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
        testInteractor.logout();
    }
}
