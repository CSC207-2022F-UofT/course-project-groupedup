package UserRegistrationUsecase;

import Entities.User;
import Entities.UserPublicProfile;

/**
 * Used to create a user
 */

public interface UserFactory {
    public User create(String username, String password, String name, String email,
                       UserPublicProfile publicProfile);
}
