package pending_list_screens;

import view_pending_list.ViewPendingListInputBoundary;
import view_pending_list.ViewPendingListRequestModel;
import view_pending_list.ViewPendingListResponseModel;

/**
 * Executes the view pending list use case.
 */

public class ViewPendingListController {
    final ViewPendingListInputBoundary groupName;

    public ViewPendingListController(ViewPendingListInputBoundary groupName) { this.groupName = groupName; }

    /**
     * @param groupName the name of the group corresponding to the pending list
     * @return the response model created by ViewPendingListPresenter
     */
    public ViewPendingListResponseModel getUsernames(String groupName) {
        ViewPendingListRequestModel requestModel = new ViewPendingListRequestModel(groupName);
        return this.groupName.getUsernamesList(requestModel);
    }
}

