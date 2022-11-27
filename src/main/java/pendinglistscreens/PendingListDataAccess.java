package pendinglistscreens;

import Entities.Group;
import Entities.User;
import editpendinglist.EditPendingListDsGateway;
import viewpendinglist.ViewPendingListDsGateway;

import java.io.*;
import java.util.HashMap;

public class PendingListDataAccess implements EditPendingListDsGateway, ViewPendingListDsGateway {

    private HashMap<String, Group> groupMap;
    private HashMap<String, User> userMap;

    public PendingListDataAccess(String username, User user, String groupName, Group group) {
        this.groupMap = new HashMap<>();
        groupMap.put(groupName, group);
        this.userMap = new HashMap<>();
        userMap.put(username, user);
    }

    @Override
    public boolean userIdentifierExists(String username) {
        return this.userMap.containsKey(username);
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
    public void updateUser(String username) {
        User user = getUser(username);
        this.userMap.replace(username, user);
    }

    @Override
    public void updateGroup(String groupName) {
        Group group = getGroup(groupName);
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
        return group.getMemberRequests(userMap).containsKey(groupName);
    }

    @Override
    public boolean groupInApplications(String groupName, String username) {
        User user = getUser(username);
        return user.getApplicationsList().containsKey(groupName);
    }
}
