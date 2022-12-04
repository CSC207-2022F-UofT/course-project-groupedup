package matching_algorithm_screens;

import matching_algorithm_use_case.MatchingAlgorithmOutputBoundary;
import matching_algorithm_use_case.MatchingAlgorithmResponseModel;

/**
 * The presenter for the matching algorithm use case
 */
public class MatchesPresenter implements MatchingAlgorithmOutputBoundary {
    MatchingAlgorithmViewModel matchingAlgorithmViewModel;
    public MatchesPresenter(MatchingAlgorithmViewModel matchingAlgorithmViewModel){
        this.matchingAlgorithmViewModel = matchingAlgorithmViewModel;
    }
    @Override
    public void prepareSuccessView(MatchingAlgorithmResponseModel response){
        this.matchingAlgorithmViewModel.displaySuccess(response);
    }

    @Override
    public void prepareFailView(String error) {
        this.matchingAlgorithmViewModel.displayFailure(error);
    }


}
