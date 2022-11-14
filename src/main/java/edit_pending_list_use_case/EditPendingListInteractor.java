package edit_pending_list_use_case;

import Entities.Group;
import Entities.User;

public class EditPendingListInteractor implements EditPendingListInputBoundary {

    final PendingListDsGateway dsGateway;
    final EditPendingListPresenter presenter;

    public EditPendingListInteractor(PendingListDsGateway dsGateway, EditPendingListPresenter presenter) {
        this.dsGateway = dsGateway;
        this.presenter = presenter;
    }

    @Override
    public EditPendingListResponseModel addOrRemoveUser(EditPendingListRequestModel requestModel) {
        String username = requestModel.getUsername();
        String groupName = requestModel.getGroupName();
        boolean pendingStatus = requestModel.getPendingStatus();

        if(!dsGateway.userExistsByID(username)) {return presenter.prepareFailView("User does not exist.");}

        // TODO: this shouldn't be possible, maybe make it an exception instead of presenting it to the user?
        // if(!dsGateway.groupExistsByID(groupName)) {return presenter.prepareFailView("Group does not exist.");}

        User user = PendingListDsGateway.getUser(username);
        Group group = PendingListDsGateway.getGroup(groupName);

        if (!group.getMemberRequests().containsValue(user)) {
            return EditPendingListPresenter.prepareFailView("This user has cancelled their join request.");
        }

        // TODO: this might also be an exception
        // if (!user.getApplicationsList().containsValue(group)) {
        // return PendingListPresenter.prepareFailView("This group isn't on the user's application list.");
        // }

        group.removeFromRequests(user);
        user.removeFromApplications(group);

        if (pendingStatus) {
            user.addGroup(group);
            group.addMember(user);
        }

        EditPendingListResponseModel responseModel = new EditPendingListResponseModel();

        return responseModel;
    }
}
