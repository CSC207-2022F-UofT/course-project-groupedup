package group_creation_use_case;

public class GroupRegisterRequestModel {
    private String groupName;

    public GroupRegisterRequestModel(String groupName){
        this.groupName = groupName;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }
}
