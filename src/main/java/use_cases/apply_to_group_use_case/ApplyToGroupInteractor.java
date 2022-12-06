package use_cases.apply_to_group_use_case;
import entities.User;
import entities.Group;
import java.util.HashMap;

/**
 * The Apply To Group use case.
 * Allows users to apply to groups that they are not in and have not already applied to.
 */
public class ApplyToGroupInteractor implements ApplyToGroupInputBoundary {
    final ApplyToGroupDsGateway applyToGroupDsGateway;
    final ApplyToGroupOutputBoundary applyToGroupOutputBoundary;

    /**
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
     * @return a response model
     */

    @Override
    public void applyToGroup(ApplyToGroupRequestModel requestModel) {

        User user = applyToGroupDsGateway.getUser(requestModel.getUsername());
        Group group = applyToGroupDsGateway.getGroup(requestModel.getGroupName());
        HashMap<String, User> userMap = applyToGroupDsGateway.getUserMap();

        // Exceptions
        // Checks if the user and the group exists, might be redundant or not.
        // The decision depends on whether we want to implement additional checks or not.

        if (!applyToGroupDsGateway.groupExistsByName(requestModel.getGroupName())) {
            applyToGroupOutputBoundary.prepareFailView("Group does not exist.");
            return;
        }

        // Checks if the user is already a member of the group, or has applied, waiting for a response.
        if (applyToGroupDsGateway.userInGroup(user.getUsername(), group.getGroupName()) ) {
            applyToGroupOutputBoundary.prepareFailView("User is already in group.");
            return;
        }

        if (applyToGroupDsGateway.userInApplications(user.getUsername(), group.getGroupName())) {
            applyToGroupOutputBoundary.prepareFailView("User has already applied to the group.");
            return;
        }

        user.addApplication(group.getGroupName());
        group.addMemberRequest(user.getUsername());

        applyToGroupDsGateway.updateUser(user.getUsername());
        applyToGroupDsGateway.updateGroup(group.getGroupName());

        ApplyToGroupResponseModel responseModel = new ApplyToGroupResponseModel(user.getUsername(),
                group.getGroupName());
        applyToGroupOutputBoundary.prepareSuccessView(responseModel);
    }
}