package use_cases.user_registration_use_case;

import entities.NormalUser;
import entities.User;
import entities.UserPublicProfile;

/**
 * A user factory that specifically creates a normal user
 */

public class NormalUserFactory implements UserFactory {
    @Override
    public User create(String username, String password, String name, String email, UserPublicProfile publicProfile) {
        return new NormalUser(username, password, name, email, publicProfile);
    }

    @Override
    public boolean checkValidPassword(String password) {
        return password.length() > 5;
    }
}
