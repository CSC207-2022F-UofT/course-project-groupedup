package MultiUsecaseUtil;

import Entities.Group;
import Entities.User;
import UserRegistrationUsecase.NewUserDSGateway;
import UserRegistrationUsecase.UserRegistrationDSRequestPackage;
import group_creation_use_case.GroupRegisterDSRequestModel;
import group_creation_use_case.NewGroupDSGateway;
import userloginusecase.LoginDSGateway;

import java.io.*;
import java.util.HashMap;

/**
 * Data access for saving and loading from serialized files
 * one data access for the entire program to save memory space in program
 * by only loading the groups/user into a single hashmap rather than loading the
 * information into different classes (example saving new user vs updating current user info)
 * <p>
 * Implements all DSGateways, one gateway per use case
 * all use case DSGateway interface could contain non-implemented loadUsers/loadGroups methods,
 * the data access will function properly should the return types be consistent
 * <p>
 * Used try/catch block to ensure DSGateway interfaces do not need to throw anything
 * so other saving methods that might not require throwing exceptions can be implemented later
 */

public class SerializeDataAccess implements NewGroupDSGateway, NewUserDSGateway, UpdateUserDSGateway, LoginDSGateway {

    /**
     * initialize a new map every time program opens, not elegant :(
     */

    private HashMap<String, Group> groupMap;
    private HashMap<String, User> userMap;
    public SerializeDataAccess(){
        OutputStream file = null;
        OutputStream file2 = null;
        try {
            file = new FileOutputStream("database/group.ser");
            file2 = new FileOutputStream("database/user.ser");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        OutputStream buffer = new BufferedOutputStream(file);
        ObjectOutput output = null;
        OutputStream buffer2 = new BufferedOutputStream(file2);
        ObjectOutput output2 = null;
        try {
            output = new ObjectOutputStream(buffer);
            output2 = new ObjectOutputStream(buffer2);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            output.writeObject(new HashMap<String, Group>());
            output.close();
            buffer.close();
            file.close();
            output2.writeObject(new HashMap<String, User>());
            output2.close();
            buffer2.close();
            file2.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        this.userMap = this.loadUsers();
        this.groupMap = this.loadGroups();
    }

    @Override
    public void saveNewGroups(GroupRegisterDSRequestModel groupDSRequestModel){
        OutputStream file = null;
        try {
            file = new FileOutputStream("database/group.ser");
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
            file = new FileInputStream("database/group.ser");
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
    public boolean groupIdentifierExists(String groupName) {
        try{
            return this.groupMap.containsKey(groupName);
        } catch (RuntimeException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public void saveNewUser(UserRegistrationDSRequestPackage userDSRequestModel){
        OutputStream file = null;
        try {
            file = new FileOutputStream("database/user.ser");
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
        User newUser = userDSRequestModel.getUser();
        this.userMap.put(newUser.getUsername(), newUser);
        try {
            output.writeObject(this.userMap);
            output.close();
            buffer.close();
            file.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public HashMap<String, User> loadUsers(){
        InputStream file = null;
        try {
            file = new FileInputStream("database/user.ser");
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
        HashMap<String, User> users;

        Object ReadFromInput = null;
        try {
            ReadFromInput = input.readObject();
        } catch (ClassNotFoundException | IOException e) {
            throw new RuntimeException(e);
        }
        if (ReadFromInput.equals("")){
            users = new HashMap<String, User>();
        }
        else{
            users = (HashMap<String, User>) ReadFromInput;
        }
        try {
            input.close();
            buffer.close();
            file.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return users;
    }

    @Override
    public boolean userIdentifierExists(String username) {
        try{
            return this.userMap.containsKey(username);
        } catch (RuntimeException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean userIdentifiersMatch(String username, String password) {
        if (!this.userMap.containsKey(username)) { return false; }
        return this.userMap.get(username).getPassword().equals(password);
    }

    @Override
    public User getUser(String username) {
        return this.userMap.get(username);
    }
}
