package edit_user_public_profile_usecase;

import Entities.User;

/**
 * This interface is used to access the database to save and find user.
 */
public interface EditUserPublicProfileDSGateway {
    void updateUser(User user);
    User getUser(String username);
    boolean userIdentifierExists(String username);
}
