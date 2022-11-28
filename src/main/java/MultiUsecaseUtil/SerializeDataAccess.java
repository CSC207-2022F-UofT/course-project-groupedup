package MultiUsecaseUtil;

import Entities.Group;
import Entities.User;
import UserRegistrationUsecase.NewUserDSGateway;
import UserRegistrationUsecase.UserRegistrationDSRequestPackage;
import cancel_application_use_case.CancelApplicationDsGateway;
import group_creation_use_case.GroupRegisterDSRequestModel;
import group_creation_use_case.NewGroupDSGateway;
import leave_group_use_case.LeaveGroupDsGateway;

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

public class SerializeDataAccess implements NewGroupDSGateway, NewUserDSGateway, UpdateUserDSGateway,
        CancelApplicationDsGateway, LeaveGroupDsGateway {

    private HashMap<String, Group> groupMap;
    private HashMap<String, User> userMap;
    public SerializeDataAccess() throws IOException, ClassNotFoundException {
        this.groupMap = this.loadGroups();
        this.userMap = this.loadUsers();
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

    // duplicate with sharon's method... will remove and refactor once hers is merged
    @Override
    public User getUser(String username) {
        return userMap.get(username);
    }

    // duplicate with sharon's method... will remove and refactor once hers is merged
    @Override
    public Group getGroup(String groupname) {
        return groupMap.get(groupname);
    }

    @Override
    public void deleteGroup(String groupName) {
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
        // FYI this is the only difference between this and saveNewGroup (put -> remove)
        this.groupMap.remove(groupName);
        try {
            output.writeObject(this.groupMap);
            output.close();
            buffer.close();
            file.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // duplicate with sharon's method... will remove and refactor once hers is merged
    @Override
    public void updateUser(User user) {
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
        String username = user.getUsername();
        // FYI this is the only difference between this and saveNewUser (put -> replace)
        this.userMap.replace(username, user);
        try {
            output.writeObject(this.userMap);
            output.close();
            buffer.close();
            file.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // duplicate with sharon's method... will remove and refactor once hers is merged
    @Override
    public void updateGroup(Group group) {
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
        String groupName = group.getGroupName();
        this.groupMap.replace(groupName, group);
        try {
            output.writeObject(this.groupMap);
            output.close();
            buffer.close();
            file.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // duplicate with sharon's method... will remove and refactor once hers is merged
    @Override
    public boolean userInGroup(String username, String groupName) {
        return false;
    }

    // duplicate with sharon's method... will remove and refactor once hers is merged
    @Override
    public boolean groupInUser(String username, String groupName) {
        return false;
    }

    // duplicate with sharon's method... will remove and refactor once hers is merged
    @Override
    public boolean userInGroupPendingList(String username, String groupName) {
        Group group = groupMap.get(groupName);
        return group.getMemberRequests(userMap).containsKey(username);
    }

    // duplicate with sharon's method... will remove and refactor once hers is merged
    @Override
    public boolean groupInUserApplicationsList(String username, String groupName) {
        User user = userMap.get(username);
        return user.getGroups().containsKey(groupName);
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
}
