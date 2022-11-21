package apply_to_group_use_case;

public class ApplyToGroupRequestModel {
    private final String username;
    private final String groupName;

    public ApplyToGroupRequestModel(String username, String groupName) {
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

