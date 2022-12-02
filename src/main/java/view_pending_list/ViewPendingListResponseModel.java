package view_pending_list;

import java.util.ArrayList;

/**
 * The response model for the view pending list use case.
 */

public class ViewPendingListResponseModel {
    ArrayList<String> usernamesList;

    /**
     * @param usernamesList the list of the users who've applied to the group
     */
    public ViewPendingListResponseModel(ArrayList<String> usernamesList) {
        this.usernamesList = usernamesList;
    }

    public ArrayList<String> getUsernamesList() {
        return this.usernamesList;
    }

}
