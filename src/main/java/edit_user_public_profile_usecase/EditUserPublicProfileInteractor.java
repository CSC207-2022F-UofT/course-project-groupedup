package edit_user_public_profile_usecase;

import Entities.User;

/**
 * The edit user's public profile use case.
 */
public class EditUserPublicProfileInteractor implements EditUserPublicProfileInputBoundary {
    final private EditUserPublicProfileDSGateway userDSGateway;
    final private EditUserPublicProfileOutputBoundary profileOutputBoundary;

    public EditUserPublicProfileInteractor(EditUserPublicProfileDSGateway userDSGateway,
                                           EditUserPublicProfileOutputBoundary profileOutputBoundary) {
        this.userDSGateway = userDSGateway;
        this.profileOutputBoundary = profileOutputBoundary;
    }

    /**
     *
     * @param requestModel the request model for the edit user's public profile use case.
     */
    @Override
    public void saveEdits(EditUserPublicProfileRequestModel requestModel) {
        /*Returning a failed view when preferences are left blank*/
        for (String p: requestModel.getPreferences().values()) {
            if (p.equals("")) {
                profileOutputBoundary.prepareFailView("Preferences was left blank.");
            }
        }

        /*Returning a failed view when preferences are left blank*/
        if (requestModel.getCoursePreferences().equals("")) {
            profileOutputBoundary.prepareFailView("Course preferences was left blank.");
        }

        /*Returning a failed view when profile bio is left blank*/
        if (requestModel.getBio().equals("")) {
            profileOutputBoundary.prepareFailView("Biography was left blank.");
        }


        /*If all checks fail, find User to save new edits*/
        if (userDSGateway.userIdentifierExists(requestModel.getUsername())) {
            User user = userDSGateway.getUser(requestModel.getUsername());

            user.getUserPublicProfile().setPreferences(requestModel.getPreferences());
            user.getUserPublicProfile().setCoursePreferences(requestModel.getCoursePreferences());
            user.getUserPublicProfile().setBiography(requestModel.getBio());

            userDSGateway.updateUser(user);

            /*Send new changes back to output boundary.*/
            EditUserPublicProfileResponseModel profileResponseModel = new EditUserPublicProfileResponseModel(
                    requestModel.getUsername(),
                    requestModel.getPreferences(),
                    requestModel.getCoursePreferences(),
                    requestModel.getBio(),
                    "Edits successfully saved.");

            profileOutputBoundary.prepareSuccessView(profileResponseModel);

        } else {
            /*If the user is not found.*/
            profileOutputBoundary.prepareFailView("User was not found. Please try logging in again.");
        }
    }
}