package UserSignupLoginScreens;

import UserRegistrationUsecase.UserRegistrationOutputBoundary;
import UserRegistrationUsecase.UserRegistrationOutputPackage;

/**
 * presenter for user registration use case
 */
public class UserRegistrationPresenter implements UserRegistrationOutputBoundary {
    @Override
    public void prepareSuccessView(UserRegistrationOutputPackage userPackage) {
        //UI.show("this new user is made...")
    }

    @Override
    public void prepareFailView(String error) {
        //UI.show("you messed up by" + error);
    }
}
