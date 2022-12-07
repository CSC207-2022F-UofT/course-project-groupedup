package use_cases.matching_algorithm_use_case;
/**
 * The Output boundary for between the Use Case and the screens.
 */
public interface MatchingAlgorithmOutputBoundary {

    /**
     * Send the response model (success message and ordered list) to the screens
     * @param responseModel: Update message and ordered List of Groups as Strings
     */
    void prepareSuccessView(MatchingAlgorithmResponseModel responseModel);

    /**
     * Send the error message to the screens through the MatchingAlgorithmResponseModel
     */
    void prepareFailView(String error);
}
