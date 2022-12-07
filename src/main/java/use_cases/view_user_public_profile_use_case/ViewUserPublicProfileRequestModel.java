package use_cases.view_user_public_profile_use_case;

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
