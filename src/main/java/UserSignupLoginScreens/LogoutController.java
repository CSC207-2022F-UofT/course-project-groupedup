package UserSignupLoginScreens;


import userlogoutusecase.LogoutInputBoundary;

public class LogoutController {
    LogoutInputBoundary logoutInputBoundary;

    public LogoutController(LogoutInputBoundary logoutInputBoundary){
        this.logoutInputBoundary = logoutInputBoundary;
    }
    public void logout(){
        this.logoutInputBoundary.logout();
    }
}
