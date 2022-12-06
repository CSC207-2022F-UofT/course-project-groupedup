package pending_list_screens;

import use_cases.view_group_members_use_case.ViewGroupMembersInputBoundary;
import use_cases.view_group_members_use_case.ViewGroupMembersRequestModel;

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

