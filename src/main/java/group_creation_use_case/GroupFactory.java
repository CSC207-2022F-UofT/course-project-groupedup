package group_creation_use_case;

import Entities.Group;
import Entities.CurrentUser;

public class GroupFactory {
    public Group create(String groupName){
        return new Group(CurrentUser.getUser(), groupName);
    }
}
