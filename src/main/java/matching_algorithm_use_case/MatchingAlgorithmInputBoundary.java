package matching_algorithm_use_case;

public interface MatchingAlgorithmInputBoundary {
    /**
     * Provides the boundary for input required for the Matching Algorithm Use Case
     */
    MatchingAlgorithmResponseModel matchGroups(MatchingAlgorithmRequestModel requestModel);
}
