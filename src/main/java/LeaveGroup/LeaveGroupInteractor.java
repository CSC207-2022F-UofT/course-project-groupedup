package LeaveGroup;

import Entities.Group;
import Entities.User;
import Entities.CurrentUser;

public class LeaveGroupInteractor implements LeaveGroupInputBoundary {

    final LeaveGroupDsGateway dsGateway;
    final LeaveGroupPresenter presenter;
    final User user = CurrentUser.getUser();

    public LeaveGroupInteractor(LeaveGroupDsGateway dsGateway,
                                LeaveGroupPresenter presenter) {

        this.dsGateway = dsGateway;
        this.presenter = presenter;
    }

    @Override
    public LeaveGroupResponseModel create(LeaveGroupRequestModel requestModel) {

        // should not be possible ... exception instead?

        if (!dsGateway.userExistsByID(user.getID())) {
            return presenter.prepareFailView("User does not exist.");
        }
        if (!dsGateway.groupExistsByID(requestModel.getGroupID())) {
            return presenter.prepareFailView("Group does not exist.");
        }

        Group group = dsGateway.getGroup(requestModel.getGroupID());

        if (!group.getGroupMembers().containsValue(user)) {
            return presenter.prepareFailView("User is not in group.");
        }
        if (!user.getGroups().containsValue(group)) {
            return presenter.prepareFailView("Group is not in user's list.");
        }
        if (group.getGroupLeader().getID() == user.getID()) {
            return presenter.prepareFailView("User is group leader.");
        }

        user.removeGroup(group.getGroupID());
        group.removeMember(user.getID());

        dsGateway.updateUser(user.getID());
        dsGateway.updateGroup(group.getGroupID());

        LeaveGroupResponseModel responseModel = new LeaveGroupResponseModel(user, group);

        return presenter.prepareSuccessView(responseModel);
    }
}
