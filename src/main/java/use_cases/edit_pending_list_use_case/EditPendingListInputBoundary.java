package use_cases.edit_pending_list_use_case;

/**
 * The input boundary interface for the edit pending list use case.
 */
public interface EditPendingListInputBoundary {
    void addOrRemoveUser(EditPendingListRequestModel requestModel);
}
