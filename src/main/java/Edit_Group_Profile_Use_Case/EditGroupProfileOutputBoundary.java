package Edit_Group_Profile_Use_Case;

public interface EditGroupProfileOutputBoundary {

    EditGroupProfileResponseModel prepareSuccessView(EditGroupProfileResponseModel newChanges);

    EditGroupProfileResponseModel prepareFailView(String error);
}
