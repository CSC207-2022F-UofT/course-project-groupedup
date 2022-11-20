package edit_user_public_profile_usecase;

import Entities.User;
import UserRegistrationUsecase.NewUserDSGateway;

/**
 * The edit user's public profile use case.
 */
public class editUserPublicProfileInteractor implements editUserPublicProfileInputBoundary {
    final private NewUserDSGateway userDSGateway;
    final private editUserPublicProfileOutputBoundary profileOutputBoundary;

    public editUserPublicProfileInteractor(NewUserDSGateway userDSGateway,
                                           editUserPublicProfileOutputBoundary profileOutputBoundary) {
        this.userDSGateway = userDSGateway;
        this.profileOutputBoundary = profileOutputBoundary;
    }

    /**
     *
     * @param requestModel the request model for the edit user's public profile use case.
     * @return the new edited changes to the public profile.
     */
    @Override
    public editUserPublicProfileResponseModel saveEdits(editUserPublicProfileRequestModel requestModel) {
        /*Creating a failed response model*/
        editUserPublicProfileResponseModel profileFailedResponseModel = new editUserPublicProfileResponseModel(
                requestModel.getPreferences(),
                requestModel.getCoursePreferences(),
                requestModel.getBio(),
                "");

        /*Returning a failed view when preferences are left blank*/
        for (String p: requestModel.getPreferences().values()) {
            if (p.equals("")) {
                profileFailedResponseModel.setMessage("Preferences was left blank.");
                return profileOutputBoundary.prepareFailView(profileFailedResponseModel);
            }
        }

        /*Returning a failed view when preferences are left blank*/
        if (requestModel.getCoursePreferences().equals("")) {
            profileFailedResponseModel.setMessage("Course preferences was left blank.");
            return profileOutputBoundary.prepareFailView(profileFailedResponseModel);
        }

        /*Returning a failed view when profile bio is left blank*/
        if (requestModel.getBio().equals("")) {
            profileFailedResponseModel.setMessage("Biography was left blank.");
            return profileOutputBoundary.prepareFailView(profileFailedResponseModel);
        }


        /*If all checks fail, find User to save new edits*/
        if (userDSGateway.userIdentifierExists(requestModel.getUsername())) {
            User user = userDSGateway.loadUsers().get(requestModel.getUsername());

            user.getUserPublicProfile().setPreferences(requestModel.getPreferences());
            user.getUserPublicProfile().setCoursePreferences(requestModel.getCoursePreferences());
            user.getUserPublicProfile().setBiography(requestModel.getBio());

            /*Send new changes back to output boundary.*/
            editUserPublicProfileResponseModel profileResponseModel = new editUserPublicProfileResponseModel(
                    requestModel.getPreferences(),
                    requestModel.getCoursePreferences(),
                    requestModel.getBio(),
                    "Edits successfully saved.");

            return profileOutputBoundary.prepareSuccessView(profileResponseModel);

        } else {
            /*If the user is not found.*/
            profileFailedResponseModel.setMessage("User was not found. Please try logging in again.");
            return profileOutputBoundary.prepareFailView(profileFailedResponseModel);
        }
    }
}