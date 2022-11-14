package CancelApplication;

public class CancelApplicationRequestModel {
    private final String username;
    private final String groupname;
    public CancelApplicationRequestModel(String username, String groupname) {
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
