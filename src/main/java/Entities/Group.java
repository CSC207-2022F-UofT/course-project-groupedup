package Entities;

import java.io.Serializable;
import java.util.HashMap;

public interface Group extends Serializable {

    /**
     * @return the group's unique group name
     */
    public String getGroupName();

    /**
     * @param userMap a map (key: username, value: User) of all the existing Users in the system
     * @return a map of the group members' usernames to User objects
     */

    public HashMap<String, User> getGroupMembers(HashMap<String, User> userMap);

    /**
     * @param userMap a map (key: username, value: User) of all the existing Users in the system
     * @return a map (key: username, value: User) of the users who applied to be in this group
     */
    public HashMap<String, User> getMemberRequests(HashMap<String, User> userMap);

    /**
     * @param username of the User who wants to be the new Group Leader
     * @return whether the Group Leader was successfully changed or not
     */
    public boolean setGroupLeader(String username);

    public GroupProfile getProfile();


    void removeApplication(String username);

    String getGroupLeaderUsername();

    void removeMember(String username);

    public HashMap<String, String> getGroupMembersUsernames();

    public HashMap<String, String> getMemberRequestsUsernames();

    void addMember(String username);

    void removeFromRequests(String username);

    // added this for my test, will delete once I've merged with Ipek as she should've implemented this already
    void addRequest(String username);

}
