package matching_algorithm_screens;

import matching_algorithm_use_case.MatchingAlgorithmInputBoundary;
import matching_algorithm_use_case.MatchingAlgorithmRequestModel;

/**
 * Controller for the Matching Algorithm Use Case, calls the interactor
 */
public class MatchingAlgorithmController {
    final MatchingAlgorithmInputBoundary userInput;

    public MatchingAlgorithmController(MatchingAlgorithmInputBoundary inputBoundary){
        this.userInput = inputBoundary;
    }

    public void matchingAlgorithm(String username){
        MatchingAlgorithmRequestModel requestModel = new MatchingAlgorithmRequestModel(username);
        userInput.matchGroups(requestModel);
    }
}
