package UserSignupLoginScreens;

/**
 * Interface for the screen used for displaying user log in screen
 */

public interface LoginScreenInterface {
    public void switchScreen(String screenName);
    public void setView(LoginController controller);
    public void resetFields();
}
