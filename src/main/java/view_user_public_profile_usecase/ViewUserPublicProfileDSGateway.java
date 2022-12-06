package view_user_public_profile_usecase;

import Entities.User;

/**
 * Gateway to database which is used to find current user.
 */
public interface ViewUserPublicProfileDSGateway {
    User findUser(String username);
}
