package controllers_presenters_and_screen_boundaries.matching_algorithm_adapters;

import use_cases.matching_algorithm_use_case.MatchingAlgorithmOutputBoundary;
import use_cases.matching_algorithm_use_case.MatchingAlgorithmResponseModel;

/**
 * The presenter for the matching algorithm use case
 */
public class MatchesPresenter implements MatchingAlgorithmOutputBoundary {
    MatchingAlgorithmScreenBoundary matchingAlgorithmScreenBoundary;
    public MatchesPresenter(MatchingAlgorithmScreenBoundary matchingAlgorithmScreenBoundary){
        this.matchingAlgorithmScreenBoundary = matchingAlgorithmScreenBoundary;

    }
    public MatchesPresenter(){};
    @Override
    public void prepareSuccessView(MatchingAlgorithmResponseModel response){
        this.matchingAlgorithmScreenBoundary.displaySuccess(response);
    }

    @Override
    public void prepareFailView(String error) {
        this.matchingAlgorithmScreenBoundary.displayFailure(error);
    }


}
