package pending_list_screens;

import use_cases.edit_pending_list_use_case.EditPendingListInputBoundary;
import use_cases.edit_pending_list_use_case.EditPendingListRequestModel;

/**
 * The controller that initiates the edit pending list use case.
 */

public class EditPendingListController {

    final EditPendingListInputBoundary userInput;

    public EditPendingListController(EditPendingListInputBoundary userInput) {
        this.userInput = userInput;
    }

    /**
     * @param username the username of the accepted/rejected user
     * @param groupName the group's name
     * @param pendingStatus a boolean indicating whether the user was accepted
     */
    public void rejectOrAcceptUser(String username, String groupName, boolean pendingStatus) {
        EditPendingListRequestModel requestModel = new EditPendingListRequestModel(username, groupName, pendingStatus);
        userInput.addOrRemoveUser(requestModel);
    }
}
