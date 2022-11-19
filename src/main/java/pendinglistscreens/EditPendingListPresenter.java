package pendinglistscreens;

import editpendinglist.EditPendingListResponseModel;
import editpendinglist.EditPendingListOutputBoundary;

/**
 * The presenter for the edit pending list use case.
 */

public class EditPendingListPresenter implements EditPendingListOutputBoundary {

    // idk why this is necessary, I wish the presenter could just return actual values, someone explain pls
    // in my case this is completely redundant, for other cases maybe not?
    /**
     * @param userAndGroup a response model with the accepted/rejected user and group's names
     * @return a response model with the accepted/rejected user and group's names
     */
    @Override
    public EditPendingListResponseModel prepareSuccessView(EditPendingListResponseModel userAndGroup) {
        return userAndGroup;
    }

    /**
     * @param error the error message explaining why the error occurred
     * @return an exception
     */
    @Override
    public EditPendingListResponseModel prepareFailView(String error) {
        throw new EditPendingListFailed(error);
    }
}
