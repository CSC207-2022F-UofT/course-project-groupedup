package pendinglistscreens;

import viewpendinglist.ViewPendingListOutputBoundary;
import viewpendinglist.ViewPendingListResponseModel;

/**
 * The presenter for the view pending list use case.
 */

public class ViewPendingListPresenter implements ViewPendingListOutputBoundary {

    // Wait this feels redundant again... what
    /**
     * @param usernamesList list of usernames of users who've applied to the group
     * @return usernamesList
     */
    public ViewPendingListResponseModel prepareSuccessView(ViewPendingListResponseModel usernamesList) {
        return usernamesList;
    }

}
