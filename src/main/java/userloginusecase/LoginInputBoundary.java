package userloginusecase;

/**
 * an interface for all types of interactors for the login use case
 */
public interface LoginInputBoundary {
    void login(LoginInputPackage userInput);
}
