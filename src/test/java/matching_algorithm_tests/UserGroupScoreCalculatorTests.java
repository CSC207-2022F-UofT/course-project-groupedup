package matching_algorithm_tests;


import Entities.*;
import matching_algorithm_use_case.UserGroupScoreCalculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

/**
 * Test whether the matching algorithm calculator
 */
public class UserGroupScoreCalculatorTests {

    /**
     * Test whether the calculator can caluclate the correct similarity score
     */
    @Test
    public void checkScore(){
        UserPublicProfile userPublicProfile = new UserPublicProfile();
        User user = new NormalUser("username", "password", "name", "emai@gmail.com",
                userPublicProfile);
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


        userPublicProfile.setPreferences(preferences1);
        userPublicProfile.setCoursePreferences("csc207, csc236");


        GroupProfile groupProfile = new GroupProfile();
        groupProfile.setPreferences(preferences2);
        Group group = new NormalGroup("group");
        group.setGroupProfile(groupProfile);

        UserGroupScoreCalculator userGroupScoreCalculator = new UserGroupScoreCalculator(user, group);
        Assertions.assertTrue((Math.abs(userGroupScoreCalculator.getScore() - 0.50) <0.00001));
    }

    /**
     * Test whether the userGroupSimilarityCalculator instances can be compared
     */
    @Test
    public void testComparison(){

        UserPublicProfile userPublicProfile = new UserPublicProfile();
        User user = new NormalUser("username", "password", "name", "emai@gmail.com",
                userPublicProfile);
        CurrentUser currentUser = CurrentUser.getInstance();
        currentUser.setUser(user);

        HashMap<String, String> preferences1 = new HashMap<>();
        preferences1.put("Remote or In-Person", "Remote");
        preferences1.put("Lays or Ruffles", "Ruffles");
        preferences1.put("Chocolate", "Yes");
        preferences1.put("Summer or Winter", "Summer");

        userPublicProfile.setPreferences(preferences1);
        userPublicProfile.setCoursePreferences("csc207, csc236");

        HashMap<String, String> preferences2 = new HashMap<>();
        preferences2.put("Remote or In-Person", "In-Person");
        preferences2.put("Lays or Ruffles", "Ruffles");
        preferences2.put("Chocolate", "No");
        preferences2.put("Summer or Winter", "Summer");


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

        UserGroupScoreCalculator userGroupScoreCalculator1 = new UserGroupScoreCalculator(user, group1);
        UserGroupScoreCalculator userGroupScoreCalculator2 = new UserGroupScoreCalculator(user, group2);
        UserGroupScoreCalculator userGroupScoreCalculator3 = new UserGroupScoreCalculator(user, group1);
        Assertions.assertEquals(-1, userGroupScoreCalculator1.compareTo(userGroupScoreCalculator2));
        Assertions.assertEquals(1, userGroupScoreCalculator2.compareTo(userGroupScoreCalculator1));
        Assertions.assertEquals(0, userGroupScoreCalculator1.compareTo(userGroupScoreCalculator3));
    }

    /**
     * Test similarity score if a group has no preferences
     */
    @Test
    public void testIfGroupHasNoPreferences(){
        UserPublicProfile userPublicProfile = new UserPublicProfile();
        User user = new NormalUser("username", "password", "name", "emai@gmail.com",
                userPublicProfile);
        HashMap<String, String> preferences1 = new HashMap<>();
        preferences1.put("Remote or In-Person", "Remote");
        preferences1.put("Lays or Ruffles", "Ruffles");
        preferences1.put("Chocolate", "Yes");
        preferences1.put("Summer or Winter", "Summer");
        user.getUserPublicProfile().setPreferences(preferences1);
        CurrentUser currentUser = CurrentUser.getInstance();
        currentUser.setUser(user);

        Group group5 = new NormalGroup("group1");

        UserGroupScoreCalculator userGroupScoreCalculator1 = new UserGroupScoreCalculator(user, group5);
        Assertions.assertEquals(0.0, userGroupScoreCalculator1.getScore());
    }
    /**
     * Test similarity score if a user has no preferences
     */
    @Test
    public void testIfUserHasNoPreferences(){
        UserPublicProfile userPublicProfile = new UserPublicProfile();
        User user = new NormalUser("username", "password", "name", "emai@gmail.com",
                userPublicProfile);
        HashMap<String, String> preferences1 = new HashMap<>();
        preferences1.put("Remote or In-Person", "Remote");
        preferences1.put("Lays or Ruffles", "Ruffles");
        preferences1.put("Chocolate", "Yes");
        preferences1.put("Summer or Winter", "Summer");

        CurrentUser currentUser = CurrentUser.getInstance();
        currentUser.setUser(user);

        Group group5 = new NormalGroup("group1");
        group5.getProfile().setPreferences(preferences1);
        UserGroupScoreCalculator userGroupScoreCalculator1 = new UserGroupScoreCalculator(user, group5);

        Assertions.assertEquals(0.0, userGroupScoreCalculator1.getScore());
    }

    /**
     * Test similarity score if group and user have no preferences. In this case, it will return 1
     */
    @Test
    public void testIfBothHaveNoPreferences(){
        UserPublicProfile userPublicProfile = new UserPublicProfile();
        User user = new NormalUser("username", "password", "name", "emai@gmail.com",
                userPublicProfile);

        CurrentUser currentUser = CurrentUser.getInstance();
        currentUser.setUser(user);

        Group group5 = new NormalGroup("group1");

        UserGroupScoreCalculator userGroupScoreCalculator1 = new UserGroupScoreCalculator(user, group5);

        Assertions.assertEquals(1.0, userGroupScoreCalculator1.getScore());
    }

    /**
     * Test the calculator's toString with score option
     */
    @Test
    public void testStringWithScore(){
        UserPublicProfile userPublicProfile = new UserPublicProfile();
        User user = new NormalUser("username", "password", "name", "emai@gmail.com",
                userPublicProfile);
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


        userPublicProfile.setPreferences(preferences1);
        userPublicProfile.setCoursePreferences("csc207, csc236");


        GroupProfile groupProfile = new GroupProfile();
        groupProfile.setPreferences(preferences2);
        Group group = new NormalGroup("group");
        group.setGroupProfile(groupProfile);

        UserGroupScoreCalculator userGroupScoreCalculator = new UserGroupScoreCalculator(user, group);
        Assertions.assertEquals("0.5 no code: group", userGroupScoreCalculator.toStringWithScore());

        group.getProfile().setCourseCode("csc258");

        Assertions.assertEquals("0.5 csc258: group", userGroupScoreCalculator.toStringWithScore());
    }
}
