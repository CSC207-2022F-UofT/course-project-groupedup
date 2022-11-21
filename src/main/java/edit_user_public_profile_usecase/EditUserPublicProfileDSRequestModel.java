package edit_user_public_profile_usecase;

import Entities.User;

public class EditUserPublicProfileDSRequestModel {
    private String username;
    private User user;

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
