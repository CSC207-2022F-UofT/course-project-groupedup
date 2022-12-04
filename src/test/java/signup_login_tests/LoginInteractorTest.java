package signup_login_tests;

import Entities.CurrentUser;
import Entities.NormalUser;
import Entities.User;
import Entities.UserPublicProfile;
import UserRegistrationUsecase.UserRegistrationDSRequestPackage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import userloginusecase.LoginDSGateway;
import userloginusecase.LoginInputPackage;
import userloginusecase.LoginInteractor;
import userloginusecase.LoginOutputBoundary;

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
        testInteractor.login(test1);
        testInteractor.login(test2);
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
        LoginInputPackage test1 = new LoginInputPackage(testUsername, password);
    }
}
