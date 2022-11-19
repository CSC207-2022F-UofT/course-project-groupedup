package Entities;
import java.io.Serializable;
import java.util.HashMap;

public interface Group extends Serializable {

    String getGroupName();
    HashMap<String, User> getGroupMembers(HashMap<String, User> userMap);

    HashMap<String, User> getMemberRequests(HashMap<String, User> userMap);

    boolean setGroupLeader(String userID);
    void removeApplication(String username);
    String getGroupLeaderUsername();
    void removeMember(String username);
}
