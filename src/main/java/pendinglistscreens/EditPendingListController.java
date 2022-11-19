package pendinglistscreens;

import editpendinglist.EditPendingListInputBoundary;
import editpendinglist.EditPendingListRequestModel;
import editpendinglist.EditPendingListResponseModel;

/**
 * Executes the edit pending list use case.
 */

public class EditPendingListController {

    final EditPendingListInputBoundary userInput;

    public EditPendingListController(EditPendingListInputBoundary actionGateway) {
        this.userInput = actionGateway;
    }

    /**
     * @param username the username of the accepted/rejected user
     * @param groupName the group's name
     * @param pendingStatus a boolean indicating whether the user was accepted
     * @return the response model created by EditPendingListPresenter
     */
    EditPendingListResponseModel rejectOrAcceptUser(String username, String groupName, boolean pendingStatus) {
        EditPendingListRequestModel requestModel = new EditPendingListRequestModel(username, groupName, pendingStatus);

        return userInput.addOrRemoveUser(requestModel);
    }
}
