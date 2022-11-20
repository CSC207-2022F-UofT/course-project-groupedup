package matching_algorithm_use_case;

import java.util.List;

/**
 * The response model for the Matching Algorithm Use Case. Assists in storing the responses from the interactor
 */
public class MatchingAlgorithmResponseModel {
    String updateMatchesMessage;
    List<String> matchesAsStringList;

    public MatchingAlgorithmResponseModel(String updateMessage, List<String> matches){
        this.updateMatchesMessage = updateMessage;
        this.matchesAsStringList = matches;
    }

    public String getUpdateMessage() {
        return updateMatchesMessage;
    }

    public List<String> getGroups(){
        return this.matchesAsStringList;
    }

    public void setGroups(List<String> matches){
        this.matchesAsStringList = matches;
    }
}
