package matching_algorithm_use_case;

import Entities.Group;
import Entities.User;

import java.util.List;

/**
 * Interface for the Matching Algorithm using Strategy Design just in case we need to implement
 * different matching strategies
 */
public interface MatchingAlgorithmStrategy {
     List<String> match(User user, List<Group> groups);
}
