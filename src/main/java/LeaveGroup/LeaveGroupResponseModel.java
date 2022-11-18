package LeaveGroup;

public class LeaveGroupResponseModel {
    private final String username;
    private final String groupname;

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