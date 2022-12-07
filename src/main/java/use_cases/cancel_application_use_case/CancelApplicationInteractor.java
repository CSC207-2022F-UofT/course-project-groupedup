package use_cases.cancel_application_use_case;

import entities.Group;
import entities.InteractorMessages;
import entities.User;

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
            throw new RuntimeException(InteractorMessages.GROUP_DOES_NOT_EXIST);
        }

        User user = dsGateway.getUser(requestModel.getUsername());
        Group group = dsGateway.getGroup(requestModel.getGroupName());

        if (!dsGateway.userInMemberRequests(user.getUsername(), group.getGroupName())) {
            outputBoundary.prepareFailureView(InteractorMessages.GROUP_NOT_IN_APPLICATIONS);
        } else if (!dsGateway.groupInApplications(group.getGroupName(), user.getUsername())) {
            throw new RuntimeException(InteractorMessages.USER_NOT_IN_REQUESTS);
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
