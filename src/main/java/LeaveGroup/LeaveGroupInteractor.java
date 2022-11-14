package LeaveGroup;

import Entities.Group;
import Entities.User;

import java.util.Objects;

public class LeaveGroupInteractor implements LeaveGroupInputBoundary {

    final LeaveGroupDsGateway dsGateway;
    final LeaveGroupPresenter presenter;

    public LeaveGroupInteractor(LeaveGroupDsGateway dsGateway,
                                LeaveGroupPresenter presenter) {

        this.dsGateway = dsGateway;
        this.presenter = presenter;
    }

    @Override
    public LeaveGroupResponseModel leaveGroup(LeaveGroupRequestModel requestModel) {

        // should not be possible ... exception instead?

        if (!dsGateway.userExists(requestModel.getUsername())) {
            return presenter.prepareFailureView("User does not exist.");
        }
        if (!dsGateway.groupExists(requestModel.getGroupname())) {
            return presenter.prepareFailureView("Group does not exist.");
        }

        User user = dsGateway.getUser(requestModel.getUsername());
        Group group = dsGateway.getGroup(requestModel.getGroupname());

        if (!group.getGroupMembers().containsValue(user)) {
            return presenter.prepareFailureView("User is not in group.");
        }
        if (!user.getGroups().containsValue(group)) {
            return presenter.prepareFailureView("Group is not in user's list.");
        }
        if (Objects.equals(group.getGroupLeader().getName(), user.getName())) {
            return presenter.prepareFailureView("User is group leader.");
        }

        user.removeGroup(group.getGroupName());
        group.removeMember(user.getName());

        dsGateway.updateUser(user.getName());
        dsGateway.updateGroup(group.getGroupName());

        return presenter.prepareSuccessView("User left group.");
    }
}
