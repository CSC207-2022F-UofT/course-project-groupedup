package edit_pending_list_use_case;

public interface EditPendingListPresenter {
    EditPendingListResponseModel prepareSuccessView(EditPendingListResponseModel pendingList);

    EditPendingListResponseModel prepareFailView(String error);
}
