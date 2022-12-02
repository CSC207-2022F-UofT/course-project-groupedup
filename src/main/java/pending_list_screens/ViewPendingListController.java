package pending_list_screens;

import view_pending_list.ViewPendingListInputBoundary;
import view_pending_list.ViewPendingListRequestModel;

/**
 * The controller that initiates the view pending list use case.
 */

public class ViewPendingListController {
    final ViewPendingListInputBoundary groupName;

    public ViewPendingListController(ViewPendingListInputBoundary groupName) { this.groupName = groupName; }

    public void getUsernames(String groupName) {
        ViewPendingListRequestModel requestModel = new ViewPendingListRequestModel(groupName);
        this.groupName.getUsernamesList(requestModel);
    }
}

