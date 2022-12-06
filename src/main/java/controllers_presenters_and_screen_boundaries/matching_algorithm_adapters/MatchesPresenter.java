package controllers_presenters_and_screen_boundaries.matching_algorithm_adapters;

import matching_algorithm_screens.MatchingAlgorithmViewModel;
import use_cases.matching_algorithm_use_case.MatchingAlgorithmOutputBoundary;
import use_cases.matching_algorithm_use_case.MatchingAlgorithmResponseModel;

/**
 * The presenter for the matching algorithm use case
 */
public class MatchesPresenter implements MatchingAlgorithmOutputBoundary {
    MatchingAlgorithmViewModel matchingAlgorithmViewModel;
    public MatchesPresenter(MatchingAlgorithmViewModel matchingAlgorithmViewModel){
        this.matchingAlgorithmViewModel = matchingAlgorithmViewModel;

    }
    public MatchesPresenter(){};
    @Override
    public void prepareSuccessView(MatchingAlgorithmResponseModel response){
        this.matchingAlgorithmViewModel.displaySuccess(response);
    }

    @Override
    public void prepareFailView(String error) {
        this.matchingAlgorithmViewModel.displayFailure(error);
    }


}
