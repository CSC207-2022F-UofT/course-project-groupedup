package group_creation_use_case;

import Entities.Group;
import Entities.GroupReadWriter;

import java.io.IOException;
import java.util.HashMap;

public class FileGroup implements GroupDSGateway {

    GroupReadWriter groupReadWriter = new GroupReadWriter();

    public FileGroup(){
    }

    /**
     * Saves a Group to the database.
     * @param groupRegisterDSRequestModel the group information to save.
     */
    @Override
    public void save(GroupRegisterDSRequestModel groupRegisterDSRequestModel) {
        try{
            HashMap<String, Group> existingGroups = groupReadWriter.readFromFile("database/group.ser");
            existingGroups.put(groupRegisterDSRequestModel.getGroupName(), groupRegisterDSRequestModel.getGroup());
            groupReadWriter.saveToFile("database/group.ser", existingGroups);
        } catch (IOException | ClassNotFoundException e) {
            // need to do something for these fails?
            throw new RuntimeException(e);
        }

    }

    /**
     *
     * @param groupName The unique groupname identifier.
     * @return whether the Group exists or not.
     */
    @Override
    public boolean existsByIdentifier(String groupName) {
        try{
            HashMap<String, Group> existingGroups = groupReadWriter.readFromFile("database/group.ser");
            return existingGroups.containsKey(groupName);
        } catch (IOException | ClassNotFoundException e){
            throw new RuntimeException(e);
        }
    }
}
