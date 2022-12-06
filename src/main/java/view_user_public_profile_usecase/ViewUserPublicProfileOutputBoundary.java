package view_user_public_profile_usecase;

public interface ViewUserPublicProfileOutputBoundary {
    /**
     *
     * @param viewUserProfileResponse has the user's public profile information.
     */
    void prepareSuccessView(ViewUserPublicProfileResponseModel viewUserProfileResponse);
}
