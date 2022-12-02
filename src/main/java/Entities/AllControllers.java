package Entities;

import UserSignupLoginScreens.LoginController;
import UserSignupLoginScreens.UserRegistrationController;

/**
 * singleton class containing all controllers made.
 * used for passing controllers around in screen creation.
 */
public class AllControllers {
    private static AllControllers allControllers = null;

    /**
     * collection of controllers
     */

    private LoginController loginController;
    private UserRegistrationController userRegistrationController;

    private AllControllers(){}
    public static AllControllers getInstance(){

        if (allControllers == null){
            allControllers = new AllControllers();
        }
        return allControllers;
    }

    /**
     * methods for setting controllers for different use cases
     */

    public void setLoginController(LoginController controller){
        loginController = controller;
    }
    public void setUserRegistrationController(UserRegistrationController controller){
        userRegistrationController = controller;
    }

    public LoginController getLoginController() {
        return loginController;
    }

    public UserRegistrationController getUserRegistrationController() {
        return userRegistrationController;
    }
}
