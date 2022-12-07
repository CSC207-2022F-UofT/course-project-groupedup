package controllers_presenters_and_screen_boundaries.login_adapters;

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
