package CancelApplication;

import Entities.Group;
import Entities.User;

public class CancelApplicationInteractor implements CancelApplicationInputBoundary {

    final CancelApplicationDsGateway dsGateway;
    final CancelApplicationPresenter presenter;

    public CancelApplicationInteractor(CancelApplicationDsGateway dsGateway,
                                       CancelApplicationPresenter presenter) {
        this.dsGateway = dsGateway;
        this.presenter = presenter;
    }

    @Override
    public CancelApplicationResponseModel cancelApplication(CancelApplicationRequestModel requestModel) {

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

        user.removeApplication(group.getGroupName());
        group.removeApplication(user.getUsername());

        dsGateway.updateUser(user.getUsername());
        dsGateway.updateGroup(group.getGroupName());

        return presenter.prepareSuccessView("User cancelled application.");
    }
}