package edit_public_profile_screens;
import edit_public_profile_usecase.editPublicProfilePresenter;
import edit_public_profile_usecase.editPublicProfileResponseModel;


public class editPublicProfileResponseFormatter implements editPublicProfilePresenter{
    @Override
    public editPublicProfileResponseModel prepareSuccessView(editPublicProfileResponseModel EditedChanges) {
        return EditedChanges;
    }

    @Override
    public editPublicProfileResponseModel prepareFailView(editPublicProfileResponseModel FailedChanges) {
        return FailedChanges;
    }
}
