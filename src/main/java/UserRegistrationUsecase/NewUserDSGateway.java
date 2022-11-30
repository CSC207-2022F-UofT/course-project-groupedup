package UserRegistrationUsecase;

import Entities.User;
import UserRegistrationUsecase.UserRegistrationDSRequestPackage;
import UserRegistrationUsecase.UserRegistrationInputPackage;

import java.io.IOException;
import java.util.HashMap;

/**
 * gateway to data access for the user creation use case
 */
public interface NewUserDSGateway{
    public void saveNewUser(UserRegistrationDSRequestPackage userDSRequestModel);
    public HashMap<String, User> loadUsers();
    public boolean userIdentifierExists(String username);
}
