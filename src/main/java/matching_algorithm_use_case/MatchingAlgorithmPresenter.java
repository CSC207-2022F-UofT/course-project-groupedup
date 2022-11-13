package matching_algorithm_use_case;
/**
 * Description: The presenter for the Matching Algorithm use case
 * <p>
 * Method Descriptions:
 * prepareSuccessView(MatchingAlgorithmResponseModel responseModel) : this method will send the response model (success
 * message and ordered lists) to the screens
 * <p>
 * prepareFailView(String error) : this method will send an error message
 * */
public interface MatchingAlgorithmPresenter {
    MatchingAlgorithmResponseModel prepareSuccessView(MatchingAlgorithmResponseModel responseModel);

    MatchingAlgorithmResponseModel prepareFailView(String error);
}
