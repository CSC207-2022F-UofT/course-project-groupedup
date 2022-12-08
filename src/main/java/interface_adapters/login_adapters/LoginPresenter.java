package interface_adapters.login_adapters;

import use_cases.user_login_use_case.LoginOutputBoundary;

import javax.swing.*;

/**
 * presenter for the login use case
 */

public class LoginPresenter implements LoginOutputBoundary {
    private LoginScreenInterface loginScreen;
    public LoginPresenter(LoginScreenInterface loginScreen){
        this.loginScreen = loginScreen;
    }

    @Override
    public void prepareSuccessView(String username) {
        JOptionPane.showMessageDialog(null, "You are logged in :^)");
        /*
         * go to the screen for homepage, the screen name is "homepage"
         */
        this.loginScreen.switchScreen("homepage");
    }

    @Override
    public void prepareFailView(String error) {
        JOptionPane.showMessageDialog(null, "Incorrect/not matching credentials");
        this.loginScreen.resetFields();
    }
}
