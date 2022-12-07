package interface_adapters.logout_adapters;

import use_cases.user_logout_use_case.LogoutOutputBoundary;

/**
 * presenter for the login use case
 */

public class LogoutPresenter implements LogoutOutputBoundary {
    @Override
    public void prepareSuccessView() {
        // ui("you are logged out");
    }
}
