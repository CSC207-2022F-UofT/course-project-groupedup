package view_group_members;

import java.util.ArrayList;

public class ViewGroupMembersResponseModel {
    ArrayList<String> groupMembers;
    String groupName;

    /**
     * @param groupMembers a list of the users in the group
     */
    public ViewGroupMembersResponseModel(String groupName, ArrayList<String> groupMembers) {
        this.groupName = groupName;
        this.groupMembers = groupMembers;
    }

    public String getGroupName() { return this.groupName; }
    public ArrayList<String> getGroupMembers() {
        return this.groupMembers;
    }

}
