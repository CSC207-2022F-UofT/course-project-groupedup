package ApplyToGroup;

import Entities.Group;
import Entities.User;

import java.util.HashMap;

public class ApplyToGroupRequestModel {
    private String groupName;

    public ApplyToGroupRequestModel(String groupName) {
        this.groupName = groupName;
    }

    public String getGroupName() {
        return groupName;
    }

}

