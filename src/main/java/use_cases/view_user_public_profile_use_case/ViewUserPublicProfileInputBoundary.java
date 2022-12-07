package use_cases.view_user_public_profile_use_case;

public interface ViewUserPublicProfileInputBoundary {
    /**
     * Input boundary implemented by the view public profile use case.
     * @param requestModel This is the request model for the view user public profile. This holds the username.
     */
    void showUserProfile(ViewUserPublicProfileRequestModel requestModel);
}
