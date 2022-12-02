package UserSignupLoginScreens;

import userloginusecase.LoginInputPackage;
import userloginusecase.LoginOutputBoundary;

public class LoginPresenter implements LoginOutputBoundary {
    public LoginPresenter(){
    }

    public void loadControllers(){
    }
    @Override
    public void prepareSuccessView() {
        //UI.show("you are logged in")
    }

    @Override
    public void prepareFailView(String error) {
        new UserRegistrationScreen();
    }
}
