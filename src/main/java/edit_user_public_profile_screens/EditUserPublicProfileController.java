package edit_user_public_profile_screens;
import edit_user_public_profile_usecase.EditUserPublicProfileRequestModel;
import edit_user_public_profile_usecase.EditUserPublicProfileInputBoundary;

/**
 * Edit user public profile controller.
 */
public class EditUserPublicProfileController {
    final EditUserPublicProfileInputBoundary editUserProfileInput;

    public EditUserPublicProfileController(EditUserPublicProfileInputBoundary editUserProfileInput) {
        this.editUserProfileInput = editUserProfileInput;
    }

    /**
     *
     * @param username username of the user
     * @param bio new bio user wants to save
     * @param courseCode new course code user wants to save
     * @param timeCommitment new time commitment preference user wants to save
     * @param location new location preference user wants to save
     * @param meetingTime new meeting time preference user wants to save
     */
    public void editedChanges(String username, String bio, String courseCode,
                                                     String timeCommitment, String location, String meetingTime) {

        EditUserPublicProfileRequestModel requestModel = new EditUserPublicProfileRequestModel(username,
                bio, courseCode, timeCommitment, location, meetingTime);

        editUserProfileInput.saveEdits(requestModel);
    }
}