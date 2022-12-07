package interface_adapters.edit_user_public_profile_adapters;
import use_cases.edit_user_public_profile_use_case.EditUserPublicProfileOutputBoundary;
import use_cases.edit_user_public_profile_use_case.EditUserPublicProfileResponseModel;
import javax.swing.*;


public class EditUserPublicProfilePresenter implements EditUserPublicProfileOutputBoundary {
    EditUserPublicProfileScreenBoundary editUserProfileScreenBoundary;

    public EditUserPublicProfilePresenter(EditUserPublicProfileScreenBoundary editUserProfileScreenBoundary) {
        this.editUserProfileScreenBoundary = editUserProfileScreenBoundary;
    }

    /**
     *This method displays a success message when the edit user public profile use case passes.
     * @param EditedChanges This is the newly edited changes for the user public profile.
     */
    @Override
    public void prepareSuccessView(EditUserPublicProfileResponseModel EditedChanges) {
         String username = EditedChanges.getUsername();
         JOptionPane.showMessageDialog(null, "Edited " + username + "'s profile.");
    }

    /**
     * This method displays error message when the edit user public profile use case fails.
     * @param error string explaining the error that is occurring.
     */
    @Override
    public void prepareFailView(String error) {
        JOptionPane.showMessageDialog(null, error);
    }
}
