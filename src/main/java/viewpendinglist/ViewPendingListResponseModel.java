package viewpendinglist;

import java.util.ArrayList;

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
