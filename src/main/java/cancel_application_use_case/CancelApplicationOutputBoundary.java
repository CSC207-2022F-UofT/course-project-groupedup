package cancel_application_use_case;

public interface CancelApplicationOutputBoundary {
    void prepareFailureView(String error);
    void prepareSuccessView(CancelApplicationResponseModel responseModel);
}
