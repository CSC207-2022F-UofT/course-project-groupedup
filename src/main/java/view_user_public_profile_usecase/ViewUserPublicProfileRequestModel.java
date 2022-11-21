package view_user_public_profile_usecase;

/**
 * Request model for the view user public profile.
 */
public class ViewUserPublicProfileRequestModel {
    private final String username;

    public ViewUserPublicProfileRequestModel(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
}
