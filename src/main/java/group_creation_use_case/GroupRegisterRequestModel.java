package group_creation_use_case;

public class GroupRegisterRequestModel {
    private String groupName;

    public GroupRegisterRequestModel(String groupName){
        this.groupName = groupName;
    }

    /**
     *
     * @return the Group's unique name.
     */
    public String getGroupName() {
        return groupName;
    }
}
