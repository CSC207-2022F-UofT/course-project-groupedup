package use_cases.user_registration_use_case;

import entities.User;
import entities.UserPublicProfile;

/**
 * Used to create a user
 */

public interface UserFactory {
    public User create(String username, String password, String name, String email,
                       UserPublicProfile publicProfile);
    public boolean checkValidPassword(String password);
}
