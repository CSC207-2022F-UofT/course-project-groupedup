package use_cases.user_login_use_case;

/**
 * interface for the controllers the login interactor can talk to
 */
public interface LoginOutputBoundary {
    void prepareSuccessView(String username);

    void prepareFailView(String error);
}
