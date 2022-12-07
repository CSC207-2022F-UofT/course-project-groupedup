package use_cases.view_group_members_use_case;

public class ViewGroupMembersRequestModel {

    private final String groupName;

    public ViewGroupMembersRequestModel(String groupName) {
        this.groupName = groupName;
    }

    public String getGroupName() {
        return this.groupName;
    }
}
