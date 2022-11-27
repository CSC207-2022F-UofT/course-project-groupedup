package UserRegistrationUsecase;

import Entities.NormalUser;
import Entities.User;
import Entities.UserPublicProfile;

/**
 * A user factory that specifically creates a normal user
 */

public class NormalUserFactory implements UserFactory {
    @Override
    public User create(String username, String password, String name, String email, UserPublicProfile publicProfile) {
        return new NormalUser(username, password, name, email, publicProfile);
    }
}
