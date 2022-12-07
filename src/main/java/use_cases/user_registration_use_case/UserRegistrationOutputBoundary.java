package use_cases.user_registration_use_case;
/**
 * an interface for all types of presenter the user registration interactor can talk to
 */
public interface UserRegistrationOutputBoundary {
    void prepareSuccessView(UserRegistrationOutputPackage userPackage);

    void prepareFailView(String error);
}
