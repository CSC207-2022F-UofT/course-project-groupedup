package LeaveGroup;

public class LeaveGroupRequestModel {
    private int groupID;

    public LeaveGroupRequestModel(Integer groupID) {
        this.groupID = groupID;
    }

    public int getGroupID() {
        return groupID;
    }

    public void setGroupID(int groupID) {
        this.groupID = groupID;
    }
}
