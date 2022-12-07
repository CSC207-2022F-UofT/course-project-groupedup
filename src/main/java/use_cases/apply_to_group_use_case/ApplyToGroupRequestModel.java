package use_cases.apply_to_group_use_case;

/**
 * The request model for the Apply to Group use case
 */
public class ApplyToGroupRequestModel {
    private final String username;
    private final String groupName;

    /**
     * @param username the username of user applying to group
     * @param groupName the group name
     */
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

