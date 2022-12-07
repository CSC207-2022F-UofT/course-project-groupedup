package apply_to_group_use_case_test;

import entities.Group;
import entities.User;
import use_cases.apply_to_group_use_case.ApplyToGroupDsGateway;

import java.util.HashMap;

public class ApplyToGroupDataAccess implements ApplyToGroupDsGateway {

    public HashMap<String, User> userMap;
    public HashMap<String, Group> groupMap;

    public ApplyToGroupDataAccess(HashMap<String, User> users, HashMap<String, Group> groups) {
        this.userMap = users;
        this.groupMap = groups;
    }

    @Override
    public boolean groupExistsByName(String groupName) {
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
    public void updateUser(String username) {
        userMap.replace(username, userMap.get(username));
    }

    @Override
    public void updateGroup(String groupName) {
        groupMap.replace(groupName, groupMap.get(groupName));
    }

    @Override
    public HashMap<String, User> loadUsers() {
        return userMap;
    }

    @Override
    public HashMap<String, User> getUserMap() {
        return userMap;
    }

    @Override
    public boolean userInGroup(String username, String groupName) {
        Group group = groupMap.get(groupName);
        User user = userMap.get(username);
        return (group.getGroupMembers(userMap).containsKey(username) ||
                user.getGroups().containsKey(groupName));
    }

    @Override
    public boolean userInApplications(String username, String groupName) {
        Group group = groupMap.get(groupName);
        User user = userMap.get(username);
        return (group.getMemberRequests(userMap).containsKey(username) ||
                user.getApplicationsList().containsKey(groupName));
    }
}
