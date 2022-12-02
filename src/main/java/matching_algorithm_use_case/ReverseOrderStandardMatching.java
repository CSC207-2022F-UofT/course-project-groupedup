package matching_algorithm_use_case;

import Entities.Group;
import Entities.User;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This is the standard matching algorithm. Cut the groups that the User is in and that are not in the preferred
 * course codes. Calculate the score using the UserGroupScoreCalculator class and sort from greatest to least.
 * Will return a list of ordered group names with course code.
 */
public class ReverseOrderStandardMatching implements MatchingAlgorithmStrategy {
    private User user;
    private List<Group> groups;
    @Override
    public List<String> match(User user, List<Group> groups) {
        this.user = user;
        this.groups = groups;
        cutByCourseCodeAndMemberList();
        List<UserGroupScoreCalculator> userGroupScoreCalculatorList = new ArrayList<>();
        for (Group g : this.groups) {
            UserGroupScoreCalculator scoreCalculator = new UserGroupScoreCalculator(this.user, g);
            userGroupScoreCalculatorList.add(scoreCalculator);
        }
        userGroupScoreCalculatorList.sort(Collections.reverseOrder());

        List<String> matches = new ArrayList<>(0);
        for (UserGroupScoreCalculator groupScore : userGroupScoreCalculatorList) {
            matches.add(groupScore.toString());
        }
        return matches;
    }

    public void cutByCourseCodeAndMemberList() {
        //String target = user.getUserPublicProfile().getCoursePreferences("Course Code");
        //groups.removeIf(g -> !(target.contains(g.getProfile().getCourseCode())));
        //groups.removeIf(g -> !(g.getGroupMembersUsernames().containsKey(user.getUsername())));
    }
    }

