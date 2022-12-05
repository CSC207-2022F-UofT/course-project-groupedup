package cancel_application_use_case;

/**
 * The output boundary interface for the cancel application use case.
 */
public interface CancelApplicationOutputBoundary {
    void prepareFailureView(String error);
    void prepareSuccessView(CancelApplicationResponseModel responseModel);
}
