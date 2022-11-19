package ApplyToGroup;
public class ApplyToGroupResponseModel {

    private final String username;
    private final String groupName;

    public ApplyToGroupResponseModel(String username, String groupName) {

        this.username = username;
        this.groupName = groupName;
    }

    public String getUsername() {
        return username;
    }
    public String getGroupName() {
        return groupName;
    }
}
