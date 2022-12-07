package use_cases.view_pending_list_use_case;

import java.util.ArrayList;

/**
 * The response model for the view pending list use case.
 */

public class ViewPendingListResponseModel {
    String groupName;
    ArrayList<String> usernamesList;

    /**
     * @param usernamesList the list of the users who've applied to the group
     */
    public ViewPendingListResponseModel(String groupName, ArrayList<String> usernamesList) {
        this.groupName = groupName;
        this.usernamesList = usernamesList;
    }

    public ArrayList<String> getUsernamesList() {
        return this.usernamesList;
    }
    public String getGroupName() { return this.groupName; }

}
