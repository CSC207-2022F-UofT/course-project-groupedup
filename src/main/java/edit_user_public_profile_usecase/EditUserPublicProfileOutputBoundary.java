package edit_user_public_profile_usecase;

public interface EditUserPublicProfileOutputBoundary {
        /**
         *This method is used to prepare success view which is implemented by the presenter.
         * @param EditedChanges This is the newly edited changes for the user public profile.
         */
        void prepareSuccessView(EditUserPublicProfileResponseModel EditedChanges);

        /**
         * Method to prepare fail view which is implemented by the presenter.
         * @param error string explaining the error that is occurring.
         */
        void prepareFailView(String error);
}
