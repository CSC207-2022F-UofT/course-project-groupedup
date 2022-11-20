package view_user_public_profile_usecase;

public interface ViewUserPublicProfileOutputBoundary {
    ViewUserPublicProfileResponseModel prepareSuccessView(ViewUserPublicProfileResponseModel viewUserProfileResponse);
    String prepareFailView(String message);
}
