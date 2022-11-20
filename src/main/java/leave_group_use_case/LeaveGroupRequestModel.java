package leave_group_use_case;

public class LeaveGroupRequestModel {
    private final String username;
    private final String groupname;

    /**
     * @param username the username of the current user
     * @param groupname the groupname of the group the user is leaving
     */
    public LeaveGroupRequestModel(String username, String groupname) {
        this.username = username;
        this.groupname = groupname;
    }

    public String getGroupname() {
        return groupname;
    }

    public String getUsername() {
        return username;
    }
}
