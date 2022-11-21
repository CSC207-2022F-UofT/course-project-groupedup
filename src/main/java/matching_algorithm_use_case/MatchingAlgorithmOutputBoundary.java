package matching_algorithm_use_case;
/**
 * The Output boundary for between the Use Case and the screens
 */
public interface MatchingAlgorithmOutputBoundary {

    /**
     * Send the response model (success message and ordered list) to the screens
     * @param responseModel: Update message and ordered List of Groups as Strings
     * @return an instance of the Matching Algorithm response model
     */
    MatchingAlgorithmResponseModel prepareSuccessView(MatchingAlgorithmResponseModel responseModel);

    /**
     * Send the error message to the screens through the MatchingAlgorithmResponseModel
     * @param error: Error message
     * @return error message to be thrown
     */
    MatchingAlgorithmResponseModel prepareFailView(String error);
}
