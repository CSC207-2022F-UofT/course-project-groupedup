package interface_adapters.view_group_profile_adapters;

import java.util.HashMap;

/**
 * An interface with methods implemented by the "Group Profile" screen.
 */
public interface GroupProfileScreenBoundary {
    void setGroupName(String groupName);
    void setUsername(String username);
    void setViewGroupProfileController(ViewGroupProfileController viewGroupProfileController);
    void setGroupDescription(String description);
    void setGroupPreferences(HashMap<String, String> preferences);
    void initializeComponents();
    void buildScrollPane();
    void setComponents();
}
