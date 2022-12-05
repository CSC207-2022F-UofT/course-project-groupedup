package view_user_applications_use_case;

/**
 * The request model for the view applications use case.
 */
public class ViewApplicationsListRequestModel {
    private final String username;
    public ViewApplicationsListRequestModel(String username) {
        this.username = username;
    }
    public String getUsername() {
        return username;
    }
}
