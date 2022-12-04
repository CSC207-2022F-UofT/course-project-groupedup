package view_user_applications_use_case;

import java.util.ArrayList;

/**
 * The response model for the view applications use case.
 */
public class ViewApplicationsListResponseModel {
    String username;
    ArrayList<String> applicationsList;

    /**
     * @param applicationsList the user's pending list of applications to groups
     */
    public ViewApplicationsListResponseModel(String username, ArrayList<String> applicationsList) {
        this.username = username;
        this.applicationsList = applicationsList;
    }

    public ArrayList<String> getApplicationsList() {
        return applicationsList;
    }
    public String getUsername() {
        return this.username;
    }
}
