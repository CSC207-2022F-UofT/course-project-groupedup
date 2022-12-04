package cancel_application_screens;

import java.util.HashMap;

/**
 * An interface with methods implemented by the "Group Profile" screen.
 */
public interface GroupProfileScreenBoundary {
    void setGroupName(String groupName);
    void setGroupDescription(String description);
    void setGroupPreferences(HashMap<String, String> preferences);
    void view();
    void initializeComponents();
    void buildScrollPane();
    void setComponents();
}
