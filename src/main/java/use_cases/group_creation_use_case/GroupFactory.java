package use_cases.group_creation_use_case;

import entities.Group;
import entities.NormalGroup;

/**
 * This is a group factory which will create a group object.
 * Although right now it is very simple because it only needs to take in a group name to create
 * a group, in the future this design pattern would be useful if there is more data
 * necessary to create a group. Right now, the requirements are very small for making a group.
 * A future extension could be making the user input more mandatory information to make a group,
 * which would make this group factory more useful.
 */
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
