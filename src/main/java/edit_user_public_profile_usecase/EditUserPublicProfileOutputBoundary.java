package edit_user_public_profile_usecase;

public interface EditUserPublicProfileOutputBoundary {
        /**
         *
         * @param EditedChanges This is the newly edited changes for the user public profile.
         */
        void prepareSuccessView(EditUserPublicProfileResponseModel EditedChanges);

        /**
         * Method to prepare fail view. Instead of throwing an error, it sends the failed changes again so the
         * user can retry resubmitting their user public profile.
         * @param error string explaining the error that is occurring.
         */
        void prepareFailView(String error);
}
