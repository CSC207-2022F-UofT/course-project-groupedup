package edit_public_profile_usecase;

public interface editPublicProfilePresenter {
        editPublicProfileResponseModel prepareSuccessView(editPublicProfileResponseModel EditedChanges);

        editPublicProfileResponseModel prepareFailView(editPublicProfileResponseModel FailedChanges);
}
