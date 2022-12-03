package UserSignupLoginScreens;


import userlogoutusecase.LogoutInputBoundary;
/**
 * controller for the logout use case
 */
public class LogoutController {
    LogoutInputBoundary logoutInputBoundary;

    public LogoutController(LogoutInputBoundary logoutInputBoundary){
        this.logoutInputBoundary = logoutInputBoundary;
    }
    public void logout(){
        this.logoutInputBoundary.logout();
    }
}
