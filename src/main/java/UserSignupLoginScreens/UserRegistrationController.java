package UserSignupLoginScreens;

import UserRegistrationUsecase.UserRegistrationInputBoundary;
import UserRegistrationUsecase.UserRegistrationInputPackage;

public class UserRegistrationController {
    UserRegistrationInputBoundary userRegistrationInputBoundary;

    public UserRegistrationController(UserRegistrationInputBoundary userRegistrationInputBoundary){
        this.userRegistrationInputBoundary = userRegistrationInputBoundary;
    }
    public void create(UserRegistrationInputPackage inputPackage){
        this.userRegistrationInputBoundary.create(inputPackage);
    }
}
