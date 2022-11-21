package Edit_Group_Profile_Use_Case;
import Entities.Group;

public interface EditGroupProfileDsGateway {
    boolean existsByGroupName(String groupName);
    /**
     *
     * @param groupName The unique groupname identifier.
     * @return whether the Group exists or not.
     */
    Group findGroup(String groupName);
    void saveGroupProfile(EditGroupProfileDsRequestModel requestModel);
    /**
     * Saves an edited group profile to the database.
     * @param EditGroupProfileDsRequestModel the group information to save.
     */
}
