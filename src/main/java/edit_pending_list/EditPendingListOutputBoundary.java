package edit_pending_list;

public interface EditPendingListOutputBoundary {
    EditPendingListResponseModel prepareSuccessView(EditPendingListResponseModel success);

    EditPendingListResponseModel prepareFailView(String error);
}
