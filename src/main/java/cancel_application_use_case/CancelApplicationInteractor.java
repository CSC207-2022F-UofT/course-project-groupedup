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

        if (!dsGateway.groupIdentifierExists(requestModel.getGroupname())) {
            outputBoundary.prepareFailureView("Group does not exist.");
            return;
        }

        User user = dsGateway.getUser(requestModel.getUsername());
        Group group = dsGateway.getGroup(requestModel.getGroupname());

        if (!dsGateway.userInMemberRequests(user.getUsername(), group.getGroupName())) {
            outputBoundary.prepareFailureView("User is not in group's pending list.");
            return;
        }

        if (!dsGateway.groupInApplications(group.getGroupName(), user.getUsername())) {
            outputBoundary.prepareFailureView("Group is not in user's applications list.");
            return;
        }

        user.removeApplication(group.getGroupName());
        group.removeFromRequests(user.getUsername());

        dsGateway.updateUser(user);
        dsGateway.updateGroup(group);

        CancelApplicationResponseModel responseModel = new CancelApplicationResponseModel(user.getUsername(),
                group.getGroupName());

        outputBoundary.prepareSuccessView(responseModel);
    }
}