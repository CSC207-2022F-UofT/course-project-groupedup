package use_cases.view_pending_list_use_case;

/**
 * The request model for the view pending list use case.
 */

public class ViewPendingListRequestModel {
    private final String groupName;
    public ViewPendingListRequestModel(String groupName) {
        this.groupName = groupName;
    }
    public String getGroupName() {
        return this.groupName;
    }
}
