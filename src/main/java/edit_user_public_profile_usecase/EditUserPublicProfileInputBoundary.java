package edit_user_public_profile_usecase;

/**
 * This is the input boundary for the edit user public profile use case.
 */
public interface EditUserPublicProfileInputBoundary {
    /**
     * Save edits is a method that will allow the user to save their new changes. Implemented by the use case.
     * @param requestModel The request model for the edit user public profile. Bundles the data necessary for the profile.
     */
    void saveEdits(EditUserPublicProfileRequestModel requestModel);
}
