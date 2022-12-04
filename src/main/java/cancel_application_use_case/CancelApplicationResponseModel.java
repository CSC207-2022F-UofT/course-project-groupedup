package cancel_application_use_case;

/**
 * The response model for the cancel application use case.
 */
public class CancelApplicationResponseModel {
    private final String username;
    private final String groupname;

    /**
     * @param username the username of the current user
     * @param groupname the groupname of the group for which the user is cancelling their application
     */
    public CancelApplicationResponseModel(String username, String groupname) {
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
