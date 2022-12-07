package use_cases.view_user_public_profile_use_case;

public interface ViewUserPublicProfileOutputBoundary {
    /**
     *Method is called to when use case has successfully passed.
     * @param viewUserProfileResponse has the user's public profile information.
     */
    void prepareSuccessView(ViewUserPublicProfileResponseModel viewUserProfileResponse);
}
