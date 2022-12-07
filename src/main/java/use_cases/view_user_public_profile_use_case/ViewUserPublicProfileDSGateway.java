package use_cases.view_user_public_profile_use_case;

import entities.User;

/**
 * Gateway to database which is used to find current user.
 */
public interface ViewUserPublicProfileDSGateway {
    boolean userIdentifierExists(String username);
    User getUser(String username);
}
