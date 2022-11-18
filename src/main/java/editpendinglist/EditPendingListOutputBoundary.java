package editpendinglist;

public interface EditPendingListOutputBoundary {
    EditPendingListResponseModel prepareSuccessView(EditPendingListResponseModel pendingList);

    EditPendingListResponseModel prepareFailView(String error);
}
