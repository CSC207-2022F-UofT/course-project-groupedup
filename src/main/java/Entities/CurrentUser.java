package Entities;
import Entities.User;

/**
 * Singleton Class of the current user of the application.
 */
public class CurrentUser {
    private static CurrentUser currentUser;
    private static User user;

    private CurrentUser(){}
    public static CurrentUser getInstance(){

        if (currentUser == null){
            currentUser = new CurrentUser();
        }
        return currentUser;
    }
    public static void setUser(User newUser){
        user = newUser;
    }
    public static User getUser(){
        return user;
    }

}
