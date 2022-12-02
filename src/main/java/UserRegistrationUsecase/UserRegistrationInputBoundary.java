package UserRegistrationUsecase;

/**
 * input boundary interface for user registration use case
 */
public interface UserRegistrationInputBoundary {
    /**
     * create and register a user based on information in userInput
     */
    void create(UserRegistrationInputPackage userInput);
}
