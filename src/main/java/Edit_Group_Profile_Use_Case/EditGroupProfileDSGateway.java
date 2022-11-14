package Edit_Group_Profile_Use_Case;

public interface EditGroupProfileDSGateway {
    boolean existsByGroupName(String groupName);
    void findGroup(String groupName);
    void saveGroupProfile(EditGroupProfileDsRequestModel requestModel);
}
