package group_creation_use_case;

public class GroupRegisterResponseModel {

    String groupName;

    public GroupRegisterResponseModel(String groupName){
        this.groupName = groupName;
    }

    /**
     *
     * @return the Group's groupname.
     */
    public String getGroupName() {
        return groupName;
    }

}
