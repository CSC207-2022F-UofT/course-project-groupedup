package use_cases.edit_pending_list_use_case;

/**
 * The output boundary interface for the edit pending list use case.
 */

public interface EditPendingListOutputBoundary {
    void prepareAcceptedView(EditPendingListResponseModel success);

    void prepareRejectedView(EditPendingListResponseModel success);

    void prepareFailView(String error);
}
