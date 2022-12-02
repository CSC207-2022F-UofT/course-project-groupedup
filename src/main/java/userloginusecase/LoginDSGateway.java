package userloginusecase;

import Entities.User;

/**
 * Request data access to check if user's inputted username and password have a match in file
 */

public interface LoginDSGateway {
    public boolean userIdentifiersMatch(String username, String password);
    public User getUser(String username);
}
