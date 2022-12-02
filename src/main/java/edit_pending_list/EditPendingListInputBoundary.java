package edit_pending_list;

/**
 * The input boundary interface for the edit pending list use case.
 */
public interface EditPendingListInputBoundary {
    void addOrRemoveUser(EditPendingListRequestModel requestModel);
}
