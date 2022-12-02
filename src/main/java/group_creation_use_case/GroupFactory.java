package group_creation_use_case;

import Entities.Group;
import Entities.NormalGroup;

public class GroupFactory {
    /**
     * Creates a Group object.
     * @param groupName
     * @return
     */
    public Group create(String groupName){
        return new NormalGroup(groupName);
    }
}
