package group_creation_screens;


import Entities.Checker;
import Entities.Repository;

public class GroupChecker implements Checker {

    /**
     * Checks whether the Group is already made.
     * @return
     */
    @Override
    public boolean existsByName(String groupName) {

        return Repository.getGroupIDMap().containsKey(groupName);
    }
}
