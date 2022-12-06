package edit_user_public_profile_screens;
import edit_user_public_profile_usecase.EditUserPublicProfileOutputBoundary;
import edit_user_public_profile_usecase.EditUserPublicProfileResponseModel;
import javax.swing.*;


public class EditUserPublicProfilePresenter implements EditUserPublicProfileOutputBoundary {
    EditUserPublicProfileScreenBoundary editUserProfileScreenBoundary;

    public EditUserPublicProfilePresenter(EditUserPublicProfileScreenBoundary editUserProfileScreenBoundary) {
        this.editUserProfileScreenBoundary = editUserProfileScreenBoundary;
    }

    /**
     *
     * @param EditedChanges This is the newly edited changes for the user public profile.
     */
    @Override
    public void prepareSuccessView(EditUserPublicProfileResponseModel EditedChanges) {
         String username = EditedChanges.getUsername();
         JOptionPane.showMessageDialog(null, "Edited " + username + "'s profile.");
    }

    @Override
    public void prepareFailView(String error) {
        JOptionPane.showMessageDialog(null, error);
    }
}
