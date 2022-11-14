package group_creation_use_case;

import Entities.Group;
import Entities.NormalGroup;

public class GroupFactory {
    public Group create(String groupName){
        return new NormalGroup(groupName);
    }
}
