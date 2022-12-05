package UserSignupLoginScreens;

import userlogoutusecase.LogoutOutputBoundary;

/**
 * presenter for the login use case
 */

public class LogoutPresenter implements LogoutOutputBoundary {
    @Override
    public void prepareSuccessView() {
        // ui("you are logged out");
    }
}
