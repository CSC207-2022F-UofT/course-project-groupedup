package use_cases.edit_user_public_profile_use_case;

import entities.User;

/**
 * This is a a request model for the database.
 */
public class EditUserPublicProfileDSRequestModel {
    private final String username;
    private final User user;

    public EditUserPublicProfileDSRequestModel(String username, User user) {
        this.username = username;
        this.user = user;
    }

    public User getUser() {
        return this.user;
    }

    public String getUsername() {
        return this.username;
    }
}
