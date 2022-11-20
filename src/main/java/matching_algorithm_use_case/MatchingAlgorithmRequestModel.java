package matching_algorithm_use_case;

/**
 * The Matching Algorithm Request Model. Here we store the information we got from the User/screens. For this use case
 * specifically, we only need the current User's username
 */
public class MatchingAlgorithmRequestModel {
    private String username;

    public MatchingAlgorithmRequestModel(String username){
        this.username = username;
    }

    public String getUsername(){
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
