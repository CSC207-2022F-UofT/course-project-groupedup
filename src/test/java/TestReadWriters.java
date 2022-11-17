import Entities.*;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.HashMap;

public class TestReadWriters {
    @Test
    public void testSaverReadGroup()
            throws IOException, ClassNotFoundException {

        // the word help and similar phrases are included to show flavour of our struggle when testing
        CurrentUser currentUser1 = CurrentUser.getInstance();
        UserPublicProfile testProfile = new UserPublicProfile();
        User testUser = new NormalUser("testUser", "testUser", "testUser", "testUser",
                testProfile);
        currentUser1.setUser(testUser);
        Group group = new NormalGroup("please work");
        GroupReadWriter REAAAADD = new GroupReadWriter();
        HashMap<String, Group> help = new HashMap<String, Group>();
        help.put(group.getGroupName(), group);
        REAAAADD.saveToFile("database/testing_folder/testGroup.ser", help);
        HashMap<String, Group> newGroups = (HashMap<String, Group>) REAAAADD.readFromFile("database/testing_folder/testGroup.ser");
        Group newGroup = newGroups.get(group.getGroupName());
        System.out.println(group.getGroupName());
        System.out.println(newGroup.getGroupName());
        assert newGroup.getGroupName().equals(group.getGroupName());
    }

    @Test
    public void testSaverReadMultipleGroups()
            throws IOException, ClassNotFoundException {

        CurrentUser currentUser1 = CurrentUser.getInstance();
        UserPublicProfile testProfile = new UserPublicProfile();
        User testUser = new NormalUser("testUser", "testUser", "testUser", "testUser",
                testProfile);
        currentUser1.setUser(testUser);
        Group group1 = new NormalGroup("please work");
        Group group2 = new NormalGroup("let's make sure this works");
        GroupReadWriter REAAAADD = new GroupReadWriter();
        HashMap<String, Group> help = new HashMap<String, Group>();
        help.put(group1.getGroupName(), group1);
        help.put(group2.getGroupName(), group2);
        REAAAADD.saveToFile("database/testing_folder/testGroup.ser", help);
        HashMap<String, Group> newGroups = REAAAADD.readFromFile("database/testing_folder/testGroup.ser");
        Group newGroup1 = newGroups.get(group1.getGroupName());
        Group newGroup2 = newGroups.get(group2.getGroupName());
        System.out.println(group1.getGroupName());
        System.out.println(newGroup1.getGroupName());
        System.out.println(group2.getGroupName());
        System.out.println(newGroup2.getGroupName());
        assert newGroup2.getGroupName().equals(group2.getGroupName()) && newGroup1.getGroupName().equals(group1.getGroupName());
    }

    @Test
    public void testSaverReadUser()
            throws IOException, ClassNotFoundException {

        // the word help and similar phrases are included to show flavour of our struggle when testing
        UserPublicProfile testProfile = new UserPublicProfile();
        User testUser = new NormalUser("testUser", "testUser", "testUser", "testUser",
                testProfile);
        UserReadWriter REAAAADD = new UserReadWriter();
        HashMap<String, User> users = new HashMap<String, User>();
        users.put(testUser.getName(), testUser);
        REAAAADD.saveToFile("database/testing_folder/testUser.ser", users);
        HashMap<String, User> newGroups = (HashMap<String, User>) REAAAADD.readFromFile("database/testing_folder/testUser.ser");
        User newUser = users.get(testUser.getUsername());
        System.out.println(testUser.getUsername());
        System.out.println(newUser.getUsername());
        assert testUser.getUserPublicProfile() == newUser.getUserPublicProfile();
    }

}
