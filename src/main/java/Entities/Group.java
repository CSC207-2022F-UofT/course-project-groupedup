package Entities;
import java.io.Serializable;
import java.util.HashMap;

public interface Group extends Serializable {

    String getGroupName();
    HashMap<String, User> getGroupMembers(HashMap<String, User> userMap);

    HashMap<String, User> getMemberRequests(HashMap<String, User> userMap);

    boolean setGroupLeader(String userID);
    String getGroupLeaderUsername();
    void removeMember(String username);
    void addMember(String username);
    void removeFromRequests(String username);
    // added this for my test, will delete once I've merged with Ipek as she should've implemented this already
    void addRequest(String username);
    void addMemberRequest(String username);
}
