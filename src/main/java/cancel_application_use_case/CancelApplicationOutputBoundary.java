package cancel_application_use_case;

public interface CancelApplicationOutputBoundary {
    CancelApplicationResponseModel prepareFailureView(String error);
    CancelApplicationResponseModel prepareSuccessView(CancelApplicationResponseModel responseModel);
}
