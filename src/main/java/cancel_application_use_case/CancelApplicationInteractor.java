package cancel_application_use_case;

import Entities.Group;
import Entities.User;

/**
 * The cancelApplication use case.
 * The user can only cancel applications for groups that they have previously applied to,
 * where the user has not already been rejected or approved.
 */

public class CancelApplicationInteractor implements CancelApplicationInputBoundary {

    final CancelApplicationDsGateway dsGateway;
    final CancelApplicationOutputBoundary outputBoundary;

    /**
     * The interactor for the cancelApplication use case.
     * @param dsGateway the data access interface
     * @param outputBoundary the output boundary implemented by the cancelApplicationPresenter
     */
    public CancelApplicationInteractor(CancelApplicationDsGateway dsGateway,
                                       CancelApplicationOutputBoundary outputBoundary) {
        this.dsGateway = dsGateway;
        this.outputBoundary = outputBoundary;
    }

    /**
     * @param requestModel the requestModel for the cancelApplication use case
     */
    @Override
    public void cancelApplication(CancelApplicationRequestModel requestModel) {

        if (!dsGateway.groupIdentifierExists(requestModel.getGroupName())) {
            throw new RuntimeException("This group does not exist.");
        }

        User user = dsGateway.getUser(requestModel.getUsername());
        Group group = dsGateway.getGroup(requestModel.getGroupName());

        if (!dsGateway.userInMemberRequests(user.getUsername(), group.getGroupName())) {
            outputBoundary.prepareFailureView("The group has already rejected your application.");
        } else if (!dsGateway.groupInApplications(group.getGroupName(), user.getUsername())) {
            throw new RuntimeException("Group is not in user's applications list.");
        } else {
            user.removeApplication(group.getGroupName());
            group.removeFromRequests(user.getUsername());

            dsGateway.updateUser(user);
            dsGateway.updateGroup(group);

            CancelApplicationResponseModel responseModel = new CancelApplicationResponseModel(user.getUsername(),
                    group.getGroupName());

            outputBoundary.prepareSuccessView(responseModel);
        }
    }
}