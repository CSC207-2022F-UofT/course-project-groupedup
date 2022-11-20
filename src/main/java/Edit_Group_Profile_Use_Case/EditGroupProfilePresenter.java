package Edit_Group_Profile_Use_Case;

public interface EditGroupProfilePresenter {

    EditGroupProfileResponseModel prepareSuccessView(EditGroupProfileResponseModel newChanges);

    EditGroupProfileResponseModel prepareFailView(EditGroupProfileResponseModel error);
}
