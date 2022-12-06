package use_cases.view_group_profile_use_case;

/**
 * The request model for the view group profile use case.
 */
public class ViewGroupProfileRequestModel {
    private final String groupName;

    public ViewGroupProfileRequestModel(String groupName) {
        this.groupName = groupName;
    }

    public String getGroupName() {
        return groupName;
    }
}
