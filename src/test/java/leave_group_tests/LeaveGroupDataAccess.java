package leave_group_tests;

import entities.Group;
import entities.User;
import use_cases.leave_group_use_case.LeaveGroupDsGateway;
import use_cases.view_group_profile_use_case.ViewGroupProfileDsGateway;
import use_cases.view_my_groups_use_case.ViewMyGroupsDsGateway;

import java.util.HashMap;

/**
 * Simple imitation of SerializedDataAccess used only for the purpose of testing
 */
public class LeaveGroupDataAccess implements LeaveGroupDsGateway,
        ViewMyGroupsDsGateway, ViewGroupProfileDsGateway {

    private final HashMap<String, User> userMap;
    private final HashMap<String, Group> groupMap;

    public LeaveGroupDataAccess(HashMap<String, User> users, HashMap<String, Group> groups) {
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
    public boolean userIdentifierExists(String username) {
        return userMap.containsKey(username);
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
    public boolean userInGroup(String username, String groupName) {
        Group group = groupMap.get(groupName);
        return group.getGroupMembers(userMap).containsKey(username);
    }

    @Override
    public boolean groupInUser(String groupName, String username) {
        User user = userMap.get(username);
        return user.getGroups().containsKey(groupName);
    }

    @Override
    public HashMap<String, User> loadUsers() {
        return userMap;
    }
}
