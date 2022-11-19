package editpendinglist;

public interface EditPendingListOutputBoundary {
    EditPendingListResponseModel prepareSuccessView(EditPendingListResponseModel success);

    EditPendingListResponseModel prepareFailView(String error);
}
