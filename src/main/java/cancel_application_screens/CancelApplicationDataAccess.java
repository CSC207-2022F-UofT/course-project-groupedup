package cancel_application_screens;

import Entities.Group;
import Entities.User;
import cancel_application_use_case.CancelApplicationDsGateway;
import view_user_applications_use_case.ViewApplicationsListDsGateway;

import java.util.HashMap;

/**
 * Simple imitation of SerializedDataAccess used only for the purpose of testing
 */

public class CancelApplicationDataAccess implements CancelApplicationDsGateway, ViewApplicationsListDsGateway {

    private HashMap<String, User> userMap;
    private HashMap<String, Group> groupMap;

    public CancelApplicationDataAccess(String username, User user, String groupName, Group group) {
        this.userMap = new HashMap<>();
        userMap.put(username, user);
        this.groupMap = new HashMap<>();
        groupMap.put(groupName, group);
    }

    @Override
    public boolean groupIdentifierExists(String groupName) {
        return groupMap.containsKey(groupName);
    }

    @Override
    public User getUser(String username) {
        return userMap.get(username);
    }

    @Override
    public Group getGroup(String groupname) {
        return groupMap.get(groupname);
    }

    @Override
    public void updateUser(User user) {
        String username = user.getUsername();
        userMap.replace(username, user);
    }

    @Override
    public void updateGroup(Group group) {
        String groupName = group.getGroupName();
        groupMap.replace(groupName, group);
    }

    @Override
    public boolean userInGroupPendingList(String username, String groupName) {
        Group group = groupMap.get(groupName);
        return group.getMemberRequests(userMap).containsKey(username);
    }

    @Override
    public boolean groupInUserApplicationsList(String username, String groupName) {
        User user = userMap.get(username);
        return user.getApplicationsList().containsKey(groupName);
    }

    @Override
    public HashMap<String, User> loadUsers() {
        return userMap;
    }
}
