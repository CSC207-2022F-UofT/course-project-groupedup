package entities;

import java.io.Serializable;
import java.util.HashMap;

public class NormalGroup implements Serializable, Group {
    private String groupLeader;

    private HashMap<String, String> groupMembers;

    private GroupProfile groupProfile;
    private String groupName;
    private HashMap<String, String> memberRequests;

    public NormalGroup(String groupName) {
        this.groupLeader = CurrentUser.getInstance().getUser().getUsername();
        this.groupName = groupName;
        this.memberRequests = new HashMap<>();
        this.groupMembers = new HashMap<>();
        groupMembers.put(groupLeader, groupLeader);
        this.groupProfile = new GroupProfile();

        User groupLeader = CurrentUser.getInstance().getUser();
        groupLeader.addGroup(groupName);
    }

    /**
     * @return the group's unique group name
     */
    public String getGroupName() {
        return this.groupName;
    }


    public GroupProfile getProfile() {
        return groupProfile;
    }


    /**
     * Removes the user from the list of the group's members
     *
     * @param username
     */
    @Override
    public void removeMember(String username) {
        this.groupMembers.remove(username);
    }


    /**
     * @param userMap a map (key: username, value: User) of all the existing Users in the system
     * @return a map of the group members' usernames to User objects
     */
    public HashMap<String, User> getGroupMembers(HashMap<String, User> userMap) {
        HashMap<String, User> membersMap = new HashMap<String, User>();
        for (String key : this.groupMembers.keySet()) {
            membersMap.put(key, userMap.get(key));
        }
        return membersMap;
    }

    /**
     * @return a hashmap (key: username, value: username) of the usernames of the Users in the Group.
     */
    public HashMap<String, String> getGroupMembersUsernames() {
        return groupMembers;
    }

    /**
     * @return a hashmap (key: username, value: username) of the usernames of the Users who requested
     * to be in the Group.
     */
    public HashMap<String, String> getMemberRequestsUsernames() {
        return memberRequests;
    }


    /**
     * @param userMap a map (key: username, value: User) of all the existing Users in the system
     * @return a map (key: username, value: User) of the users who applied to be in this group
     */
    public HashMap<String, User> getMemberRequests(HashMap<String, User> userMap) {
        HashMap<String, User> requestersMap = new HashMap<String, User>();
        for (String key : this.memberRequests.keySet()) {
            requestersMap.put(key, userMap.get(key));
        }
        return requestersMap;
    }


    /**
     * @param username of the User who wants to be the new Group Leader
     * @return whether the Group Leader was successfully changed or not
     */
    public boolean setGroupLeader(String username) {
        if (!groupMembers.containsKey(username)) {
            return false;
        }
        this.groupLeader = username;
        return true;
    }

    @Override
    public void removeApplication(String username) {

    }

    public void addMember(String username) {
        groupMembers.put(username, username);
    }


    /**
     * @return the name of the User who is leading this group
     */
    @Override
    public String getGroupLeaderUsername() {
        return this.groupLeader;
    }


    public void removeFromRequests(String username) {
        memberRequests.remove(username);
    }

    // added this for my test, will delete once I've merged with Ipek as she should've implemented this already

    public void addRequest(String username) {
        memberRequests.put(username, username);
    }

    @Override
    public void setGroupProfile(GroupProfile groupProfile) {
        this.groupProfile = groupProfile;
    }




    public void addMemberRequest(String username) {memberRequests.put(username, username);}

}
