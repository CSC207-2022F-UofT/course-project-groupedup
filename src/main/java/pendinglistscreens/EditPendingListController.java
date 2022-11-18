package pendinglistscreens;

import editpendinglist.EditPendingListInputBoundary;
import editpendinglist.EditPendingListRequestModel;
import editpendinglist.EditPendingListResponseModel;

public class EditPendingListController {

    final EditPendingListInputBoundary userInput;

    public EditPendingListController(EditPendingListInputBoundary actionGateway) {
        this.userInput = actionGateway;
    }

    EditPendingListResponseModel rejectOrAcceptUser(String username, String groupName, boolean pendingStatus) {
        EditPendingListRequestModel requestModel = new EditPendingListRequestModel(username, groupName, pendingStatus);

        return userInput.addOrRemoveUser(requestModel);
    }
}
