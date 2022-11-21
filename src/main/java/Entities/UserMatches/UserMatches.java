package Entities.UserMatches;

import Entities.Group;
import Entities.User;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * General Description:
 * This Class is used to match and update the user's scores. It will not be saved as each time we refresh the screen
 * or press "find groups" we will re-calculate the score. So, hence does not need to be saved or serialized.
 * <p>
 * ATTRIBUTES:
 * user: the current user
 * matches: a list of GroupScore class instances
 * groups: the groups from the repository
 * <p>
 * METHOD DESCRIPTIONS:
 * match(): Will parse through the groups, create a GroupScore instance, and add it to matches. As GroupScore has a
 * compareTo() method, we can do this.matches.sort(null) to sort the list
 * <p>
 * updateMatches(): calls the match() if we want to update the matches before
 * <p>
 * getMatchesWithScore(): return matches, List<GroupScore>
 * <p>
 * getMatchesWithoutScore(): returns the ordered list of Groups without Score
 * <p>
 * cutByCourseCodeAndMemberList(): Removes all groups that are not a part of the User's preferred course code or if
 * the User is already a part of the group
 */
public class UserMatches implements MatchingAlgorithm {
    private User user;

    private List<GroupScore> matches = new ArrayList<>();

    //All the groups in the Repository
    private List<Group> groups;

    public UserMatches(User user, List<Group> groups) {
        this.user = user;
        this.groups = groups;
        //Narrow down the groups
        cutByCourseCodeAndMemberList();
        //Sort the matches
        match();
    }

    /**
     * Match the groups and rank them!
     */
    @Override
    public void match() {

        for (Group g : this.groups) {
            GroupScore groupScore = new GroupScore(this.user, g);
            this.matches.add(groupScore);
        }
        this.matches.sort(Collections.reverseOrder()); //Orders greatest to least

    }

    /**
     * Get the matches with the score
     * @return an ordered list of GroupScore instances
     */
    public List<GroupScore> getMatchesWithScore(){
        return this.matches;
    }

    /**
     * Get the matches without the score
     * @return ordered list of groups in matches
     */
    public List<Group> getMatchesWithoutScore() {
        List<Group> g = new ArrayList<>(0);
        for (GroupScore gS : this.matches) {
            g.add(gS.getGroup());
        }
        return g;
    }

    /**
     * Removes all groups that are not a part of the User's preferred course code or
     * if the User is already a part of the group
     */
    public void cutByCourseCodeAndMemberList() {
        String target = user.getUserPublicProfile().getCoursePreferences("Course Code");
        groups.removeIf(g -> !(target.contains(g.getGroupProfile().getCourseCode())));
        groups.removeIf(g -> !(g.getGroupMembersUsernames().containsKey(user.getUsername())));
    }
}
