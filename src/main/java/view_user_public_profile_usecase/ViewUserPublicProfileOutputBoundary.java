package view_user_public_profile_usecase;

public interface ViewUserPublicProfileOutputBoundary {
    /**
     *
     * @param viewUserProfileResponse has the user's public profile information.
     * @return A view user public profile response model.
     */
    ViewUserPublicProfileResponseModel prepareSuccessView(ViewUserPublicProfileResponseModel viewUserProfileResponse);
    ViewUserPublicProfileResponseModel prepareFailView(String message);
}
