package group_creation_use_case;

import Entities.Group;
import Entities.GroupIDMapReadWriter;
import Entities.GroupReadWriter;

import java.io.IOException;
import java.util.HashMap;

public class FileGroup implements GroupDSGateway {
    private HashMap<Integer, String> groupIDMap;
    private HashMap<Integer, Group> groups;

    GroupReadWriter groupReadWriter = new GroupReadWriter();
    GroupIDMapReadWriter groupIDMapReadWriter = new GroupIDMapReadWriter();

    public FileGroup(HashMap<Integer, String> groupIDMap, HashMap<Integer, Group> groups){
        this.groupIDMap = groupIDMap;
        this.groups = groups;
    }

    @Override
    public void save(GroupRegisterDSRequestModel groupRegisterDSRequestModel) {
        try{
            this.groups.put(groupRegisterDSRequestModel.getId(), groupRegisterDSRequestModel.getGroup());
            groupReadWriter.saveToFile("database/group.ser", this.groups);

            this.groupIDMap.put(groupRegisterDSRequestModel.getId(), groupRegisterDSRequestModel.getGroupName());

            groupIDMapReadWriter.saveToFile("database/groupIDMap.ser", this.groupIDMap);
        }catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public boolean existsByIdentifier(String name) {
        return groupIDMap.containsValue(name);
    }
}
