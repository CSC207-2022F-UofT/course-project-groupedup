package view_user_public_profile_usecase;

public interface viewUserPublicProfileOutputBoundary {
    viewUserPublicProfileResponseModel prepareSuccessView(viewUserPublicProfileResponseModel viewUserProfileResponse);
    String prepareFailView(String message);
}
