package use_cases.view_group_members_use_case;

import entities.Group;
import entities.InteractorMessages;
import entities.User;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * The view group members use case.
 * Allows the group leader to view their group's current members.
 */

public class ViewGroupMembersInteractor implements ViewGroupMembersInputBoundary {

    final ViewGroupMembersDsGateway dsGateway;
    final ViewGroupMembersOutputBoundary presenter;

    /**
     * @param dsGateway the data access interface
     * @param presenter the output boundary implemented by ViewGroupMembersPresenter
     */
    public ViewGroupMembersInteractor(ViewGroupMembersDsGateway dsGateway, ViewGroupMembersOutputBoundary presenter) {
        this.dsGateway = dsGateway;
        this.presenter = presenter;
    }

    /**
     * @param requestModel the request model for the view group members use case
     */
    @Override
    public void getGroupMembers(ViewGroupMembersRequestModel requestModel) {
        String groupName = requestModel.getGroupName();
        if (!dsGateway.groupIdentifierExists(groupName)) {
            throw new RuntimeException(InteractorMessages.GROUP_DOES_NOT_EXIST);
        }
        Group group = dsGateway.getGroup(groupName);
        HashMap<String, User> userMap = dsGateway.loadUsers();

        ArrayList<String> groupMembers = new ArrayList<>(group.getGroupMembers(userMap).keySet());

        ViewGroupMembersResponseModel responseModel = new ViewGroupMembersResponseModel(groupName, groupMembers);
        presenter.prepareSuccessView(responseModel);
    }
}
