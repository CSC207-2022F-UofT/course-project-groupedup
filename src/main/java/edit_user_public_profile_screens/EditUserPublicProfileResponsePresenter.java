package edit_user_public_profile_screens;
import edit_user_public_profile_usecase.EditUserPublicProfileOutputBoundary;
import edit_user_public_profile_usecase.EditUserPublicProfileResponseModel;


public class EditUserPublicProfileResponsePresenter implements EditUserPublicProfileOutputBoundary {
    @Override
    public EditUserPublicProfileResponseModel prepareSuccessView(EditUserPublicProfileResponseModel EditedChanges) {
        return EditedChanges;
    }

    @Override
    public EditUserPublicProfileResponseModel prepareFailView(EditUserPublicProfileResponseModel FailedChanges) {
        return FailedChanges;
    }
}
