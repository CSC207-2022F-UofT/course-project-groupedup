package CancelApplication;

public interface CancelApplicationPresenter {
    CancelApplicationResponseModel prepareFailureView(String error);
    CancelApplicationResponseModel prepareSuccessView(String message);
}
