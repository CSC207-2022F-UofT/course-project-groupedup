package Entities;
import java.io.Serializable;
import java.util.HashMap;

public class NormalGroup implements Serializable, Group {
    private String groupLeader;

    private HashMap<String, String> groupMembers; //maps username to username,

    //private GroupProfile groupProfile; //need Julia's GroupProfile Entity
    private String groupName;
    private HashMap<String, String> memberRequests;

    public NormalGroup(String groupName) {
        this.groupLeader = CurrentUser.getInstance().getUser().getUsername();
        this.groupName = groupName;
        this.memberRequests = new HashMap<>();
        this.groupMembers = new HashMap<>();
        groupMembers.put(groupLeader, groupLeader);

    }

    /**
     *
     * @return the group's unique group name
     */
    public String getGroupName() {
        return this.groupName;
    }



   public GroupProfile getProfile() {
        return groupProfile;
    }




    @Override
    public void removeMember(String username) {
        this.groupMembers.remove(username);
    }

    // return a map of actual user objects

    /**
     *
     * @param userMap a map (key: username, value: User) of all the existing Users in the system
     * @return a map of the group members' usernames to User objects
     */
    public HashMap<String, User> getGroupMembers(HashMap<String, User> userMap) {
        HashMap<String, User> membersMap = new HashMap<String, User>();
        for (String key : this.groupMembers.keySet()){
            membersMap.put(key, userMap.get(key));
        }
        return membersMap;
    }

    /**
     *
     * @return a hashmap (key: username, value: username) of the usernames of the Users in the Group.
     */
    public HashMap<String, String> getGroupMembersUsernames() {
        return groupMembers;
    }

    /**
     *
     * @return a hashmap (key: username, value: username) of the usernames of the Users who requested
     * to be in the Group.
     */
    public HashMap<String, String> getMemberRequestsUsernames() {
        return memberRequests;
    }


    //might be unnessecary if nobody uses it
    /**
     *
     * @param userMap a map (key: username, value: User) of all the existing Users in the system
     * @return a map (key: username, value: User) of the users who applied to be in this group
     */
    public HashMap<String, User> getMemberRequests(HashMap<String, User> userMap) {
        HashMap<String, User> requestersMap = new HashMap<String, User>();
        for (String key : this.memberRequests.keySet()){
            requestersMap.put(key, userMap.get(key));
        }
        return requestersMap;
    }

    //might be unnessecary if nobody uses it
    /**
     *
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
        this.memberRequests.remove(username);
    }

    /**
     *
     * @return the name of the User who is leading this group
     */
    @Override
    public String getGroupLeaderUsername() {
        return this.groupLeader;
    }


}
