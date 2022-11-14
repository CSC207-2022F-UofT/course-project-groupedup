package ApplyToGroup;

import Entities.Group;
import Entities.User;

public class ApplyToGroupResponseModel {

    private User user;
    private Group group;

    public ApplyToGroupResponseModel(User user, Group group) {

        this.user = user;
        this.group = group;
    //}
    //public User getUser() {
    //    return user;
    //}

    //public void setUser(User user) {
     //   this.user = user;
    //}

    //public String getGroupName() {
    //    return group.getGroupName();
    //}

    //public void setGroupName(String groupName) {
    //    this.groupName = group;
    //}
}
