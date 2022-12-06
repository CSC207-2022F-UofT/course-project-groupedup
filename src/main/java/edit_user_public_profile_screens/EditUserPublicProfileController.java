package edit_user_public_profile_screens;
import edit_user_public_profile_usecase.EditUserPublicProfileRequestModel;
import edit_user_public_profile_usecase.EditUserPublicProfileInputBoundary;

public class EditUserPublicProfileController {
    final EditUserPublicProfileInputBoundary editUserProfileInput;

    public EditUserPublicProfileController(EditUserPublicProfileInputBoundary editUserProfileInput) {
        this.editUserProfileInput = editUserProfileInput;
    }

    public void editedChanges(String username, String bio, String courseCode,
                                                     String timeCommitment, String location, String meetingTime) {

        EditUserPublicProfileRequestModel requestModel = new EditUserPublicProfileRequestModel(username,
                bio, courseCode, timeCommitment, location, meetingTime);

        editUserProfileInput.saveEdits(requestModel);
    }
}
