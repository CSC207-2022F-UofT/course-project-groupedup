package Edit_Group_Profile_Use_Case;
import Entities.Group;

import java.util.HashMap;

public class EditGroupProfileUseCase {

    private final String groupName;
    private final Group group;
    private HashMap<String, String> newPreferences;

    public EditGroupProfileUseCase(Group group, HashMap<String, String> newPreferences, String groupName) {
        this.group = group;
        this.newPreferences = newPreferences;
        this.groupName = groupName;
    }

    public void editPreferences() {
        /*Here I need to get the user entity from the userID but instead I just put the User entity will change later*/
        group.getGroupProfile().setPreferences(this.newPreferences);
    }
}
