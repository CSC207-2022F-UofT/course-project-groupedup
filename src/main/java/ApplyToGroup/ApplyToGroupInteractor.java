package ApplyToGroup;
import Entities.User;
import Entities.Group;
import Entities.CurrentUser;

public class ApplyToGroupInteractor implements ApplyToGroupInputBoundary {

    final ApplyToGroupDsGateway applyToGroupDsGateway;
    final ApplyToGroupPresenter applyToGroupPresenter;
    final User user = CurrentUser.getUser();

    public ApplyToGroupInteractor(ApplyToGroupDsGateway applyToGroupDsGateway,
                                ApplyToGroupPresenter applyToGroupPresenter) {

        this.applyToGroupDsGateway = applyToGroupDsGateway;
        this.applyToGroupPresenter = applyToGroupPresenter;
    }

    @Override
    public ApplyToGroupResponseModel create(ApplyToGroupRequestModel requestModel) {
        if (!applyToGroupDsGateway.userExistsByID(user.getID())) {
            return applyToGroupPresenter.prepareFailView("User does not exist.");
        }
        if (!applyToGroupDsGateway.groupExistsByID(requestModel.getGroupID())) {
            return applyToGroupPresenter.prepareFailView("Group does not exist.");
        }

        Group group = applyToGroupDsGateway.getGroup(requestModel.getGroupID());

        if (group.getGroupMembers().containsValue(user)) {
            return applyToGroupPresenter.prepareFailView("User is already in group.");
        }

        if (group.getMemberRequests().containsValue(user)) {
            return applyToGroupPresenter.prepareFailView("User has already applied to the group.");
        }

        if (user.getGroups().containsValue(group)) {
            return applyToGroupPresenter.prepareFailView("Group is already in user's list.");
        }

        if (user.getApplicationsList().containsValue(group)) {
            return applyToGroupPresenter.prepareFailView("User has already applied to the group.");
        }

        if (group.getGroupLeader().getID() == user.getID()) {
            return applyToGroupPresenter.prepareFailView("User is group leader.");
        }

        user.addApplication(group);
        group.addMemberRequest(user);


        ApplyToGroupResponseModel responseModel = new ApplyToGroupResponseModel(user, group);
        return applyToGroupPresenter.prepareSuccessView(responseModel);

    }
}
