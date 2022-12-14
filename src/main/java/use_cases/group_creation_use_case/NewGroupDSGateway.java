package use_cases.group_creation_use_case;

import entities.Group;
import entities.User;

import java.util.HashMap;

/**
 * This is an interface between the database and the interactor.
 * SerializeDataAccess implements this interface to create dependency inversion between
 * the inner layer (interactor) and database (outer layer). It is injected into the
 * group creation interactor.
 */
public interface NewGroupDSGateway{
    /**
     * Saves a group to the database
     * @param groupDSRequestModel
     */
    void saveNewGroups(GroupRegisterDSRequestModel groupDSRequestModel);

    /**
     *
     * @return a hashmap of group objects.
     */
    HashMap<String, Group> loadGroups();

    void updateUser(User user);
    /**
     *
     * @param groupName
     * @return whether the group already exists in the database.
     */
    boolean groupIdentifierExists(String groupName);

}
