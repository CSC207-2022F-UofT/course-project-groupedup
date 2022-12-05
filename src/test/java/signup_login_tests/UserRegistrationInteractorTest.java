package signup_login_tests;

import Entities.NormalUser;
import Entities.User;
import Entities.UserPublicProfile;
import UserRegistrationUsecase.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * tests for the use case for user registration
 */

public class UserRegistrationInteractorTest {
    @Test
    public void checkPasswordNotMatching(){
        NewUserDSGateway dsGateway = new InMemoryUserLoginRegistrationDataAccess();
        String testUsername = "testing";
        String password = "password";
        String repeatPassword = "differentPassword";
        UserRegistrationInputPackage inputPackage =
                new UserRegistrationInputPackage("name", testUsername, password, repeatPassword, "email");
        UserFactory userFactory = new NormalUserFactory();
        UserRegistrationOutputBoundary presenter = new UserRegistrationOutputBoundary() {
            @Override
            public void prepareSuccessView(UserRegistrationOutputPackage userPackage) {
                Assertions.fail("Use case failure is unexpected.");
            }

            @Override
            public void prepareFailView(String error) {
                Assertions.assertFalse(dsGateway.userIdentifierExists(testUsername));
            }
        };
        UserRegistrationInteractor testInteractor = new UserRegistrationInteractor(userFactory, dsGateway, presenter);
        testInteractor.create(inputPackage);
    }
    @Test
    public void checkPasswordIsValid(){
        NewUserDSGateway dsGateway = new InMemoryUserLoginRegistrationDataAccess();
        String testUsername = "testing";
        String password = "aa";
        String repeatPassword = "aa";
        UserRegistrationInputPackage inputPackage =
                new UserRegistrationInputPackage("name", testUsername, password, repeatPassword, "email");
        UserFactory userFactory = new NormalUserFactory();
        UserRegistrationOutputBoundary presenter = new UserRegistrationOutputBoundary() {
            @Override
            public void prepareSuccessView(UserRegistrationOutputPackage userPackage) {
                Assertions.fail("Use case failure is unexpected.");
            }

            @Override
            public void prepareFailView(String error) {
                Assertions.assertFalse(dsGateway.userIdentifierExists(testUsername));
            }
        };
        UserRegistrationInteractor testInteractor = new UserRegistrationInteractor(userFactory, dsGateway, presenter);
        testInteractor.create(inputPackage);
    }
    @Test
    public void checkUsernameExists(){
        NewUserDSGateway dsGateway = new InMemoryUserLoginRegistrationDataAccess();
        String testUsername = "testing";
        String password = "password";
        String repeatPassword = "password";
        UserRegistrationInputPackage inputPackage =
                new UserRegistrationInputPackage("name", testUsername, password, repeatPassword, "email");
        UserFactory userFactory = new NormalUserFactory();
        UserRegistrationOutputBoundary presenter = new UserRegistrationOutputBoundary() {
            @Override
            public void prepareSuccessView(UserRegistrationOutputPackage userPackage) {
                Assertions.fail("Use case failure is unexpected.");
            }

            @Override
            public void prepareFailView(String error) {
                String testName = dsGateway.loadUsers().get(testUsername).getName();
                Assertions.assertNotEquals("name", testName);
                Assertions.assertEquals("testName", testName);
            }
        };
        UserRegistrationInteractor testInteractor = new UserRegistrationInteractor(userFactory, dsGateway, presenter);
        User newTestUser = new NormalUser(testUsername, password, "testName", "email",
                new UserPublicProfile());
        UserRegistrationDSRequestPackage dsRequestPackage =
                new UserRegistrationDSRequestPackage(newTestUser, testUsername);
        dsGateway.saveNewUser(dsRequestPackage);
        testInteractor.create(inputPackage);
    }
    @Test
    public void checkSuccess(){
        NewUserDSGateway dsGateway = new InMemoryUserLoginRegistrationDataAccess();
        String testUsername = "testing";
        String password = "password";
        String repeatPassword = "password";
        UserRegistrationInputPackage inputPackage =
                new UserRegistrationInputPackage("name", testUsername, password, repeatPassword, "email");
        UserFactory userFactory = new NormalUserFactory();
        UserRegistrationOutputBoundary presenter = new UserRegistrationOutputBoundary() {
            @Override
            public void prepareSuccessView(UserRegistrationOutputPackage userPackage) {
                Assertions.assertTrue(dsGateway.userIdentifierExists(testUsername));
            }

            @Override
            public void prepareFailView(String error) {
                Assertions.fail("Use case failure is unexpected.");
            }
        };
        UserRegistrationInteractor testInteractor = new UserRegistrationInteractor(userFactory, dsGateway, presenter);
        testInteractor.create(inputPackage);
    }
}