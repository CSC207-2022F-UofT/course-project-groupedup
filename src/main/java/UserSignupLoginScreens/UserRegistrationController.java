package UserSignupLoginScreens;

import UserRegistrationUsecase.UserRegistrationInputBoundary;
import UserRegistrationUsecase.UserRegistrationInputPackage;
/**
 * controller for the user registration use case
 */
public class UserRegistrationController {
    UserRegistrationInputBoundary userRegistrationInputBoundary;

    public UserRegistrationController(UserRegistrationInputBoundary userRegistrationInputBoundary){
        this.userRegistrationInputBoundary = userRegistrationInputBoundary;
    }
    public void create(UserRegistrationInputPackage inputPackage){
        this.userRegistrationInputBoundary.create(inputPackage);
    }
}
