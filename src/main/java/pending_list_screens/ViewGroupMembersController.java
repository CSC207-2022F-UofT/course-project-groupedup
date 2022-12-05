package pending_list_screens;

import view_group_members.ViewGroupMembersInputBoundary;
import view_group_members.ViewGroupMembersRequestModel;

/**
 * The controller that initiates the view group members use case.
 */

public class ViewGroupMembersController {
    final ViewGroupMembersInputBoundary groupName;

    public ViewGroupMembersController(ViewGroupMembersInputBoundary groupName) { this.groupName = groupName; }

    public void getGroupMembers(String groupName) {
        ViewGroupMembersRequestModel requestModel = new ViewGroupMembersRequestModel(groupName);
        this.groupName.getGroupMembers(requestModel);
    }
}

