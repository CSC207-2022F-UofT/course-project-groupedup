package leave_group_use_case;

import Entities.Group;
import Entities.User;

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
     */
    @Override
    public void leaveGroup(LeaveGroupRequestModel requestModel) {

        if (!dsGateway.groupIdentifierExists(requestModel.getGroupName())) {
            outputBoundary.prepareFailureView("Group does not exist.");
            return;
        }

        User user = dsGateway.getUser(requestModel.getUsername());
        Group group = dsGateway.getGroup(requestModel.getGroupName());

        if (!dsGateway.userInGroup(user.getUsername(), group.getGroupName())) {
            outputBoundary.prepareFailureView("User is not in group.");
            return;
        }

        if (!dsGateway.groupInUser(user.getUsername(), group.getGroupName())) {
            outputBoundary.prepareFailureView("Group is not in \"My Groups\" list.");
            return;
        }

        user.removeGroup(group.getGroupName());
        group.removeMember(user.getUsername());

        dsGateway.updateUser(user);
        dsGateway.updateGroup(group);

        LeaveGroupResponseModel responseModel = new LeaveGroupResponseModel(user.getUsername(),
                group.getGroupName());

        outputBoundary.prepareSuccessView(responseModel);
    }
}
