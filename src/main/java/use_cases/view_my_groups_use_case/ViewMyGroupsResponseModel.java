package use_cases.view_my_groups_use_case;

import java.util.HashMap;

/**
 * The response model for the view my groups use case.
 */
public class ViewMyGroupsResponseModel {
    private final String username;
    private final HashMap<String, Boolean> groupAndStatus;

    /**
     * @param username the username of the current user
     * @param groupAndStatus a map of (groupName, userStatus) where userStatus is a boolean
     *                       declaring whether the current user is a group leader for groupName
     */
    public ViewMyGroupsResponseModel(String username, HashMap<String, Boolean> groupAndStatus) {
        this.username = username;
        this.groupAndStatus = groupAndStatus;
    }

    public String getUsername() {
        return username;
    }

    public HashMap<String, Boolean> getGroupAndStatus() {
        return groupAndStatus;
    }
}
