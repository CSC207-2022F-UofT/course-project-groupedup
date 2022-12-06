package UserSignupLoginScreens;

import use_cases.user_registration_use_case.UserRegistrationInputBoundary;
import use_cases.user_registration_use_case.UserRegistrationInputPackage;
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
