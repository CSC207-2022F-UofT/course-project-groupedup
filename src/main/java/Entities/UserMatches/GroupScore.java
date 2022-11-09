package Entities.UserMatches;

import Entities.Group;
import Entities.User;
import Entities.UserPublicProfile;

import java.util.HashMap;

/**
 * General Description:
 * This class is used to store the User, Group, and their similarity score
 *
 * ATTRIBUTES:
 * user: the Current User
 * group: the Group being compared
 * score: the similarity score between User and Group calculated using the method calculateSimilarity()
 *
 * METHOD DESCRIPTIONS:
 * compareTo(): compares the score of this and another GroupScore
 *
 * calculateSimilarity(): calculates and returns the similarity score based on the UserPublicProfile preferences
 * of user and the preferences of group
 */

public class GroupScore implements Comparable<GroupScore> {
    private final User user;
    private final Group group;
    private final Double score;

    public GroupScore(User u, Group g){
        this.user = u;
        this.group = g;
        this.score = this.calculateSimilarity();
    }
    public Group getGroup(){
        return this.group;
    }
    public Double getScore(){
        return this.score;
    }

    /**
     *
     * @param other the object to be compared.
     * @return whether this.score is less (-1), greater (1) or equal (0) to o.getScore()
     */
    @Override
    public int compareTo(GroupScore other) {
        if(this.score < other.getScore()){
            return -1;
        }else if(this.score > other.getScore()) {
            return 1;
        }else{
            return 0;
        }
    }
    public Double calculateSimilarity(){
        double count = 0.0;
        double total = 0.0;
        UserPublicProfile u = this.user.getPublicProfile();
        //I need getPreferences for both Users and Groups
        HashMap<String, String> userPref = u.getPreferences();
        HashMap<String, String> groupPref = this.group.getPreferences();
        for (String keyUser: userPref){
            for (String keyGroup: groupPref){
                if (keyUser.equals(keyGroup)){
                    if(userPref[keyUser].equals(groupPref[groupPref])){
                        count += 1;
                    }
                }
                total +=1;
            }
        }
        return count / total;
    }
}



}
