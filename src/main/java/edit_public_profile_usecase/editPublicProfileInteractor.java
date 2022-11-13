package edit_public_profile_usecase;
import Entities.User;

public class editPublicProfileInteractor implements editPublicProfileInputBoundary{
    final editPublicProfileDSGateway profileDSGateway;
    final editPublicProfilePresenter profilePresenter;

    public editPublicProfileInteractor(editPublicProfileDSGateway profileDSGateway, editPublicProfilePresenter profilePresenter) {
        this.profileDSGateway = profileDSGateway;
        this.profilePresenter = profilePresenter;
    }

    @Override
    public editPublicProfileResponseModel create(editPublicProfileRequestModel requestModel) {
        editPublicProfileResponseModel profileResponseModel = new editPublicProfileResponseModel(requestModel.getPreferences(), requestModel.getBio())

        /*Pass or fail message (I don't know if we want to let them leave their preferences blank or not)*/
        if (!requestModel.getBio().equals("")) {
            return profilePresenter.prepareSuccessView(profileResponseModel);
        } else {
            return profilePresenter.prepareFailView("Edits were unsuccessful");
        }
    }
}