package edit_group_profile_screens;
import edit_group_profile_use_case.EditGroupProfileInputBoundary;
import edit_group_profile_use_case.EditGroupProfileRequestModel;

public class EditGroupProfileController {
    final EditGroupProfileInputBoundary groupInput;

    public EditGroupProfileController(EditGroupProfileInputBoundary groupInput) {
        this.groupInput = groupInput;
    }

    void editedChanges(String groupName, String description, String timeCommitment, String location, String meetingTime, String courseCode) {
        EditGroupProfileRequestModel requestModel = new EditGroupProfileRequestModel(groupName, description, timeCommitment, location, meetingTime, courseCode);
        groupInput.editGroup(requestModel);
    }
}

