package view_user_public_profile_usecase;

public interface ViewUserPublicProfileInputBoundary {
    /**
     *
     * @param requestModel This is the request model for the view user public profile. This holds the username.
     * @return A view user public profile response model which holds the user's public profile information.
     */
    ViewUserPublicProfileResponseModel showUserProfile(ViewUserPublicProfileRequestModel requestModel);
}
