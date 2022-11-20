package edit_user_public_profile_screens;
import edit_user_public_profile_usecase.EditUserPublicProfileResponseModel;
import edit_user_public_profile_usecase.EditUserPublicProfileRequestModel;
import edit_user_public_profile_usecase.EditUserPublicProfileInputBoundary;

public class EditUserPublicProfileController {
    final EditUserPublicProfileInputBoundary userInput;

    public EditUserPublicProfileController(EditUserPublicProfileInputBoundary profileGateway) {
        this.userInput = profileGateway;
    }

    EditUserPublicProfileResponseModel editedChanges(String username, String bio, String courseCode,
                                                     String timeCommitment, String location, String meetingTime) {
        EditUserPublicProfileRequestModel requestModel = new EditUserPublicProfileRequestModel(username,
                bio, courseCode, timeCommitment, location, meetingTime);

        return userInput.saveEdits(requestModel);
    }
}
