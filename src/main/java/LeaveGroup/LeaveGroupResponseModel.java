package LeaveGroup;

import Entities.Group;
import Entities.User;

public class LeaveGroupResponseModel {
    private User user;
    private Group group;

    public LeaveGroupResponseModel(User user, Group group) {

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
