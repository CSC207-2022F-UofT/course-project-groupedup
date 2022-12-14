package pending_list_tests;

import entities.Group;
import entities.User;
import use_cases.edit_pending_list_use_case.EditPendingListDsGateway;
import use_cases.view_group_members_use_case.ViewGroupMembersDsGateway;
import use_cases.view_pending_list_use_case.ViewPendingListDsGateway;

import java.util.HashMap;

/**
 * Simple imitation of SerializeDataAccess used only for the purpose of testing.
 */

public class PendingListDataAccess implements EditPendingListDsGateway, ViewPendingListDsGateway,
        ViewGroupMembersDsGateway {

    public HashMap<String, Group> groupMap;
    public HashMap<String, User> userMap;

    public PendingListDataAccess(HashMap<String, User> userMap, HashMap<String, Group> groupMap) {
        this.groupMap = groupMap;
        this.userMap = userMap;
    }

    @Override
    public boolean userIdentifierExists(String username) {
        return this.userMap.containsKey(username);
    }

    @Override
    public boolean groupIdentifierExists(String groupName) {
        return this.groupMap.containsKey(groupName);
    }

    @Override
    public User getUser(String username) {
        return userMap.get(username);
    }

    @Override
    public Group getGroup(String groupName) {
        return groupMap.get(groupName);
    }

    @Override
    public HashMap<String, User> loadUsers() {
        return userMap;
    }

    @Override
    public void updateUser(User user) {
        String username = user.getUsername();
        this.userMap.replace(username, user);
    }

    @Override
    public void updateGroup(Group group) {
        String groupName = group.getGroupName();
        this.groupMap.replace(groupName, group);
    }

    @Override
    public boolean userInGroup(String username, String groupName) {
        Group group = getGroup(groupName);
        return group.getGroupMembers(userMap).containsKey(username);
    }

    @Override
    public boolean groupInUser(String groupName, String username) {
        User user = getUser(username);
        return user.getGroups().containsKey(groupName);
    }

    @Override
    public boolean userInMemberRequests(String username, String groupName) {
        Group group = getGroup(groupName);
        return group.getMemberRequests(userMap).containsKey(username);
    }

    @Override
    public boolean groupInApplications(String groupName, String username) {
        User user = getUser(username);
        return user.getApplicationsList().containsKey(groupName);
    }
}
