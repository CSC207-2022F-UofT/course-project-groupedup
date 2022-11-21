package entities.user_matches;

import entities.Group;
import entities.GroupProfile;
import entities.User;
import entities.UserPublicProfile;

import java.util.HashMap;

/**
 * General Description:
 * This class is used to store the User, Group, and their similarity score
 * <p>
 * ATTRIBUTES:
 * user: the Current User
 * group: the Group being compared
 * score: the similarity score between User and Group
 * <p>
 * METHOD DESCRIPTIONS:
 * compareTo(): compares the score of this and another GroupScore
 * <p>
 * calculateSimilarity(): calculates and returns the similarity score based on the UserPublicProfile preferences
 * of user and the preferences of group
 */

public class GroupScore implements Comparable<GroupScore> {
    private final User user;
    private final Group group;
    private final Double score;

    public GroupScore(User user, Group group){
        this.user = user;
        this.group = group;
        this.score = this.calculateSimilarity();
    }
    public Group getGroup(){
        return this.group;
    }
    public Double getScore(){
        return this.score;
    }

    /**
     * Compares the score of this and another GroupScore
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
    /**
     * calculates and returns the similarity score based on the UserPublicProfile preferences
     * of user and the preferences of group
     * @return the similarity score
     */
    public Double calculateSimilarity(){
        double count = 0.0;
        double total = 0.0;
        UserPublicProfile u = this.user.getUserPublicProfile();
        HashMap<String, String> userPref = u.getPreferences();
        GroupProfile g = this.group.getGroupProfile();

        HashMap<String, String> groupPref = g.getPreferences();
        for (String keyUser: userPref.keySet()){
            for (String keyGroup: groupPref.keySet()){
                if (keyUser.equals(keyGroup)){
                    if(userPref.get(keyUser).equals(groupPref.get(keyGroup))){
                        count += 1;
                    }
                }
                total +=1;
            }
        }
        return count / total;
    }

}




