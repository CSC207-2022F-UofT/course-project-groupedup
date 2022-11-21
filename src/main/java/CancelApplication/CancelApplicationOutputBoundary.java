package CancelApplication;

public interface CancelApplicationOutputBoundary {
    CancelApplicationResponseModel prepareFailureView(String error);
    CancelApplicationResponseModel prepareSuccessView(CancelApplicationResponseModel responseModel);
}
