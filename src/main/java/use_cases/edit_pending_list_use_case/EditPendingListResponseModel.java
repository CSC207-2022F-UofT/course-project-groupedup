package use_cases.edit_pending_list_use_case;

/**
 * The response model for the edit pending list use case.
 */
public class EditPendingListResponseModel {
    private final String username;
    private final String groupName;

    /**
     * @param username the accepted/rejected user's username
     * @param groupName the group's name
     */
    public EditPendingListResponseModel(String username, String groupName) {
        this.username = username;
        this.groupName = groupName;
    }

    public String getUsername() {
        return this.username;
    }
    public String getGroupName() {return this.groupName; }
}