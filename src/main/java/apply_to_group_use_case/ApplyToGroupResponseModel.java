package apply_to_group_use_case;

public class ApplyToGroupResponseModel {
    private String username;
    private String groupName;

    public ApplyToGroupResponseModel(String username, String groupName) {

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
