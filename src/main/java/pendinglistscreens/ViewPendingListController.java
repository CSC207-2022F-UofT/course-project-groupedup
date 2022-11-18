package pendinglistscreens;

import viewpendinglist.ViewPendingListInputBoundary;
import viewpendinglist.ViewPendingListRequestModel;
import viewpendinglist.ViewPendingListResponseModel;

public class ViewPendingListController {
    final ViewPendingListInputBoundary groupName;

    public ViewPendingListController(ViewPendingListInputBoundary groupName) { this.groupName = groupName; }

    public ViewPendingListResponseModel getUsernames(String groupName) {
        ViewPendingListRequestModel requestModel = new ViewPendingListRequestModel(groupName);
        return this.groupName.getUsernamesList(requestModel);
    }
}

