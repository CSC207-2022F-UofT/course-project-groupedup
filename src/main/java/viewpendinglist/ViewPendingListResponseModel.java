package viewpendinglist;

import java.util.ArrayList;

public class ViewPendingListResponseModel {
    ArrayList<String> usernamesList;
    public ViewPendingListResponseModel(ArrayList<String> usernamesList) {
        this.usernamesList = usernamesList;
    }

    public ArrayList<String> getUsernamesList() {
        return this.usernamesList;
    }

}
