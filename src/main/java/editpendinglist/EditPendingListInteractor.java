package editpendinglist;

import Entities.Group;
import Entities.User;

import java.util.HashMap;

/**
 * The edit pending list use case.
 * Allows group leaders to accept or reject users who've applied to their group.
 */

public class EditPendingListInteractor implements EditPendingListInputBoundary {

    final EditPendingListDsGateway dsGateway;
    final EditPendingListOutputBoundary presenter;

    /**
     * @param dsGateway the data access interface
     * @param presenter the output boundary implemented by EditPendingListPresenter
     */
    public EditPendingListInteractor(EditPendingListDsGateway dsGateway, EditPendingListOutputBoundary presenter) {
        this.dsGateway = dsGateway;
        this.presenter = presenter;
    }

    /**
     * Adds the user and group to the appropriate lists based on whether the user was accepted or rejected.
     * @param requestModel the requestModel for the edit pending list use case
     * @return a response model
     */
    @Override
    public EditPendingListResponseModel addOrRemoveUser(EditPendingListRequestModel requestModel) {
        String username = requestModel.getUsername();
        String groupName = requestModel.getGroupName();
        boolean pendingStatus = requestModel.getPendingStatus();

        if (!dsGateway.userExists(username)) {
            return presenter.prepareFailView("This user has deleted their account.");
        }

        User user = dsGateway.getUser(username);
        Group group = dsGateway.getGroup(groupName);
        HashMap<String, User> userMap = dsGateway.getUserMap();

        if (!group.getMemberRequests(userMap).containsValue(user)) {
            return presenter.prepareFailView("This user has cancelled their join request.");
        }

        // TODO: this might be an exception
        // if (!user.getApplicationsList().containsValue(group)) {
        // return PendingListPresenter.prepareFailView("This group isn't on the user's application list.");
        // }

        group.removeFromRequests(username);
        user.removeApplication(groupName);

        if (pendingStatus) {
            user.addGroup(group);
            group.addMember(username);
        }

        dsGateway.updateUser(username);
        dsGateway.updateGroup(groupName);

        EditPendingListResponseModel responseModel = new EditPendingListResponseModel(username, groupName);
        return presenter.prepareSuccessView(responseModel);
    }
}
