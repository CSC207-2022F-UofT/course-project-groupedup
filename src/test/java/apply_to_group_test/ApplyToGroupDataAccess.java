package apply_to_group_test;

import entities.Group;
import entities.User;
import use_cases.apply_to_group_use_case.ApplyToGroupDsGateway;

import java.util.HashMap;
/**
 * Simple imitation of SerializedDataAccess used for testing.
 */
public class ApplyToGroupDataAccess implements ApplyToGroupDsGateway {

    public HashMap<String, User> userMap;
    public HashMap<String, Group> groupMap;

    public ApplyToGroupDataAccess(HashMap<String, User> users, HashMap<String, Group> groups) {
        this.userMap = users;
        this.groupMap = groups;
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
    public Group getGroup(String groupName) {
        return groupMap.get(groupName);
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
    public HashMap<String, User> loadUsers() {
        return userMap;
    }

    @Override
    public boolean userInGroup(String username, String groupName) {
        Group group = groupMap.get(groupName);
        return (group.getGroupMembers(userMap).containsKey(username));
    }

    @Override
    public boolean userInMemberRequests(String username, String groupName) {
        Group group = groupMap.get(groupName);
        return group.getMemberRequests(userMap).containsKey(username);
    }

    @Override
    public boolean groupInApplications(String groupName, String username) {
        User user = userMap.get(username);
        return user.getApplicationsList().containsKey(groupName);
    }

    @Override
    public boolean groupInUser(String groupName, String username) {
        User user = userMap.get(username);
        return user.getGroups().containsKey(groupName);
    }

}
