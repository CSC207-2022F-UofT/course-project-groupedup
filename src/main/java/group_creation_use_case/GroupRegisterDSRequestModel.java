package group_creation_use_case;

import Entities.Group;

public class GroupRegisterDSRequestModel {

    private final Group group;

    private final String groupName;


    public GroupRegisterDSRequestModel(Group group, String groupName){
        this.group = group;
        this.groupName = groupName;
    }

    /**
     *
     * @return the Group
     */
    public Group getGroup() {
        return group;
    }

    /**
     *
     * @return the Group's name
     */
    public String getGroupName() {
        return groupName;
    }

}
