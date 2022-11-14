package Entities;
import java.io.Serializable;
import java.util.HashMap;

public class Group implements Serializable, ObjectMap {
    private String groupLeader;
    private HashMap<String, String> groupMembers;
    //maps username to username,

//    private GroupProfile groupProfile;
    private String groupName;
    private HashMap<String, String> memberRequests;

    public Group(String groupName) {
//        this.groupLeader = CurrentUser.getInstance().getUser();
        this.groupLeader = "ahhhh";
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

//    public User getGroupLeader() {
//
//        return this.groupLeader;
//        return something.getusers.findusername
//    }

    // return a map of actual user objects
    public HashMap getGroupMembers() {
        return this.groupMembers;
    }

    public HashMap getMemberRequests() {
        return this.memberRequests;
    }

    public boolean setGroupLeader(String userID) {
        if (!groupMembers.containsKey(userID)) {
            return false;
        }
        this.groupLeader = groupMembers.get(userID);
        return true;
    }


}
