package use_cases.group_creation_use_case;

import entities.Group;

/**
 * A data bundle which is passed to the database. This is the information which
 * should be stored in the database, after the group creation use case is completed.
 */
public class GroupRegisterDSRequestModel {

    private final Group group;

    private final String groupName;


    public GroupRegisterDSRequestModel(Group group, String groupName){
        this.group = group;
        this.groupName = groupName;
    }


    public Group getGroup() {
        return group;
    }

    public String getGroupName() {
        return groupName;
    }

}
