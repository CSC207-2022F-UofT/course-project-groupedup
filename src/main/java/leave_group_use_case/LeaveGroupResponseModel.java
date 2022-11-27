package leave_group_use_case;

public class LeaveGroupResponseModel {
    private final String username;
    private final String groupname;
    private final String message;

    /**
     * @param username the username of the current user
     * @param groupname the groupname of the group the user is leaving
     */
    public LeaveGroupResponseModel(String username, String groupname, String message) {
        this.username = username;
        this.groupname = groupname;
        this.message = message;
    }

    public String getUsername() {
        return username;
    }

    public String getGroupname() {
        return groupname;
    }

    public String getMessage() { return message;}
}