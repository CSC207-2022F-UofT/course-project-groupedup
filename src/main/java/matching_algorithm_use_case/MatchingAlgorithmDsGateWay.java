package matching_algorithm_use_case;

import Entities.Group;
import Entities.User;

import java.util.HashMap;

/**
 * An interface to assist the Interactor with acquiring information for the Matching Algorithm Use Case
 */
public interface MatchingAlgorithmDsGateWay {
    /**
     * Get the respective User entity by username
     * @param username: current User's username
     * @return the respective User
     */
    User loadUser(String username);

    /**
     * Get list of all groups from repo
     * @return List of group entities
     */
    HashMap<String, Group> loadGroups();


}
