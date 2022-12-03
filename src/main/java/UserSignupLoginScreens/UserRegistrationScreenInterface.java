package UserSignupLoginScreens;

/**
 * Interface for the screen used for displaying user registration screen
 */

public interface UserRegistrationScreenInterface {
    public void switchScreen(String screenName);
    public void setView(UserRegistrationController controller);
    public void resetFields();
}
