package view_user_public_profile_screens;
import view_user_public_profile_usecase.viewUserPublicProfileOutputBoundary;
import view_user_public_profile_usecase.viewUserPublicProfileResponseModel;


public class viewUserPublicProfilePresenter implements viewUserPublicProfileOutputBoundary {
    @Override
    public viewUserPublicProfileResponseModel prepareSuccessView(viewUserPublicProfileResponseModel userPublicProfileInfo) {
        return userPublicProfileInfo;
    }

    @Override
    public String prepareFailView(String message) {
        return null;
    }
}
