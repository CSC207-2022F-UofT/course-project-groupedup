package Entities;
import java.io.Serializable;
import java.util.HashMap;

public interface Group extends Serializable {

    public String getGroupName();
    public HashMap<String, User> getGroupMembers(HashMap<String, User> userMap);

    public HashMap<String, User> getMemberRequests(HashMap<String, User> userMap);

    public boolean setGroupLeader(String userID);

    public void addMember(User user);
    public void removeFromRequests(User user);
}
