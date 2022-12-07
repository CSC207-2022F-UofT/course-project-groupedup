package edit_group_profile_use_case;
import Entities.NormalGroup;

public interface EditGroupProfileDsGateway {
    boolean existsByGroupName(String groupName);
    /**
     *
     * @param groupName The unique groupname identifier.
     * @return whether the Group exists or not.
     */
    NormalGroup findGroup(String groupName);
    void saveGroupProfile(EditGroupProfileDsRequestModel requestModel);
    /**
     * Saves an edited group profile to the database.
     * @param EditGroupProfileDsRequestModel the group information to save.
     */
}