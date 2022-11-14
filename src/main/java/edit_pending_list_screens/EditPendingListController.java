package edit_pending_list_screens;

import edit_pending_list_use_case.EditPendingListInputBoundary;
import edit_pending_list_use_case.EditPendingListRequestModel;
import edit_pending_list_use_case.EditPendingListResponseModel;

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
