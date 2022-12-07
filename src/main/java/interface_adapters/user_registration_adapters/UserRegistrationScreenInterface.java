package interface_adapters.user_registration_adapters;

/**
 * Interface for the screen used for displaying user registration screen
 */

public interface UserRegistrationScreenInterface {
    void switchScreen(String screenName);
    void setView(UserRegistrationController controller);
    void resetFields();
}
