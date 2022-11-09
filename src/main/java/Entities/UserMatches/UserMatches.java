package Entities.UserMatches;

import Entities.Group;
import Entities.User;
import Entities.UserPublicProfile;

import java.util.HashMap;
import java.util.List;

public class UserMatches implements MatchingAlgorithm {
    private User u;
    private List<Group> matches;

    private List<Group> groups;

    public UserMatches(User user, List<Group> groups){
        this.u = user;
        this.matches = groups;
        //Sort the matches
        this.match();
        this.groups = groups;
    }


    //Match the groups and Rank them!
    @Override
    public void match() {
        Double scoreSimilarity = 0.0;
        HashMap<Group, Double> scoreSimilarityMap = new HashMap<>();
        for(Group g: this.matches){
            scoreSimilarity = (Double)calculateSimilarity(this.u.getPublicProfile(), g);
            scoreSimilarityMap.put(g, scoreSimilarity);
        }
        SelectionSortMatchGroups ss = new SelectionSortMatchGroups(scoreSimilarityMap);
        //Also I do not understand why List<Group> wont work when for List<Object>...
        ss.sort(this.matches);

    }


    @Override
    public void updateMatches(){this.match();
    }

    public User getUser(){
        return this.u;
    }

    public List<Group> getMatches(){
        return this.matches;
    }

    public void setGroups(List<Group> g){
        this.groups = g;
    }

    public Double calculateSimilarity(UserPublicProfile u, Group g){
        double count = 0.0;
        double total = 0.0;

        //I need getPreferences for both Users and Groups
        HashMap<String, String> userPref = u.getPreferences();
        HashMap<String, String> groupPref = g.getPreferences();
        for (String keyUser: userPref){
            for (String keyGroup: groupPref){
                if (keyUser == keyGroup){
                    if(userPref[keyUser] == groupPref[groupPref]){
                        count += 1;
                    }
                }
                total +=1;
            }
        }
       return count / total;
    }
}

