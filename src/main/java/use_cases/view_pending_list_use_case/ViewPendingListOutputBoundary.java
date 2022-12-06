package use_cases.view_pending_list_use_case;

/**
 * The output boundary interface for the view pending list use case.
 */

public interface ViewPendingListOutputBoundary {
    void prepareSuccessView(ViewPendingListResponseModel usernamesList);
}
