package Edit_Group_Profile_Screens;
import Edit_Group_Profile_Use_Case.EditGroupProfileInputBoundary;
import Edit_Group_Profile_Use_Case.EditGroupProfileRequestModel;
import Edit_Group_Profile_Use_Case.EditGroupProfileResponseModel;

import java.util.HashMap;

public class EditGroupProfileController {
    final EditGroupProfileInputBoundary groupInput;

    public EditGroupProfileController(EditGroupProfileInputBoundary profileGateway) {
        this.groupInput = profileGateway;
    }

    EditGroupProfileResponseModel create(String groupName, String description, String timeCommitment, String location, String meetingTime, String courseCode) {
        EditGroupProfileRequestModel requestModel = new EditGroupProfileRequestModel(groupName, description, timeCommitment, location, meetingTime, courseCode);
        return groupInput.create(requestModel);
    }
}

