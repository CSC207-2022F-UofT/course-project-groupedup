package controllers_presenters_and_screen_boundaries.user_registration_adapters;

/**
 * Interface for the screen used for displaying user registration screen
 */

public interface UserRegistrationScreenInterface {
    public void switchScreen(String screenName);
    public void setView(UserRegistrationController controller);
    public void resetFields();
}
