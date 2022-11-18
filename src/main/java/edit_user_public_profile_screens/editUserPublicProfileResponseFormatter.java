package edit_user_public_profile_screens;
import edit_user_public_profile_usecase.editUserPublicProfilePresenter;
import edit_user_public_profile_usecase.editUserPublicProfileResponseModel;


public class editUserPublicProfileResponseFormatter implements editUserPublicProfilePresenter {
    @Override
    public editUserPublicProfileResponseModel prepareSuccessView(editUserPublicProfileResponseModel EditedChanges) {
        return EditedChanges;
    }

    @Override
    public editUserPublicProfileResponseModel prepareFailView(editUserPublicProfileResponseModel FailedChanges) {
        return FailedChanges;
    }
}
