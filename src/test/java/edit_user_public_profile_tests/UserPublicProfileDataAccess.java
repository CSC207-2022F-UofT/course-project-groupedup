package edit_user_public_profile_tests;
import entities.User;
import use_cases.edit_user_public_profile_use_case.EditUserPublicProfileDSGateway;
import use_cases.view_user_public_profile_use_case.ViewUserPublicProfileDSGateway;

import java.util.HashMap;

/**
 * Simple imitation of SerializedDataAccess used only for the purpose of testing
 */
public class UserPublicProfileDataAccess implements EditUserPublicProfileDSGateway, ViewUserPublicProfileDSGateway {
    private final HashMap<String, User> userMap;

    public UserPublicProfileDataAccess(HashMap<String, User> userMap){
        this.userMap = userMap;
    }

    @Override
    public void updateUser(User user) {
        String username = user.getUsername();
        userMap.replace(username, user);
    }

    @Override
    public User getUser(String username) {
        return userMap.get(username);
    }

    @Override
    public boolean userIdentifierExists(String username) {
        return userMap.containsKey(username);
    }
}
