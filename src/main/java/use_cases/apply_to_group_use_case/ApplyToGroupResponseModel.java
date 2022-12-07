package use_cases.apply_to_group_use_case;

/**
 * The response model for the Apply to Group use case
 */

public class ApplyToGroupResponseModel {
    private String username;
    private String groupName;

    /**
     * @param username the username of user applying to group
     * @param groupName the group name
     */
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
