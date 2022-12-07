package interface_adapters.login_adapters;

/**
 * Interface for the screen used for displaying user log in screen
 */

public interface LoginScreenInterface {
    void switchScreen(String screenName);
    void setView(LoginController controller);
    void resetFields();
}
