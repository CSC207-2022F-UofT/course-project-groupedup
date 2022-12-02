package UserRegistrationUsecase;

import Entities.User;

/**
 * data package sent to data access from user registration interactor
 */
public class UserRegistrationDSRequestPackage {
    private final User user;

    private final String username;


    public UserRegistrationDSRequestPackage(User user, String username){
        this.user = user;
        this.username = username;
    }

    public User getUser() {
        return this.user;
    }
    public String getUsername() {
        return this.username;
    }
}
