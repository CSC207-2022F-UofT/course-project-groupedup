package CancelApplication;

import Entities.Group;
import Entities.User;

public class CancelApplicationInteractor implements CancelApplicationInputBoundary {

    final CancelApplicationDsGateway dsGateway;
    final CancelApplicationOutputBoundary outputBoundary;

    public CancelApplicationInteractor(CancelApplicationDsGateway dsGateway,
                                       CancelApplicationOutputBoundary outputBoundary) {
        this.dsGateway = dsGateway;
        this.outputBoundary = outputBoundary;
    }

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