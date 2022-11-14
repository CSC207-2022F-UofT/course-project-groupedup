package edit_public_profile_screens;
import edit_public_profile_usecase.editPublicProfileResponseModel;
import edit_public_profile_usecase.editPublicProfileRequestModel;
import edit_public_profile_usecase.editPublicProfileInputBoundary;

public class editPublicProfileController {
    final editPublicProfileInputBoundary userInput;

    public editPublicProfileController(editPublicProfileInputBoundary profileGateway) {
        this.userInput = profileGateway;
    }

    editPublicProfileResponseModel editedChanges(String bio, String courseCode, String timeCommitment, String location, String meetingTime) {
        editPublicProfileRequestModel requestModel = new editPublicProfileRequestModel(bio, courseCode, timeCommitment, location, meetingTime);

        return userInput.saveEdits(requestModel);
    }
}
