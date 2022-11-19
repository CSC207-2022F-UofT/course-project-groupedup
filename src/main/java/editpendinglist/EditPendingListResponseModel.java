package editpendinglist;

public class EditPendingListResponseModel {
    // TODO: figure out what parameters are required to create relevant screens
    // My response model might actually not have to do anything besides send a string saying success? Or nothing at all
    private String username;
    private String groupName;

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