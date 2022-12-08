package matching_algorithm_tests;

import entities.*;
import use_cases.matching_algorithm_use_case.MatchingAlgorithmDsGateWay;

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
        user.getUserPublicProfile().setPreferences(preferences1);
        this.user = user;

        return user;
    }

    @Override
    public HashMap<String, Group> loadGroups() {
        User groupLeader = new NormalUser("groupLeader", "pass","leader", "@leader",
                new UserPublicProfile());

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


        Group group1 = new NormalGroup("group1");
        group1.getProfile().setPreferences(preferences2);
        group1.getProfile().setCourseCode("csc207");
        group1.addMember("leader");
        group1.setGroupLeader("leader");
        group1.removeMember("username");


        Group group2 = new NormalGroup("group2");
        group2.getProfile().setCourseCode("csc236");
        group2.getProfile().setPreferences(preferences1);
        group2.addMember("leader");
        group2.setGroupLeader("leader");
        group2.removeMember("username");

        //test if wrong course code was removed
        Group group3 = new NormalGroup("group3");
        group3.getProfile().setCourseCode("csc258");
        group3.getProfile().setPreferences(preferences3);
        group3.addMember("leader");
        group3.setGroupLeader("leader");
        group3.removeMember("username");

        //Test if no course code was removed
        Group group4 = new NormalGroup("group 4");


        //Test if the user is a member is removed
        Group group5 = new NormalGroup("group 5");
        group5.addMember("username");
        group5.getProfile().setCourseCode("csc236");
        group5.getProfile().setPreferences(preferences1);
        group5.addMember("leader");
        group5.setGroupLeader("leader");


        //Test if the user has already requested to join group is removed
        Group group6 = new NormalGroup("group 6");
        group6.addMemberRequest("username");
        group6.getProfile().setCourseCode("csc236");
        group6.getProfile().setPreferences(preferences1);
        group6.addMember("leader");
        group6.setGroupLeader("leader");
        group6.removeMember("username");

        //Test if user as group leader is removed
        Group group7 = new NormalGroup("group 7");
        group7.getProfile().setCourseCode("csc236");
        group7.setGroupLeader("username");
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
