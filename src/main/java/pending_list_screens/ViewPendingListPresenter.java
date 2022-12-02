package pending_list_screens;

import view_pending_list.ViewPendingListOutputBoundary;
import view_pending_list.ViewPendingListResponseModel;

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
