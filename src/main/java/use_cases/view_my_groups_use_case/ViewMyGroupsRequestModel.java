package use_cases.view_my_groups_use_case;

/**
 * The request model for the view my groups use case.
 */
public class ViewMyGroupsRequestModel {
    private final String username;

    public ViewMyGroupsRequestModel(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
}
