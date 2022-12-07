package controllers_presenters_and_screen_boundaries.pending_list_adapters;

import use_cases.view_pending_list_use_case.ViewPendingListInputBoundary;
import use_cases.view_pending_list_use_case.ViewPendingListRequestModel;

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

