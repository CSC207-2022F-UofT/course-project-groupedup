package UserSignupLoginScreens;

import use_cases.user_login_use_case.LoginInputBoundary;
import use_cases.user_login_use_case.LoginInputPackage;
/**
 * controller for the login use case
 */
public class LoginController {
    LoginInputBoundary loginInputBoundary;

    public LoginController(LoginInputBoundary loginInputBoundary){
        this.loginInputBoundary = loginInputBoundary;
    }
    public void login(LoginInputPackage inputPackage){
        this.loginInputBoundary.login(inputPackage);
    }
}
