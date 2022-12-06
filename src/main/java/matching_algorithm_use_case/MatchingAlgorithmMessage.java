package matching_algorithm_use_case;

/**
 * The messages for the matching algorithm interactor to use.
 */
public class MatchingAlgorithmMessage {
    String matchesUpdated;
    String noMatchesFound;

    public MatchingAlgorithmMessage(){
        matchesUpdated = "Matches Updated!";
        noMatchesFound = "No Matches Found";
    }

    public String getMatchesUpdated(){
        return matchesUpdated;
    }

    public String getNoMatchesFound(){
        return noMatchesFound;
    }
}
