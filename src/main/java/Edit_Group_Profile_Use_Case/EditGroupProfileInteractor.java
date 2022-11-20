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
        EditGroupProfileResponseModel editFailResponseModel =
                new EditGroupProfileResponseModel(requestModel.getPreferences(), requestModel.getDescription(), "");

        if (!requestModel.setCourseCode(requestModel.getCourseCode())) {
            editFailResponseModel.setError("Invalid Course Code Entered.");
            return profilePresenter.prepareFailView(editFailResponseModel);
        }

        if (!requestModel.setMeetingTime(requestModel.getMeetingTime())) {
            editFailResponseModel.setError("Invalid Meeting Time Entered.");
            return profilePresenter.prepareFailView(editFailResponseModel);
        }


        EditGroupProfileDsRequestModel profileDsModel = new EditGroupProfileDsRequestModel(requestModel.getGroupName());
        profileDSGateway.saveGroupProfile(profileDsModel);

        EditGroupProfileResponseModel profileResponseModel = new EditGroupProfileResponseModel(
                requestModel.getPreferences(),
                requestModel.getDescription(),
                "");

        return profilePresenter.prepareSuccessView(profileResponseModel);
    }
}