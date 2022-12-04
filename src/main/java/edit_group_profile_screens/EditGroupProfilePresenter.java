package edit_group_profile_screens;

import edit_group_profile_use_case.EditGroupProfileOutputBoundary;
import edit_group_profile_use_case.EditGroupProfileResponseModel;

public class EditGroupProfilePresenter implements EditGroupProfileOutputBoundary {
    EditGroupProfileScreenBoundary editGroupProfileScreenBoundary;

    public EditGroupProfilePresenter(EditGroupProfileScreenBoundary editGroupProfileScreenBoundary) {
        this.editGroupProfileScreenBoundary = editGroupProfileScreenBoundary;
    }

    /**
     *
     * @param editedChanges taakes the response model and presents it to the chosen UI
     * @return
     */
    @Override
    public void prepareSuccessView(EditGroupProfileResponseModel editedChanges) {
        this.editGroupProfileScreenBoundary.switchScreen(editedChanges.getEditedPreferences());
    }

    @Override
    public void prepareFailView(String error) {
        throw new EditGroupProfileFailed(error);
    }
}
