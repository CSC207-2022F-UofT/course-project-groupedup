package interface_adapters.logout_adapters;

import use_cases.user_logout_use_case.LogoutOutputBoundary;

import javax.swing.*;

/**
 * presenter for the login use case
 */

public class LogoutPresenter implements LogoutOutputBoundary {
    @Override
    public void prepareSuccessView() {
        JOptionPane.showMessageDialog(null, "Bye");
    }
}
