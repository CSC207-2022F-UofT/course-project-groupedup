package matching_algorithm_screens;

import matching_algorithm_use_case.MatchingAlgorithmResponseModel;

/**
 * Creates a boundary between presenter and view
 */
public interface MatchingAlgorithmViewModel {
    void displaySuccess(MatchingAlgorithmResponseModel matchingAlgorithmResponseModel);
    void displayFailure(String error);
}
