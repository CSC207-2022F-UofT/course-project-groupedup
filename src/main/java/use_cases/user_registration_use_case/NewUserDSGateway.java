package use_cases.user_registration_use_case;

import entities.User;

import java.util.HashMap;

/**
 * gateway to data access for the user creation use case
 */
public interface NewUserDSGateway{
    public void saveNewUser(UserRegistrationDSRequestPackage userDSRequestModel);
    public HashMap<String, User> loadUsers();
    public boolean userIdentifierExists(String username);
}
