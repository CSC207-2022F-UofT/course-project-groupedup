
package nonUsecaseTests;

import entities.*;
import use_cases.group_creation_use_case.GroupRegisterDSRequestModel;
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
        TestGroupSerialize REAAAADD = new TestGroupSerialize();
        GroupRegisterDSRequestModel help = new GroupRegisterDSRequestModel(group, group.getGroupName());
        REAAAADD.saveNewGroups(help);
        HashMap<String, Group> newGroups = REAAAADD.loadGroups();
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
        TestGroupSerialize REAAAADD = new TestGroupSerialize();
        GroupRegisterDSRequestModel help1 = new GroupRegisterDSRequestModel(group1, group1.getGroupName());
        REAAAADD.saveNewGroups(help1);
        GroupRegisterDSRequestModel help2 = new GroupRegisterDSRequestModel(group2, group2.getGroupName());
        REAAAADD.saveNewGroups(help2);
        HashMap<String, Group> newGroups = REAAAADD.loadGroups();
        Group newGroup1 = newGroups.get(group1.getGroupName());
        Group newGroup2 = newGroups.get(group2.getGroupName());
        System.out.println(group1.getGroupName());
        System.out.println(newGroup1.getGroupName());
        System.out.println(group2.getGroupName());
        System.out.println(newGroup2.getGroupName());
        assert newGroup2.getGroupName().equals(group2.getGroupName()) && newGroup1.getGroupName().equals(group1.getGroupName());
    }

}
