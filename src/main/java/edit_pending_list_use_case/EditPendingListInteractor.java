package edit_pending_list_use_case;

import Entities.Group;
import Entities.User;

public class EditPendingListInteractor implements EditPendingListInputBoundary {

    final PendingListDsGateway dsGateway;
    final PendingListPresenter presenter;

    public EditPendingListInteractor(PendingListDsGateway dsGateway, PendingListPresenter presenter) {
        this.dsGateway = dsGateway;
        this.presenter = presenter;
    }

    public EditPendingListResponseModel addOrRemoveUser(EditPendingListRequestModel requestModel) {
        Integer userID = requestModel.getUserID();
        Integer groupID = requestModel.getGroupID();
        boolean pendingStatus = requestModel.getPendingStatus();

        if(!dsGateway.userExistsByID(userID)) {return presenter.prepareFailView("User does not exist.");}

        // TODO: this shouldn't be possible, maybe make it an exception instead of presenting it to the user?
        // if(!dsGateway.groupExistsByID(groupID)) {return presenter.prepareFailView("Group does not exist.");}

        User user = PendingListDsGateway.getUser(userID);
        Group group = PendingListDsGateway.getGroup(groupID);

        if (!group.getMemberRequests().containsValue(user)) {
            return PendingListPresenter.prepareFailView("This user has cancelled their join request.");
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
