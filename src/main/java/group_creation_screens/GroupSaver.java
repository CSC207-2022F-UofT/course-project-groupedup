package group_creation_screens;

import Entities.Group;
import Entities.Repository;
import Entities.Saver;

public class GroupSaver implements Saver {

    /**
     * Saves this Group to the Repository
     */
    @Override
    public void saveToRepo(Group group) {
        Repository.addGroup(group);
    }
}
