package Edit_Group_Profile_Screens;

import Edit_Group_Profile_Use_Case.EditGroupProfileOutputBoundary;
import Edit_Group_Profile_Use_Case.EditGroupProfileResponseModel;

public class EditGroupProfilePresenter implements EditGroupProfileOutputBoundary {
    @Override
    public EditGroupProfileResponseModel prepareSuccessView(EditGroupProfileResponseModel editedChanges) {
        return editedChanges;
    }

    @Override
    public EditGroupProfileResponseModel prepareFailView(String error) {
        throw new EditGroupProfileFailed(error);
    }
}
