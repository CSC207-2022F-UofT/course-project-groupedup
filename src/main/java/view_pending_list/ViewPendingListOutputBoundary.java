package view_pending_list;

/**
 * The output boundary interface for the view pending list use case.
 */

public interface ViewPendingListOutputBoundary {
    void prepareSuccessView(ViewPendingListResponseModel usernamesList);
}
