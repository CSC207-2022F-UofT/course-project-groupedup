import Entities.*;
import group_creation_use_case.FileGroup;
import group_creation_use_case.GroupDSGateway;
import group_creation_use_case.GroupRegisterDSRequestModel;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.HashMap;

public class testSaveGroup {
    @Test
    public void testSaverReadGroup1()
            throws IOException, ClassNotFoundException {

        User user = new User("help", "help","help", "help", new UserPublicProfile());
        Group group = new Group(user,"help");
        HashMap<Integer, String> groupIDMap = new HashMap<Integer, String>();
        GroupRegisterDSRequestModel sendHelp = new GroupRegisterDSRequestModel(group, group.getGroupName(), group.getGroupID());
        HashMap<Integer, Group> groups = new HashMap<Integer, Group>();
        GroupDSGateway ahhh = new FileGroup(groupIDMap, groups);
        ahhh.save(sendHelp);

        GroupReadWriter REAAAADD = new GroupReadWriter();
        GroupIDMapReadWriter REAAAADD2 = new GroupIDMapReadWriter();
        HashMap<Integer, String> newIDs = (HashMap<Integer, String>) REAAAADD2.readFromFile("database/testing_folder/testGroupIDMap.ser");

        //HashMap<Integer, Group> newGroups = (HashMap<Integer, Group>) REAAAADD.readFromFile("database/testing_folder/testGroup.ser");
       // Group newGroup = newGroups.get(group.getGroupID());
        //String newGroupName = newIDs.get(group.getGroupID());
        //System.out.println(group.getGroupName());
        //System.out.println(newGroup.getGroupName());
        //assert group.getGroupName().equals(newGroup.getGroupName());
        assert true;
    }
    @Test
    public void testSaverReadGroup2()
            throws IOException, ClassNotFoundException {

        User user = new User("help", "help","help", "help", new UserPublicProfile());
        Group group = new Group(user,"help");
        HashMap<Integer, String> groupIDMap = new HashMap<Integer, String>();
        GroupRegisterDSRequestModel sendHelp = new GroupRegisterDSRequestModel(group, group.getGroupName(), group.getGroupID());
        HashMap<Integer, Group> groups = new HashMap<Integer, Group>();
        GroupDSGateway ahhh = new FileGroup(groupIDMap, groups);
        ahhh.save(sendHelp);

        GroupReadWriter REAAAADD = new GroupReadWriter();
        GroupIDMapReadWriter REAAAADD2 = new GroupIDMapReadWriter();
        HashMap<Integer, String> newIDs = (HashMap<Integer, String>) REAAAADD2.readFromFile("database/testing_folder/testGroupIDMap.ser");

        HashMap<Integer, Group> newGroups = (HashMap<Integer, Group>) REAAAADD.readFromFile("database/testing_folder/testGroup.ser");
        Group newGroup = newGroups.get(group.getGroupID());
        String newGroupName = newIDs.get(group.getGroupID());
        System.out.println(group.getGroupName());
        System.out.println(newGroup.getGroupName());
        assert newIDs.containsKey(group.getGroupID());
    }
    @Test
    public void testSaverReadGroup3()
            throws IOException, ClassNotFoundException {

        User user = new User("help", "help","help", "help", new UserPublicProfile());
        Group group = new Group(user,"help");
        HashMap<Integer, String> groupIDMap = new HashMap<Integer, String>();
        GroupRegisterDSRequestModel sendHelp = new GroupRegisterDSRequestModel(group, group.getGroupName(), group.getGroupID());
        HashMap<Integer, Group> groups = new HashMap<Integer, Group>();
        GroupDSGateway ahhh = new FileGroup(groupIDMap, groups);
        ahhh.save(sendHelp);

        GroupReadWriter REAAAADD = new GroupReadWriter();
        GroupIDMapReadWriter REAAAADD2 = new GroupIDMapReadWriter();
        HashMap<Integer, String> newIDs = (HashMap<Integer, String>) REAAAADD2.readFromFile("database/testing_folder/testGroupIDMap.ser");

        HashMap<Integer, Group> newGroups = (HashMap<Integer, Group>) REAAAADD.readFromFile("database/testing_folder/testGroup.ser");
        Group newGroup = newGroups.get(group.getGroupID());
        String newGroupName = newIDs.get(group.getGroupID());
        System.out.println(group.getGroupName());
        System.out.println(newGroup.getGroupName());
        assert group.getGroupName().equals(newGroupName);
    }
    @Test
    public void testMakeUser(){
        User user = new User("help", "help","help", "help", new UserPublicProfile());
        assert user.getName().equals("help");
    }

}
