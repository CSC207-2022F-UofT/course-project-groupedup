package Entities;

/**
 * Singleton Class of the current user of the application
 * Keeps track which user is logged in
 * Initially the user stored in CurrentUser will be null, same when no one is logged in
 */
public class CurrentUser {
    private static CurrentUser currentUser = null;
    private User user;

    private CurrentUser(){}
    public static CurrentUser getInstance(){

        if (currentUser == null){
            currentUser = new CurrentUser();
        }
        return currentUser;
    }
    public void setUser(User newUser){
        user = newUser;
    }
    public void deleteUser(){
        user = null;
    }
    public User getUser(){
        return user;
    }

}
