package matching_algorithm_use_case;

public interface MatchingAlgorithmInputBoundary {
    /**
     * Provides the boundary for the input required for Matching Algorithm Use Case
     */
    MatchingAlgorithmResponseModel matchGroups(MatchingAlgorithmRequestModel requestModel);
}
