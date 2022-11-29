package view_group_members;

import java.util.ArrayList;

public class ViewGroupMembersResponseModel {
    ArrayList<String> groupMembers;

    /**
     * @param groupMembers a list of the users in the group
     */
    public ViewGroupMembersResponseModel(ArrayList<String> groupMembers) {
        this.groupMembers = groupMembers;
    }

    public ArrayList<String> getGroupMembers() {
        return this.groupMembers;
    }

}
