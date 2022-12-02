package UserRegistrationUsecase;


public interface UserRegistrationOutputBoundary {
    void prepareSuccessView(UserRegistrationOutputPackage userPackage);

    void prepareFailView(String error);
}
