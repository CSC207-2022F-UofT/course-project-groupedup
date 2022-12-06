package nonUsecaseTests;

import entities.Group;
import use_cases.group_creation_use_case.NewGroupDSGateway;
import use_cases.group_creation_use_case.GroupRegisterDSRequestModel;

import java.io.*;
import java.util.HashMap;

/**
 * Data access
 */

public class TestGroupSerialize implements NewGroupDSGateway {

    private HashMap<String, Group> groupMap;
    public TestGroupSerialize() throws IOException, ClassNotFoundException {
        OutputStream file = new FileOutputStream("database/testing_folder/testGroup.ser");
        OutputStream buffer = new BufferedOutputStream(file);
        ObjectOutput output = new ObjectOutputStream(buffer);
        output.writeObject(new HashMap<String, Group>());
        output.close();
        buffer.close();
        file.close();
        this.groupMap = this.loadGroups();
    }

    @Override
    public void saveNewGroups(GroupRegisterDSRequestModel groupDSRequestModel){
        OutputStream file = null;
        try {
            file = new FileOutputStream("database/testing_folder/testGroup.ser");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        OutputStream buffer = new BufferedOutputStream(file);
        ObjectOutput output = null;
        try {
            output = new ObjectOutputStream(buffer);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Group newGroup = groupDSRequestModel.getGroup();
        this.groupMap.put(newGroup.getGroupName(), newGroup);
        try {
            output.writeObject(this.groupMap);
            output.close();
            buffer.close();
            file.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public HashMap<String, Group> loadGroups(){
        InputStream file = null;
        try {
            file = new FileInputStream("database/testing_folder/testGroup.ser");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        InputStream buffer = new BufferedInputStream(file);
        ObjectInput input = null;
        try {
            input = new ObjectInputStream(buffer);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        HashMap<String, Group> groups;

        Object ReadFromInput = null;
        try {
            ReadFromInput = input.readObject();
        } catch (ClassNotFoundException | IOException e) {
            throw new RuntimeException(e);
        }
        // check if the file is empty, cannot read a hashmap if file is empty
        if (ReadFromInput.equals("")){
            groups = new HashMap<String, Group>();
        }
        else{
            groups = (HashMap<String, Group>) ReadFromInput;
        }
        try {
            input.close();
            buffer.close();
            file.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return groups;
    }

    @Override
    public boolean groupIdentifierExists(String name) {
        try{
            return this.groupMap.containsKey(name);
        } catch (RuntimeException e){
            throw new RuntimeException(e);
        }
    }

}
