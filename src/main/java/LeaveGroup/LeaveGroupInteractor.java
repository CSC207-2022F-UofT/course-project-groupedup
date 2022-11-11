package LeaveGroup;

import Entities.Group;
import Entities.User;
import Entities.CurrentUser;

public class LeaveGroupInteractor implements LeaveGroupInputBoundary {

    final LeaveGroupDsGateway leaveGroupDsGateway;
    final LeaveGroupPresenter leaveGroupPresenter;
    final User user = CurrentUser.getUser();

    public LeaveGroupInteractor(LeaveGroupDsGateway leaveGroupDsGateway,
                                LeaveGroupPresenter leaveGroupPresenter) {

        this.leaveGroupDsGateway = leaveGroupDsGateway;
        this.leaveGroupPresenter = leaveGroupPresenter;
    }

    @Override
    public LeaveGroupResponseModel create(LeaveGroupRequestModel requestModel) {

        if (!leaveGroupDsGateway.userExistsByID(user.getID())) {
            return leaveGroupPresenter.prepareFailView("User does not exist.");
        }
        if (!leaveGroupDsGateway.groupExistsByID(requestModel.getGroupID())) {
            return leaveGroupPresenter.prepareFailView("Group does not exist.");
        }

        Group group = leaveGroupDsGateway.getGroup(requestModel.getGroupID());

        if (!group.getGroupMembers().containsValue(user)) {
            return leaveGroupPresenter.prepareFailView("User is not in group.");
        }
        if (!user.getGroups().containsValue(group)) {
            return leaveGroupPresenter.prepareFailView("Group is not in user's list.");
        }
        if (group.getGroupLeader().getID() == user.getID()) {
            return leaveGroupPresenter.prepareFailView("User is group leader.");
        }

        user.removeGroup(group.getGroupID());
        group.removeMember(user.getID());

        //TODO: save user and group changes -- dsGateway? Saver class?

        LeaveGroupResponseModel responseModel = new LeaveGroupResponseModel(user, group);

        return leaveGroupPresenter.prepareSuccessView(responseModel);

    }
}
