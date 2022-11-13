package Entities.UserMatches;

import Entities.Group;
import Entities.User;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
//This is probably going to have Current User rather than User
/**
 * General Description:
 * This Class is used to match and update the user's scores. It will not be saved as each time we refresh the screen
 * or press "find groups" we will re-calculate the score. So, hence does not need to be saved or serialized.
 *
 * ATTRIBUTES:
 * u: the current user
 * matches: a list of GroupScore class instances
 * groups: the groups from the repository
 *
 * METHOD DESCRIPTIONS:
 * match(): Will parse through the groups, create a GroupScore instance, and add it to matches. As GroupScore has a
 * compareTo() method, we can do this.matches.sort(null) to sort the list.
 *
 * updateMatches(): calls the match() if we want to update the matches before
 *
 * getMatches(): returns the ordered list of Groups without Score
 */
public class UserMatches implements MatchingAlgorithm {
    private User u;
    private List<GroupScore> matches = new ArrayList<>();

    //All the groups in the Repository
    private List<Group> groups;

    public UserMatches(User user, List<Group> groups) {
        this.u = user;
        //Sort the matches
        this.match();
        this.groups = groups;
    }


    //Match the groups and Rank them!
    @Override
    public void match() {

        for (Group g : this.groups) {
            GroupScore gS = new GroupScore(this.u, g);
            this.matches.add(gS);
        }
        Collections.sort(this.matches, Collections.reverseOrder()); //Orders greatest to least
        //this.matches.sort(null);

    }


    public List<Group> getMatches() {
        List<Group> g = new ArrayList<>(0);
        for (GroupScore gS : this.matches) {
            g.add(gS.getGroup());
        }
        return g;
    }

}
