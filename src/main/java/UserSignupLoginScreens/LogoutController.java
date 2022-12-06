package UserSignupLoginScreens;


import use_cases.user_logout_use_case.LogoutInputBoundary;
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
