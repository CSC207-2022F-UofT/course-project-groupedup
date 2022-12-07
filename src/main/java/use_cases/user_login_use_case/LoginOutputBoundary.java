package use_cases.user_login_use_case;

/**
 * interface for the controllers the login interactor can talk to
 */
public interface LoginOutputBoundary {
    void prepareSuccessView();

    void prepareFailView(String error);
}
