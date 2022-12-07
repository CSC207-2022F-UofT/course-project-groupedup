package controllers_presenters_and_screen_boundaries.login_adapters;

import controllers_presenters_and_screen_boundaries.login_adapters.LoginController;

/**
 * Interface for the screen used for displaying user log in screen
 */

public interface LoginScreenInterface {
    public void switchScreen(String screenName);
    public void setView(LoginController controller);
    public void resetFields();
}
