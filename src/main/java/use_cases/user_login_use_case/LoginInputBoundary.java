package use_cases.user_login_use_case;

/**
 * an interface for all types of interactors for the login use case
 */
public interface LoginInputBoundary {
    void login(LoginInputPackage userInput);
}
