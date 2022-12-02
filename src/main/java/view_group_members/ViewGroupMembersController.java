package view_group_members;

import view_group_members.ViewGroupMembersInputBoundary;
import view_group_members.ViewGroupMembersRequestModel;
import view_group_members.ViewGroupMembersResponseModel;

/**
 * Executes the view pending list use case.
 */

public class ViewGroupMembersController {
    final ViewGroupMembersInputBoundary groupName;

    public ViewGroupMembersController(ViewGroupMembersInputBoundary groupName) { this.groupName = groupName; }

    /**
     * @param groupName the name of the group
     * @return the response model created by ViewGroupMembersPresenter
     */
    public ViewGroupMembersResponseModel getGroupMembers(String groupName) {
        ViewGroupMembersRequestModel requestModel = new ViewGroupMembersRequestModel(groupName);
        return this.groupName.getGroupMembers(requestModel);
    }
}

