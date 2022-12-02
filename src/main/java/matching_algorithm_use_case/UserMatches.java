package matching_algorithm_use_case;

import Entities.Group;
import Entities.User;

import java.util.List;

/**
 * General Description:
 * This Class is used to match and update the user's scores. It will not be saved as each time we refresh the screen
 * or press "find groups" we will re-calculate the score. So, hence does not need to be saved or serialized.
 * <p>
 * ATTRIBUTES:
 * user: the current user
 * matches: a list of UserGroupScoreCalculator class instances
 * groups: the groups from the repository
 * <p>
 * METHOD DESCRIPTION:
 * getMatches(): return matches, List<String>
 */
public class UserMatches {
    private User user;

    private List<String> matches;

    private List<Group> groups;

    private MatchingAlgorithmStrategy matchingAlgorithmStrategy;

    /**
     * The purpose of this class is to match the user and groups based on the given Matching Algorithm Strategy
     * @param user : the user being compared
     * @param groups : all the groups in the repo
     * @param matchingAlgorithmStrategy : the chosen strategy
     */
    public UserMatches(User user, List<Group> groups, MatchingAlgorithmStrategy matchingAlgorithmStrategy) {
        this.user = user;
        this.groups = groups;
        this.matchingAlgorithmStrategy = matchingAlgorithmStrategy;
        this.matches = matchingAlgorithmStrategy.match(user, groups);
    }

    /**
     * Access the matches
     * @return the matches as should be presented
     */
    public List<String> getMatches(){
        return this.matches;
    }


}
