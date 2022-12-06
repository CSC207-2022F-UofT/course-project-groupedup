package use_cases.view_user_public_profile_use_case;

public interface ViewUserPublicProfileOutputBoundary {
    /**
     *
     * @param viewUserProfileResponse has the user's public profile information.
     */
    void prepareSuccessView(ViewUserPublicProfileResponseModel viewUserProfileResponse);
    void prepareFailView(String message);
}
