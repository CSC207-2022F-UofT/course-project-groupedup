package UserSignupLoginScreens;

import UserRegistrationUsecase.UserRegistrationOutputBoundary;
import UserRegistrationUsecase.UserRegistrationOutputPackage;

import javax.swing.*;

/**
 * presenter for user registration use case
 */
public class UserRegistrationPresenter implements UserRegistrationOutputBoundary {
    private UserRegistrationScreenInterface registrationScreen;
    public UserRegistrationPresenter(UserRegistrationScreenInterface registrationScreen){
        this.registrationScreen = registrationScreen;
    }
    @Override
    public void prepareSuccessView(UserRegistrationOutputPackage userPackage) {
        JOptionPane.showMessageDialog(null,
                userPackage.getUsername() + " you are registered, welcome!");
        /*
          go to the screen for log in, named "login page"
         */
        this.registrationScreen.switchScreen("login page");
    }

    @Override
    public void prepareFailView(String error) {
        JOptionPane.showMessageDialog(null, error);
        this.registrationScreen.resetFields();
    }
}
