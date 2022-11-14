package Edit_Group_Profile_Use_Case;

public class EditGroupProfileInteractor implements EditGroupProfileInputBoundary {

    final EditGroupProfileDSGateway profileDSGateway;
    final EditGroupProfilePresenter profilePresenter;

    public EditGroupProfileInteractor(EditGroupProfileDSGateway profileDSGateway, EditGroupProfilePresenter profilePresenter) {
        this.profileDSGateway = profileDSGateway;
        this.profilePresenter = profilePresenter;
    }

    @Override
    public EditGroupProfileResponseModel create(EditGroupProfileRequestModel requestModel) {
        /*Pass or fail message (I don't know if we want to let them leave their preferences blank or not)*/
        if (requestModel.getDescription().equals("")) {
            return profilePresenter.prepareFailView("Edits were unsuccessful, profile description is empty.");
        }

        if (requestModel.setCourseCode(requestModel.getCourseCode()) == false) {
            return profilePresenter.prepareFailView("Edits were unsuccessful, course code is invalid.");
        }

        if (requestModel.setMeetingTime(requestModel.getMeetingTime()) == false) {
            return profilePresenter.prepareFailView("Edits were unsuccessful, meeting time is invalid (must be a day of the week).");
        }


        EditGroupProfileDsRequestModel profileDsModel = new EditGroupProfileDsRequestModel(requestModel.getGroupName());
        profileDSGateway.saveGroupProfile(profileDsModel);

        EditGroupProfileResponseModel profileResponseModel = new EditGroupProfileResponseModel(
                requestModel.getPreferences(),
                requestModel.getDescription());

        return profilePresenter.prepareSuccessView(profileResponseModel);
    }
}