package Entities;
import java.io.Serializable;
import java.util.HashMap;

public class NormalGroup implements Serializable, Group {
    private String groupLeader;
    private HashMap<String, String> groupMembers; //maps username to username,

    // private GroupProfile groupProfile; //need Julia's GroupProfile Entity
    private String groupName;
    private HashMap<String, String> memberRequests;

    public NormalGroup(String groupName) {
        this.groupLeader = CurrentUser.getInstance().getUser().getUsername();
        this.groupName = groupName;
        this.memberRequests = new HashMap<>();
        this.groupMembers = new HashMap<>();
        groupMembers.put(groupLeader, groupLeader);

    }

    public String getGroupName() {
        return this.groupName;
    }


//    public GroupProfile getGroupProfile() {
//        return groupProfile;
//    }

    public String getGroupLeaderName() {

        return this.groupLeader;
    }

    // return a map of actual user objects

    /**
     *
     * @param userMap a map (key: username, value: User) of all the existing Users
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
     * @param userMap a map (key: username, value: User) of all the existing Users
     * @return a map of the users who applied to be in the group
     */
    public HashMap<String, User> getMemberRequests(HashMap<String, User> userMap) {
        HashMap<String, User> requestersMap = new HashMap<String, User>();
        for (String key : this.memberRequests.keySet()){
            requestersMap.put(key, userMap.get(key));
        }
        return requestersMap;
    }

    public boolean setGroupLeader(String username) {
        if (!groupMembers.containsKey(username)) {
            return false;
        }
        this.groupLeader = username;
        return true;
    }

    public void addMember(User user) {
        groupMembers.put(user.getUsername(), user.getUsername());
    }

    public void removeFromRequests(User user) {
        memberRequests.remove(user.getUsername());
    }

}
