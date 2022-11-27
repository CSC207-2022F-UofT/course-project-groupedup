package view_pending_list;

public class ViewPendingListRequestModel {

    private final String groupName;

    public ViewPendingListRequestModel(String groupName) {
        this.groupName = groupName;
    }

    public String getGroupName() {
        return this.groupName;
    }
}
