package edit_pending_list;

public interface EditPendingListOutputBoundary {
    void prepareAcceptedView(EditPendingListResponseModel success);

    void prepareRejectedView(EditPendingListResponseModel success);

    void prepareFailView(String error);
}
