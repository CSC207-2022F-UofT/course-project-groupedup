package matching_algorithm_use_case;

import java.util.List;

/**
 * The response model for the Matching Algorithm Use Case. Assists in storing the responses from the Interactor.
 */
public class MatchingAlgorithmResponseModel {
    String matchesUpdatedMessage;
    List<String> matchesAsStringList;

    public MatchingAlgorithmResponseModel(String matchesUpdatedMessage, List<String> matches){
        this.matchesUpdatedMessage = matchesUpdatedMessage;
        this.matchesAsStringList = matches;
    }

    public String getMatchesUpdatedMessage(){
        return this.matchesUpdatedMessage;
    }
    public List<String> getGroups(){
        return this.matchesAsStringList;
    }

    public void setGroups(List<String> matches){
        this.matchesAsStringList = matches;
    }
}
