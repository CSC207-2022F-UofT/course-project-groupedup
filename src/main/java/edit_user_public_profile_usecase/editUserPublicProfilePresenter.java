package edit_user_public_profile_usecase;

public interface editUserPublicProfilePresenter {
        editUserPublicProfileResponseModel prepareSuccessView(editUserPublicProfileResponseModel EditedChanges);

        editUserPublicProfileResponseModel prepareFailView(editUserPublicProfileResponseModel FailedChanges);
}
