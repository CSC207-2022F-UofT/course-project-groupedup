package group_creation_use_case;

import Entities.Group;

public class GroupFactory {
    public Group create(String groupName){
        return new Group(groupName);
    }
}
