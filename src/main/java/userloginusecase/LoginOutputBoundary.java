package userloginusecase;

/**
 * interface for the controllers the login interactor can talk to
 */
public interface LoginOutputBoundary {
    void prepareSuccessView();

    void prepareFailView(String error);
}
