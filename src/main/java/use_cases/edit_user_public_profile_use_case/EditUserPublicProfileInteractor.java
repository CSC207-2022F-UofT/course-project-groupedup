package use_cases.edit_user_public_profile_use_case;

import entities.InteractorMessages;
import entities.User;

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
     * Save edits allows the user to update their public profile.
     * @param requestModel the request model for the edit user's public profile use case.
     */
    @Override
    public void saveEdits(EditUserPublicProfileRequestModel requestModel) {
        boolean failed = false;
        /*Returning a failed view when preferences are left blank*/
        for (String p: requestModel.getPreferences().values()) {
            if (p.equals("")) {
                profileOutputBoundary.prepareFailView(InteractorMessages.PREFERENCES_BLANK);
                failed = true;
            }
        }

        /*Returning a failed view when course preferences are left blank*/
        if (requestModel.getCoursePreferences().equals("")) {
            profileOutputBoundary.prepareFailView(InteractorMessages.COURSE_PREFERENCES_BLANK);
            failed = true;
        }

        /*Returning a failed view when profile bio is left blank*/
        if (requestModel.getBio().equals("")) {
            profileOutputBoundary.prepareFailView(InteractorMessages.BIO_BLANK);
            failed = true;
        }


        /*If all checks pass, find User to save new edits*/
        if (!failed) {
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
                        InteractorMessages.EDITS_SUCCESSFUL);

                profileOutputBoundary.prepareSuccessView(profileResponseModel);

            } else {
                /*If the user is not found.*/
                profileOutputBoundary.prepareFailView(InteractorMessages.USER_DOES_NOT_EXIST);
            }
        }
    }
}