package edit_pending_list_screens;

import edit_pending_list_use_case.EditPendingListResponseModel;
import edit_pending_list_use_case.EditPendingListPresenter;

// TODO: I think my response model only needs to return a success/failure message. My use case doesn't return any new
//  information that the pending list UI needs (i.e., when a user is accepted/rejected, their name immediately
//  disappears from the pending list UI (which doesn't depend on a response model to happen) and the rest of the work
//  (removing/adding them to various entity lists) is done behind the scenes

public class EditPendingListResponseFormatter implements EditPendingListPresenter {
    @Override
    public EditPendingListResponseModel prepareSuccessView(EditPendingListResponseModel pendingList) {
        return null;
    }

    /**
     *
     * @param error
     * @return
     */
    @Override
    public EditPendingListResponseModel prepareFailView(String error) {
        return null;
    }
}
