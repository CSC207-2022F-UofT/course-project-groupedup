package signup_login_tests;

import entities.User;
import use_cases.user_registration_use_case.NewUserDSGateway;
import use_cases.user_registration_use_case.UserRegistrationDSRequestPackage;
import use_cases.user_login_use_case.LoginDSGateway;

import java.util.HashMap;

/**
 * dummy data access class for testing purposes
 * used for user registration, login, logout use cases
 */
public class InMemoryUserLoginRegistrationDataAccess implements NewUserDSGateway, LoginDSGateway {
    private HashMap<String, User> userMap = new HashMap<String, User>();
    @Override
    public void saveNewUser(UserRegistrationDSRequestPackage userDSRequestModel) {
        this.userMap.put(userDSRequestModel.getUsername(), userDSRequestModel.getUser());
    }

    @Override
    public HashMap<String, User> loadUsers() {
        return this.userMap;
    }

    @Override
    public boolean userIdentifierExists(String username) {
        return this.userMap.containsKey(username);
    }
    @Override
    public boolean userIdentifiersMatch(String username, String password) {
        if (!this.userMap.containsKey(username)) { return false; }
        return this.userMap.get(username).getPassword().equals(password);
    }

    @Override
    public User getUser(String username) {
        return this.userMap.get(username);
    }
}
