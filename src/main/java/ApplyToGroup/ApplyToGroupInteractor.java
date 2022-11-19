package ApplyToGroup;
import Entities.User;
import Entities.Group;
import Entities.CurrentUser;

public class ApplyToGroupInteractor implements ApplyToGroupInputBoundary {

    final ApplyToGroupDsGateway applyToGroupDsGateway;
    final ApplyToGroupOutputBoundary applyToGroupOutputBoundary;
    final User user = CurrentUser.getInstance().getUser();

    public ApplyToGroupInteractor(ApplyToGroupDsGateway applyToGroupDsGateway,
                                ApplyToGroupOutputBoundary applyToGroupOutputBoundary) {

        this.applyToGroupDsGateway = applyToGroupDsGateway;
        this.applyToGroupOutputBoundary = applyToGroupOutputBoundary;
    }

    @Override
    public ApplyToGroupResponseModel applyToGroup(ApplyToGroupRequestModel requestModel) {
        if (!applyToGroupDsGateway.userExistsByName(user.getUsername())) {
            return applyToGroupOutputBoundary.prepareFailView("User does not exist.");
        }
        if (!applyToGroupDsGateway.groupExistsByName(requestModel.getGroupName())) {
            return applyToGroupOutputBoundary.prepareFailView("Group does not exist.");
        }

        Group group = applyToGroupDsGateway.getGroup(requestModel.getGroupName());

        if (group.getGroupMembers().containsValue(user) || user.getGroups().containsValue(group) ) {
            return applyToGroupOutputBoundary.prepareFailView("User is already in group.");
        }

        if (group.getMemberRequests().containsValue(user) || user.getApplicationsList().containsValue(group)) {
            return applyToGroupOutputBoundary.prepareFailView("User has already applied to the group.");
        }


        user.addApplication(group);
        group.addMemberRequest(user);

        applyToGroupDsGateway.updateUser(user.getUsername());
        applyToGroupDsGateway.updateGroup(group.getGroupName());


        ApplyToGroupResponseModel responseModel = new ApplyToGroupResponseModel(user.getUsername(),
                group.getGroupName());
        return applyToGroupOutputBoundary.prepareSuccessView(responseModel);

    }
}
