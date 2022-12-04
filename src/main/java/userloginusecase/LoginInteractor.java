package userloginusecase;

import Entities.CurrentUser;

/**
 * the interactor for logging in a user with user input credentials
 */
public class LoginInteractor implements LoginInputBoundary{
    final LoginDSGateway loginDSGateway;
    final LoginOutputBoundary loginOutputBoundary;

    public LoginInteractor(LoginDSGateway loginDSGateway, LoginOutputBoundary loginOutputBoundary){
        this.loginDSGateway = loginDSGateway;
        this.loginOutputBoundary = loginOutputBoundary;
    }

    @Override
    public void login(LoginInputPackage userInput) {
        if(!loginDSGateway.userIdentifiersMatch(userInput.getUsername(), userInput.getPassword())){
            loginOutputBoundary.prepareFailView("User credentials do not match, please try again.");
        } else{
            CurrentUser currentUser = CurrentUser.getInstance();
            currentUser.setUser(loginDSGateway.getUser(userInput.getUsername()));
            loginOutputBoundary.prepareSuccessView();
        }
    }
}
