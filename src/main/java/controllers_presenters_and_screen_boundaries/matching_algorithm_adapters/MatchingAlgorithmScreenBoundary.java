package controllers_presenters_and_screen_boundaries.matching_algorithm_adapters;

import use_cases.matching_algorithm_use_case.MatchingAlgorithmResponseModel;

/**
 * Creates a boundary between presenter and view
 */
public interface MatchingAlgorithmScreenBoundary {
    void displaySuccess(MatchingAlgorithmResponseModel matchingAlgorithmResponseModel);
    void displayFailure(String error);
}
