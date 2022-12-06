package matching_algorithm_screens;

import Entities.*;
import matching_algorithm_use_case.MatchingAlgorithmDsGateWay;

import java.util.HashMap;

/**
 * Mock repo for successful Matching Algorithm testing
 */
public class InMemoryMatchesSuccess implements MatchingAlgorithmDsGateWay {
    User user;

    public InMemoryMatchesSuccess(){

    }

    @Override
    public User getUser(String username) {
        UserPublicProfile userPublicProfile = new UserPublicProfile();
        User user = new NormalUser("username", "password", "name", "emai@gmail.com",
                userPublicProfile);
        HashMap<String, String> preferences1 = new HashMap<>();
        preferences1.put("Remote or In-Person", "Remote");
        preferences1.put("Lays or Ruffles", "Ruffles");
        preferences1.put("Chocolate", "Yes");
        preferences1.put("Summer or Winter", "Summer");
        user.getUserPublicProfile().setCoursePreferences("csc236, csc207");
        this.user = user;

        return user;
    }

    @Override
    public HashMap<String, Group> loadGroups() {
        CurrentUser currentUser = CurrentUser.getInstance();
        currentUser.setUser(user);
        HashMap<String, String> preferences1 = new HashMap<>();
        preferences1.put("Remote or In-Person", "Remote");
        preferences1.put("Lays or Ruffles", "Ruffles");
        preferences1.put("Chocolate", "Yes");
        preferences1.put("Summer or Winter", "Summer");

        HashMap<String, String> preferences2 = new HashMap<>();
        preferences2.put("Remote or In-Person", "In-Person");
        preferences2.put("Lays or Ruffles", "Ruffles");
        preferences2.put("Chocolate", "No");
        preferences2.put("Summer or Winter", "Summer");

        HashMap<String, String> preferences3 = new HashMap<>();
        preferences3.put("Remote or In-Person", "In-Person");
        preferences3.put("Lays or Ruffles", "Lays");
        preferences3.put("Chocolate", "No");
        preferences3.put("Test" , "Test");


        GroupProfile groupProfile1 = new GroupProfile();
        groupProfile1.setPreferences(preferences2);
        groupProfile1.setCourseCode("csc207");
        Group group1 = new NormalGroup("group1");
        group1.setGroupProfile(groupProfile1);

        GroupProfile groupProfile2 = new GroupProfile();
        Group group2 = new NormalGroup("group2");
        group2.setGroupProfile(groupProfile2);
        group2.getProfile().setCourseCode("csc236");
        group2.getProfile().setPreferences(preferences1);

        GroupProfile groupProfile3 = new GroupProfile();
        Group group3 = new NormalGroup("group3");
        group3.setGroupProfile(groupProfile3);
        group3.getProfile().setCourseCode("csc258");
        group3.getProfile().setPreferences(preferences3);

        GroupProfile groupProfile4 = new GroupProfile();
        Group group4 = new NormalGroup("group 4");
        group4.setGroupProfile(groupProfile4);

        //Test if the user is a member is removed
        GroupProfile groupProfile5 = new GroupProfile();
        Group group5 = new NormalGroup("group 5");
        group5.addMember("username");
        group5.setGroupProfile(groupProfile5);
        group5.getProfile().setPreferences(preferences1);

        //Test if the user has already requested to join group is removed
        GroupProfile groupProfile6 = new GroupProfile();
        Group group6 = new NormalGroup("group 6");
        group6.addMemberRequest("username");
        group6.setGroupProfile(groupProfile6);
        group6.getProfile().setPreferences(preferences1);

        //Test if user as group leader is removed
        GroupProfile groupProfile7 = new GroupProfile();
        Group group7 = new NormalGroup("group 6");
        group7.setGroupLeader("username");
        group7.setGroupProfile(groupProfile7);
        group7.getProfile().setPreferences(preferences1);


        HashMap<String, Group> groupHashMap = new HashMap<>();
        groupHashMap.put("group1", group1);
        groupHashMap.put("group2", group2);
        groupHashMap.put("group3", group3);
        groupHashMap.put("group4", group4);
        groupHashMap.put("group5", group5);
        groupHashMap.put("group6", group6);
        groupHashMap.put("group7", group7);
        return groupHashMap;
    }
}
