package use_cases.view_group_profile_use_case;

import java.util.HashMap;

/**
 * The response model for the view group profile use case.
 */
public class ViewGroupProfileResponseModel {
    String groupName;
    String description;
    HashMap<String, String> preferences;
    public ViewGroupProfileResponseModel(String groupName, String description, HashMap<String, String> preferences) {
        this.groupName = groupName;
        this.description = description;
        this.preferences = preferences;
    }

    public HashMap<String, String> getPreferences() {
        return this.preferences;
    }

    public String getDescription() {
        return this.description;
    }

    public String getGroupName() {
        return this.groupName;
    }
}
