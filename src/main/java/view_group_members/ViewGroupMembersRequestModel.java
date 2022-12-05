package view_group_members;

public class ViewGroupMembersRequestModel {

    private final String groupName;

    public ViewGroupMembersRequestModel(String groupName) {
        this.groupName = groupName;
    }

    public String getGroupName() {
        return this.groupName;
    }
}
