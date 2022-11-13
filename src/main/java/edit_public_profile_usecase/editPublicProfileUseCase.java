package edit_public_profile_usecase;
import Entities.User;

import java.util.HashMap;

public class editPublicProfileUseCase {
    private final String userID;
    private final User user;
    private HashMap<String, String> newPreferences;

    public editPublicProfileUseCase(User user, HashMap<String, String> newPreferences, String userID) {
        this.user = user;
        this.newPreferences = newPreferences;
        this.userID = userID;
    }

    public void editPreferences() {
        /*Here I need to get the user entity from the userID but instead I just put the User entity will change later*/
        user.getPublicProfile().setPreferences(this.newPreferences);
    }
}
