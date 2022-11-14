package edit_pending_list_use_case;

public class EditPendingListRequestModel {

    private final String username;
    private final String groupName;
    private final boolean pendingStatus;

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
