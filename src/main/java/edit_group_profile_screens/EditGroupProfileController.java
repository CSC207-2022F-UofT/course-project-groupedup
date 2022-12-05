package edit_group_profile_screens;
import edit_group_profile_use_case.EditGroupProfileInputBoundary;
import edit_group_profile_use_case.EditGroupProfileRequestModel;

/**
 * This is the use case's controller. It will trigger the interactor and bundle up
 * data to pass to it.
 */

public class EditGroupProfileController {
    final EditGroupProfileInputBoundary groupInput;

    public EditGroupProfileController(EditGroupProfileInputBoundary groupInput) {
        this.groupInput = groupInput;
    }
    /**
     * This method triggers the Edit Group Profile Use Case.
     * It will create a bundle of data, called the request model with the input from the user
     * which is necessary to edit information in the group profile.
     * Then, it will call the input boundary to trigger the use case, passing in the request model.
     */

    void editedChanges(String groupName, String description, String timeCommitment, String location, String meetingTime, String courseCode) {
        EditGroupProfileRequestModel requestModel = new EditGroupProfileRequestModel(groupName, description, timeCommitment, location, meetingTime, courseCode);
        groupInput.editGroup(requestModel);
    }
}

