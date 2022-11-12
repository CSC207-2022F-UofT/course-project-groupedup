package ApplyToGroup;

import Entities.Group;
import Entities.User;

import java.util.HashMap;

public class ApplyToGroupRequestModel {
    private int groupID;

    public ApplyToGroupRequestModel(Integer groupID) {
        this.groupID = groupID;
    }

    public int getGroupID() {
        return groupID;
    }

}

