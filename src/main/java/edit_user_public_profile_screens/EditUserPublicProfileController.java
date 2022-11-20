package edit_user_public_profile_screens;
import edit_user_public_profile_usecase.editUserPublicProfileResponseModel;
import edit_user_public_profile_usecase.editUserPublicProfileRequestModel;
import edit_user_public_profile_usecase.editUserPublicProfileInputBoundary;

public class editUserPublicProfileController {
    final editUserPublicProfileInputBoundary userInput;

    public editUserPublicProfileController(editUserPublicProfileInputBoundary profileGateway) {
        this.userInput = profileGateway;
    }

    editUserPublicProfileResponseModel editedChanges(String username, String bio, String courseCode,
                                                     String timeCommitment, String location, String meetingTime) {
        editUserPublicProfileRequestModel requestModel = new editUserPublicProfileRequestModel(username,
                bio, courseCode, timeCommitment, location, meetingTime);

        return userInput.saveEdits(requestModel);
    }
}
