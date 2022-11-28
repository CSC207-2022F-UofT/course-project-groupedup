package view_user_public_profile_screens;
import view_user_public_profile_usecase.ViewUserPublicProfileOutputBoundary;
import view_user_public_profile_usecase.ViewUserPublicProfileResponseModel;


public class ViewUserPublicProfilePresenter implements ViewUserPublicProfileOutputBoundary {
    @Override
    public ViewUserPublicProfileResponseModel prepareSuccessView(ViewUserPublicProfileResponseModel userPublicProfileInfo) {
        return userPublicProfileInfo;
    }

    @Override
    public ViewUserPublicProfileResponseModel prepareFailView(String error) {
        throw new ViewUserPublicProfileFailed(error);
    }
}
