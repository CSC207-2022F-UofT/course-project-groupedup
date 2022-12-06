package controllers_presenters_and_screen_boundaries.edit_user_public_profile_adapters;
import use_cases.edit_user_public_profile_use_case.EditUserPublicProfileRequestModel;
import use_cases.edit_user_public_profile_use_case.EditUserPublicProfileInputBoundary;

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
