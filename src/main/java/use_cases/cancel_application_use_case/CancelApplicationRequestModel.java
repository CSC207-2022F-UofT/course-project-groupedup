package use_cases.cancel_application_use_case;

/**
 * The request model for the cancel application use case.
 */
public class CancelApplicationRequestModel {
    private final String username;
    private final String groupName;

    /**
     * @param username the username of the current user
     * @param groupname the groupname of the group for which the user is cancelling their application
     */
    public CancelApplicationRequestModel(String username, String groupname) {
        this.username = username;
        this.groupName = groupname;
    }

    public String getGroupName() {
        return groupName;
    }

    public String getUsername() {
        return username;
    }
}
