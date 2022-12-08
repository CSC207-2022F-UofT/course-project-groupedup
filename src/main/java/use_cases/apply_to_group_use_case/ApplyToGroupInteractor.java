package use_cases.apply_to_group_use_case;
import entities.InteractorMessages;
import entities.User;
import entities.Group;

/**
 * The Apply To Group use case.
 * Allows users to apply to groups that they are not in and have not already applied to.
 */
public class ApplyToGroupInteractor implements ApplyToGroupInputBoundary {
    final ApplyToGroupDsGateway applyToGroupDsGateway;
    final ApplyToGroupOutputBoundary applyToGroupOutputBoundary;

    /**
     * The interactor for the Apply to Group use case
     * @param applyToGroupDsGateway the data access interface
     * @param applyToGroupOutputBoundary the output boundary implemented by ApplyToGroupPresenter
     */
    public ApplyToGroupInteractor(ApplyToGroupDsGateway applyToGroupDsGateway,
                                  ApplyToGroupOutputBoundary applyToGroupOutputBoundary) {

        this.applyToGroupDsGateway = applyToGroupDsGateway;
        this.applyToGroupOutputBoundary = applyToGroupOutputBoundary;
    }

    /**
     * Adds the user to group's pending list and adds the group to user's applications list.
     * @param requestModel the requestModel for the "apply to group" use case
     */

    @Override
    public void applyToGroup(ApplyToGroupRequestModel requestModel) {

        User user = applyToGroupDsGateway.getUser(requestModel.getUsername());
        Group group = applyToGroupDsGateway.getGroup(requestModel.getGroupName());

        // Exceptions

        if (!applyToGroupDsGateway.groupIdentifierExists(requestModel.getGroupName())) {
            applyToGroupOutputBoundary.prepareFailView(InteractorMessages.GROUP_DOES_NOT_EXIST);
        } else if (applyToGroupDsGateway.userInGroup(user.getUsername(), group.getGroupName()) ||
                applyToGroupDsGateway.groupInUser(group.getGroupName(), user.getUsername())) {
            applyToGroupOutputBoundary.prepareFailView(InteractorMessages.USER_IN_GROUP);
        } else if (applyToGroupDsGateway.userInMemberRequests(user.getUsername(), group.getGroupName()) ||
                applyToGroupDsGateway.groupInApplications(group.getGroupName(), user.getUsername())) {
            applyToGroupOutputBoundary.prepareFailView(InteractorMessages.USER_IN_APPLICATIONS);
        } else {
            user.addApplication(group.getGroupName());
            group.addMemberRequest(user.getUsername());

            applyToGroupDsGateway.updateUser(user);
            applyToGroupDsGateway.updateGroup(group);

            ApplyToGroupResponseModel responseModel = new ApplyToGroupResponseModel(user.getUsername(),
                    group.getGroupName());
            applyToGroupOutputBoundary.prepareSuccessView(responseModel);
        }
    }
}
