package Edit_Group_Profile_Use_Case;
import Entities.GroupProfile;


public interface EditGroupProfileInputBoundary {
    /**
     * Triggers the EditGroupProfileUseCase.
     * @param requestModel
     * @return
     */
    EditGroupProfileResponseModel editGroup(EditGroupProfileRequestModel requestModel);

}

