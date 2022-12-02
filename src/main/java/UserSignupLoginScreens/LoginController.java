package UserSignupLoginScreens;

import userloginusecase.LoginInputBoundary;
import userloginusecase.LoginInputPackage;

public class LoginController {
    LoginInputBoundary loginInputBoundary;

    public LoginController(LoginInputBoundary loginInputBoundary){
        this.loginInputBoundary = loginInputBoundary;
    }
    public void login(LoginInputPackage inputPackage){
        this.loginInputBoundary.login(inputPackage);
    }
}
