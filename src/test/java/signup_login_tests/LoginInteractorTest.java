package signup_login_tests;

import entities.CurrentUser;
import entities.NormalUser;
import entities.User;
import entities.UserPublicProfile;
import use_cases.user_registration_use_case.UserRegistrationDSRequestPackage;
import controllers_presenters_and_screen_boundaries.login_adapters.LoginController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import use_cases.user_login_use_case.LoginInputPackage;
import use_cases.user_login_use_case.LoginInteractor;
import use_cases.user_login_use_case.LoginOutputBoundary;

public class LoginInteractorTest {
    @Test
    public void checkUserCredentialsDoNotMatch(){
        CurrentUser currentUser = CurrentUser.getInstance();
        InMemoryUserLoginRegistrationDataAccess dsGateway = new InMemoryUserLoginRegistrationDataAccess();
        String testUsername1 = "test1";
        String testUsername2 = "test2";
        String password = "password";
        if (currentUser.getUser() != null){
            currentUser.deleteUser();
        }
        LoginOutputBoundary presenter = new LoginOutputBoundary() {
            @Override
            public void prepareSuccessView() {
                Assertions.fail("Use case failure is unexpected.");
            }

            @Override
            public void prepareFailView(String error) {
                Assertions.assertNull(currentUser.getUser());
            }
        };
        User newTestUser = new NormalUser(testUsername1, password, "testName", "email",
                new UserPublicProfile());
        UserRegistrationDSRequestPackage dsRequestPackage =
                new UserRegistrationDSRequestPackage(newTestUser, testUsername1);
        dsGateway.saveNewUser(dsRequestPackage);
        LoginInteractor testInteractor = new LoginInteractor(dsGateway, presenter);
        // for testing wrong credentials
        LoginInputPackage test1 = new LoginInputPackage(testUsername2, password);
        // for testing user with usename is not found in data access
        LoginInputPackage test2 = new LoginInputPackage(testUsername2, password);
        LoginController testController = new LoginController(testInteractor);
        testController.login(test1);
        testController.login(test2);
    }
    @Test
    public void checkUserProperlyLoggedIn(){
        CurrentUser currentUser = CurrentUser.getInstance();
        InMemoryUserLoginRegistrationDataAccess dsGateway = new InMemoryUserLoginRegistrationDataAccess();
        String testUsername = "test1";
        String password = "password";
        if (currentUser.getUser() != null){
            currentUser.deleteUser();
        }
        LoginOutputBoundary presenter = new LoginOutputBoundary() {
            @Override
            public void prepareSuccessView() {
                Assertions.assertEquals(currentUser.getUser().getUsername(), testUsername);
            }

            @Override
            public void prepareFailView(String error) {
                Assertions.fail("Use case failure is unexpected.");
            }
        };
        User newTestUser = new NormalUser(testUsername, password, "testName", "email",
                new UserPublicProfile());
        UserRegistrationDSRequestPackage dsRequestPackage =
                new UserRegistrationDSRequestPackage(newTestUser, testUsername);
        dsGateway.saveNewUser(dsRequestPackage);
        LoginInteractor testInteractor = new LoginInteractor(dsGateway, presenter);
        LoginController testController = new LoginController(testInteractor);
        LoginInputPackage test1 = new LoginInputPackage(testUsername, password);
        testController.login(test1);
    }
}
