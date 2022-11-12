package ApplyToGroup;

import Entities.Group;
import Entities.User;

public class ApplyToGroupResponseModel {

    private User user;
    private Group group;

    public ApplyToGroupResponseModel(User user, Group group) {

        this.user = user;
        this.group = group;
    }
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }
}
