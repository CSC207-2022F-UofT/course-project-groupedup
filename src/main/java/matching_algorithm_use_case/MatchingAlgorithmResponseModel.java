package matching_algorithm_use_case;

import java.util.List;

/**
 * The response model for the Matching Algorithm Use Case. Assists in storing the responses from the Interactor
 */
public class MatchingAlgorithmResponseModel {
    String matchesUpdated;
    List<String> matchesAsStringList;

    public MatchingAlgorithmResponseModel(String matchesUpdated, List<String> matches){
        this.matchesUpdated = matchesUpdated;
        this.matchesAsStringList = matches;
    }

    public String getMatchesUpdated(){
        return this.matchesUpdated;
    }
    public List<String> getGroups(){
        return this.matchesAsStringList;
    }

    public void setGroups(List<String> matches){
        this.matchesAsStringList = matches;
    }
}
