package use_cases.edit_pending_list_use_case;

/**
 * The request model for the edit pending list use case.
 */

public class EditPendingListRequestModel {

    private final String username;
    private final String groupName;
    private final boolean pendingStatus;

    /**
     * @param username the username of the user that has applied to the group
     * @param groupName the group name
     * @param pendingStatus a boolean indicating if the user was accepted
     */
    public EditPendingListRequestModel(String username, String groupName, boolean pendingStatus) {
        this.username = username;
        this.groupName = groupName;
        this.pendingStatus = pendingStatus;
    }

    public String getUsername() {
        return username;
    }

    public String getGroupName() {
        return groupName;
    }

    public boolean getPendingStatus() {
        return pendingStatus;
    }
}
