package matching_algorithm_screens;

import use_cases.matching_algorithm_use_case.MatchingAlgorithmResponseModel;

/**
 * Creates a boundary between presenter and view
 */
public interface MatchingAlgorithmViewModel {
    void displaySuccess(MatchingAlgorithmResponseModel matchingAlgorithmResponseModel);
    void displayFailure(String error);
}
