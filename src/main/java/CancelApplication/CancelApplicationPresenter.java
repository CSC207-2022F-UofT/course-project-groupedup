package CancelApplication;

public class CancelApplicationPresenter implements CancelApplicationOutputBoundary {

    @Override
    public CancelApplicationResponseModel prepareFailureView(String error) {
        return null;
    }

    @Override
    public CancelApplicationResponseModel prepareSuccessView(CancelApplicationResponseModel responseModel) {
        return null;
    }
}
