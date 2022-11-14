package edit_public_profile_usecase;

import Entities.NormalUser;

public class editPublicProfileInteractor implements editPublicProfileInputBoundary{
    final editPublicProfileDSGateway profileDSGateway;
    final editPublicProfilePresenter profilePresenter;
    final String username;

    public editPublicProfileInteractor(String username, editPublicProfileDSGateway profileDSGateway, editPublicProfilePresenter profilePresenter) {
        this.username = username;
        this.profileDSGateway = profileDSGateway;
        this.profilePresenter = profilePresenter;
    }

    @Override
    public editPublicProfileResponseModel saveEdits(editPublicProfileRequestModel requestModel) {
        /*Creating a failed response model*/
        editPublicProfileResponseModel profileFailedResponseModel = new editPublicProfileResponseModel(
                requestModel.getPreferences(),
                requestModel.getBio(), "");

        /*Returning a failed view when preferences is left blank*/
        for (String p: requestModel.getPreferences().values()) {
            if (p.equals("")) {
                profileFailedResponseModel.setMessage("Preferences is left blank.");
                return profilePresenter.prepareFailView(profileFailedResponseModel);
            }
        }

        /*Returning a failed view when profile bio is left blank*/
        if (requestModel.getBio().equals("")) {
            profileFailedResponseModel.setMessage("Biography was left blank.");
            return profilePresenter.prepareFailView(profileFailedResponseModel);
        }

        /*Set user's profile and saving user*/
        if (profileDSGateway.existsByUsername(this.username)) {
            NormalUser user = profileDSGateway.findUser(this.username);
            user.getUserPublicProfile().setPreferences(requestModel.getPreferences());
            user.getUserPublicProfile().setBiography(requestModel.getBio());
            //TODO: save user in repo
        } else {
            /*If the user is not found.*/
            profileFailedResponseModel.setMessage("User was not found. Please log back in.");
            return profilePresenter.prepareFailView(profileFailedResponseModel);
        }

        /*If all checks pass, send new changes back to presenter.*/
        editPublicProfileResponseModel profileResponseModel = new editPublicProfileResponseModel(
                requestModel.getPreferences(),
                requestModel.getBio(), "Edits successfully saved.");

        return profilePresenter.prepareSuccessView(profileResponseModel);
    }
}