package edit_user_public_profile_usecase;

public interface EditUserPublicProfileOutputBoundary {
        /**
         *
         * @param EditedChanges This is the newly edited changes for the user public profile.
         * @return the edit user public profile response model.
         */
        EditUserPublicProfileResponseModel prepareSuccessView(EditUserPublicProfileResponseModel EditedChanges);

        /**
         * Method to prepare fail view. Instead of throwing an error, it sends the failed changes again so the
         * user can retry resubmitting their user public profile.
         * @param FailedChanges the incorrect changes the user made.
         * @return the edit user public profile response model with the failed changes.
         */
        EditUserPublicProfileResponseModel prepareFailView(EditUserPublicProfileResponseModel FailedChanges);
}
