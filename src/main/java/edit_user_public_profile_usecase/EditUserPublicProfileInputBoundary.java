package edit_user_public_profile_usecase;

/**
 * This is the input boundary for the edit user public profile use case.
 */
public interface EditUserPublicProfileInputBoundary {
    /**
     *
     * @param requestModel The request model for the edit user public profile. Bundles the data necessary for the profile.
     * @return returns the response model for the edit user public profile use case.
     */
    EditUserPublicProfileResponseModel saveEdits(EditUserPublicProfileRequestModel requestModel);
}
