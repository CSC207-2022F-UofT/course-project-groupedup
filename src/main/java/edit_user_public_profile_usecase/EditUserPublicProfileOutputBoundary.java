package edit_user_public_profile_usecase;

public interface EditUserPublicProfileOutputBoundary {
        EditUserPublicProfileResponseModel prepareSuccessView(EditUserPublicProfileResponseModel EditedChanges);

        EditUserPublicProfileResponseModel prepareFailView(EditUserPublicProfileResponseModel FailedChanges);
}
