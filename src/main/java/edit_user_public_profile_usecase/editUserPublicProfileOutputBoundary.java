package edit_user_public_profile_usecase;

public interface editUserPublicProfileOutputBoundary {
        editUserPublicProfileResponseModel prepareSuccessView(editUserPublicProfileResponseModel EditedChanges);

        editUserPublicProfileResponseModel prepareFailView(editUserPublicProfileResponseModel FailedChanges);
}
