package leave_group_use_case;

import Entities.Group;
import Entities.User;

import java.util.HashMap;
import java.util.Objects;

/**
 * The leaveGroup use case.
 * The user can only leave groups that they are currently a member of
 * in which they are NOT the group leader.
 */

public class LeaveGroupInteractor implements LeaveGroupInputBoundary {

    final LeaveGroupDsGateway dsGateway;
    final LeaveGroupOutputBoundary outputBoundary;

    /**
     * The interactor for the leaveGroup use case.
     * @param dsGateway the data access interface
     * @param outputBoundary the output boundary implemented by the leaveGroupPresenter
     */
    public LeaveGroupInteractor(LeaveGroupDsGateway dsGateway,
                                LeaveGroupOutputBoundary outputBoundary) {

        this.dsGateway = dsGateway;
        this.outputBoundary = outputBoundary;
    }

    /**
     * @param requestModel the requestModel for the leaveGroup use case
     * @return a successView or failView depending on whether the user has left the group
     */
    @Override
    public LeaveGroupResponseModel leaveGroup(LeaveGroupRequestModel requestModel) {

        if (!dsGateway.groupIdentifierExists(requestModel.getGroupName())) {
            return outputBoundary.prepareFailureView("Group does not exist.");
        }

        User user = dsGateway.getUser(requestModel.getUsername());
        Group group = dsGateway.getGroup(requestModel.getGroupName());

        if (!dsGateway.userInGroup(user.getUsername(), group.getGroupName())) {
            return outputBoundary.prepareFailureView("User is not in group.");
        }

        if (!dsGateway.groupInUser(user.getUsername(), group.getGroupName())) {
            return outputBoundary.prepareFailureView("Group is not in user's list.");
        }

        if (Objects.equals(group.getGroupLeaderUsername(), user.getUsername())) {
            HashMap<String, User> userMap = new HashMap<>(dsGateway.loadUsers());

            if (group.getGroupMembers(userMap).size() == 1) {
                dsGateway.deleteGroup(group.getGroupName());
                LeaveGroupResponseModel successModel = new LeaveGroupResponseModel(user.getUsername(),
                        group.getGroupName(), "Deleted Group");
                return outputBoundary.prepareSuccessView(successModel);
            }

            LeaveGroupResponseModel groupLeaderModel = new LeaveGroupResponseModel(user.getUsername(),
                    group.getGroupName(), "Group Leader");
            return outputBoundary.prepareGroupLeaderView(groupLeaderModel);
        }

        user.removeGroup(group.getGroupName());
        group.removeMember(user.getUsername());

        dsGateway.updateUser(user);
        dsGateway.updateGroup(group);

        LeaveGroupResponseModel responseModel = new LeaveGroupResponseModel(user.getUsername(),
                group.getGroupName(), "Left Group");

        return outputBoundary.prepareSuccessView(responseModel);
    }
}
