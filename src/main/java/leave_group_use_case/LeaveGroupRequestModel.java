package leave_group_use_case;

public class LeaveGroupRequestModel {
    private final String username;
    private final String groupName;

    /**
     * @param username the username of the current user
     * @param groupName the groupname of the group the user is leaving
     */
    public LeaveGroupRequestModel(String username, String groupName) {
        this.username = username;
        this.groupName = groupName;
    }

    public String getGroupName() {
        return groupName;
    }

    public String getUsername() {
        return username;
    }
}
