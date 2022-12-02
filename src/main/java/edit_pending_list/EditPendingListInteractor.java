package edit_pending_list;

import Entities.Group;
import Entities.User;

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
     */
    @Override
    public void addOrRemoveUser(EditPendingListRequestModel requestModel) {
        String username = requestModel.getUsername();
        String groupName = requestModel.getGroupName();
        boolean pendingStatus = requestModel.getPendingStatus();

        if (!dsGateway.groupIdentifierExists(groupName)) {
            throw new RuntimeException("This group doesn't exist.");
        }

        if (!dsGateway.userIdentifierExists(username)) {
            presenter.prepareFailView("This user no longer exists.");
        }

        User user = dsGateway.getUser(username);
        Group group = dsGateway.getGroup(groupName);

        if (!dsGateway.userInMemberRequests(username, groupName)) {
            presenter.prepareFailView("This user has cancelled their join request.");
        }

        if (!dsGateway.groupInApplications(groupName, username)) {
            throw new RuntimeException("This group is not in this user's application list.");
        }

        if (dsGateway.groupInUser(groupName, username) || dsGateway.userInGroup(username, groupName)) {
            throw new RuntimeException("This user is already in this group.");
        }

        group.removeFromRequests(username);
        user.removeApplication(groupName);

        if (pendingStatus) {
            user.addGroup(groupName);
            group.addMember(username);
        }

        dsGateway.updateUser(user);
        dsGateway.updateGroup(group);

        EditPendingListResponseModel responseModel = new EditPendingListResponseModel(username, groupName);
        if (pendingStatus) {
            presenter.prepareAcceptedView(responseModel);
        } else {
            presenter.prepareRejectedView(responseModel);
        }
    }
}
