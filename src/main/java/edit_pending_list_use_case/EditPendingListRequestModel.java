package edit_pending_list_use_case;

public class EditPendingListRequestModel {

    private final Integer userID;
    private final Integer groupID;
    private final boolean pendingStatus;

    public EditPendingListRequestModel(Integer userID, Integer groupID, boolean pendingStatus) {
        this.userID = userID;
        this.groupID = groupID;
        this.pendingStatus = pendingStatus;
    }

    public Integer getUserID() {
        return userID;
    }

    public Integer getGroupID() {
        return groupID;
    }

    public boolean getPendingStatus() {
        return pendingStatus;
    }
}
