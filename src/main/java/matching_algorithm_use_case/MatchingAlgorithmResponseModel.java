package matching_algorithm_use_case;

import java.util.List;

/**
 * The response model for the Matching Algorithm Use Case. Assists in storing the responses from the Interactor
 */
public class MatchingAlgorithmResponseModel {
    String updateMatchesMessage;
    String username;
    List<String> matchesAsStringList;

    public MatchingAlgorithmResponseModel(String updateMessage, String username, List<String> matches){
        this.updateMatchesMessage = updateMessage;
        this.username = username;
        this.matchesAsStringList = matches;
    }

    public String getUsername(){
        return this.username;
    }

    public String getUpdateMessage() {
        return this.updateMatchesMessage;
    }

    public List<String> getGroups(){
        return this.matchesAsStringList;
    }

    public void setGroups(List<String> matches){
        this.matchesAsStringList = matches;
    }
}
