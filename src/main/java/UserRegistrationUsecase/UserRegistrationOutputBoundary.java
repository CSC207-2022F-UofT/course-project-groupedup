package UserRegistrationUsecase;
/**
 * an interface for all types of presenter the user registration interactor can talk to
 */
public interface UserRegistrationOutputBoundary {
    void prepareSuccessView(UserRegistrationOutputPackage userPackage);

    void prepareFailView(String error);
}
