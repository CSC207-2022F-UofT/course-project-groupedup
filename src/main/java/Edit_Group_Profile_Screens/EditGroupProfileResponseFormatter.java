package Edit_Group_Profile_Screens;
import Edit_Group_Profile_Use_Case.EditGroupProfilePresenter;
import Edit_Group_Profile_Use_Case.EditGroupProfileResponseModel;

public class EditGroupProfileResponseFormatter implements EditGroupProfilePresenter {
    @Override
    public EditGroupProfileResponseModel prepareSuccessView(EditGroupProfileResponseModel EditedChanges) {
        return EditedChanges;
    }

    @Override
    public EditGroupProfileResponseModel prepareFailView(EditGroupProfileResponseModel FailedChanges) {
        return FailedChanges;
    }
}
