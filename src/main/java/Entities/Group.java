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

    // duplicate with Sharon's method. added this for my test, will delete once Ipek's PR is merged
    void addRequest(String username);

    // duplicate with other methods. added this for my test, will delete once other methods are merged
    void addMember(String username);
}
