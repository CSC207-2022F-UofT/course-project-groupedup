package UserSignupLoginScreens;

import UserRegistrationUsecase.UserRegistrationInputBoundary;
import UserRegistrationUsecase.UserRegistrationInputPackage;

public class UserRegistrationController {
    UserRegistrationInputBoundary userRegistrationInputBoundary;

    public UserRegistrationController(UserRegistrationInputBoundary userRegistrationInputBoundary){
        this.userRegistrationInputBoundary = userRegistrationInputBoundary;
    }
    public void create(String username, String password, String repeatPassword, String name, String email){
        this.userRegistrationInputBoundary.create(new UserRegistrationInputPackage(name, username, password,
                repeatPassword, email));
    }
}
