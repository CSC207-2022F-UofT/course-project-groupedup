package cancel_application_tests;

import entities.Group;
import entities.User;
import use_cases.cancel_application_use_case.CancelApplicationDsGateway;
import use_cases.view_group_profile_use_case.ViewGroupProfileDsGateway;
import use_cases.view_user_applications_use_case.ViewApplicationsListDsGateway;

import java.util.HashMap;

/**
 * Simple imitation of SerializedDataAccess used only for the purpose of testing.
 */

public class CancelApplicationDataAccess implements CancelApplicationDsGateway,
        ViewApplicationsListDsGateway, ViewGroupProfileDsGateway {

    public HashMap<String, User> userMap;
    public HashMap<String, Group> groupMap;

    public CancelApplicationDataAccess(HashMap<String, User> users, HashMap<String, Group> groups) {
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
    public boolean userIdentifierExists(String username) {
        return userMap.containsKey(username);
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
    public HashMap<String, User> loadUsers() {
        return userMap;
    }
}
