package matching_algorithm_screens;

/**
 * Failed to match screen
 */
public class MatchingAlgorithmFailed extends RuntimeException{
    public MatchingAlgorithmFailed(String error) {
        super(error);
    }
}
