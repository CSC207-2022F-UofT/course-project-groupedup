package group_creation_use_case;

import Entities.Group;

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
    public void saveNewGroups(GroupRegisterDSRequestModel groupDSRequestModel);

    /**
     *
     * @return a hashmap of group objects.
     */
    public HashMap<String, Group> loadGroups();

    /**
     *
     * @param groupName
     * @return whether the group already exists in the database.
     */
    public boolean groupIdentifierExists(String groupName);

}
