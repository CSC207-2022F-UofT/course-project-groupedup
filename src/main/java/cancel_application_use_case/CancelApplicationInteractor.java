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
     * @return a successView or failView depending on whether the user has cancelled their group application
     */
    @Override
    public CancelApplicationResponseModel cancelApplication(CancelApplicationRequestModel requestModel) {

        if (!dsGateway.groupExists(requestModel.getGroupname())) {
            return outputBoundary.prepareFailureView("Group does not exist.");
        }

        User user = dsGateway.getUser(requestModel.getUsername());
        Group group = dsGateway.getGroup(requestModel.getGroupname());

        if(!dsGateway.userInGroup(user.getUsername(), group.getGroupName())) {
            return outputBoundary.prepareFailureView("User is not in group.");
        }

        if (!dsGateway.groupInUser(user.getUsername(), group.getGroupName())) {
            return outputBoundary.prepareFailureView("Group is not in user's list.");
        }

        user.removeApplication(group.getGroupName());
        group.removeApplication(user.getUsername());

        dsGateway.updateUser(user.getUsername());
        dsGateway.updateGroup(group.getGroupName());

        CancelApplicationResponseModel responseModel = new CancelApplicationResponseModel(user.getUsername(),
                group.getGroupName());

        return outputBoundary.prepareSuccessView(responseModel);
    }
}