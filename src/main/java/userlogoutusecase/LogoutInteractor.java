package userlogoutusecase;

import Entities.CurrentUser;

/**
 *  simple logout use case instruction.
 *  No need to call on data access, only need to reset pointer for current user inside program.
 */

public class LogoutInteractor implements LogoutInputBoundary {
    final LogoutOutputBoundary logoutOutputBoundary;

    public LogoutInteractor(LogoutOutputBoundary logoutOutputBoundary){
        this.logoutOutputBoundary = logoutOutputBoundary;
    }

    @Override
    public void logout() {
        CurrentUser currentUser = CurrentUser.getInstance();
        currentUser.deleteUser();
        logoutOutputBoundary.prepareSuccessView();
    }
}
