package view_user_applications_use_case;

import java.util.ArrayList;

public class ViewApplicationsListResponseModel {
    ArrayList<String> applicationsList;

    /**
     * @param applicationsList the user's pending list of applications to groups
     */
    public ViewApplicationsListResponseModel(ArrayList<String> applicationsList) {
        this.applicationsList = applicationsList;
    }

    public ArrayList<String> getApplicationsList() {
        return applicationsList;
    }
}
