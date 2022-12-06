package use_cases.edit_user_public_profile_use_case;

/**
 * This is the input boundary for the edit user public profile use case.
 */
public interface EditUserPublicProfileInputBoundary {
    /**
     *
     * @param requestModel The request model for the edit user public profile. Bundles the data necessary for the profile.
     */
    void saveEdits(EditUserPublicProfileRequestModel requestModel);
}
