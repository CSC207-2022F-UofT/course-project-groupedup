package leave_group_use_case;

/**
 * The response model for the leave group use case.
 */
public class LeaveGroupResponseModel {
    private final String username;
    private final String groupname;

    /**
     * @param username the username of the current user
     * @param groupname the groupname of the group the user is leaving
     */
    public LeaveGroupResponseModel(String username, String groupname) {
        this.username = username;
        this.groupname = groupname;
    }

    public String getUsername() {
        return username;
    }

    public String getGroupname() {
        return groupname;
    }
}