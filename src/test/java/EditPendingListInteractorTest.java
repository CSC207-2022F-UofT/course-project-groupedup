import editpendinglist.*;
import org.junit.Test;

public class EditPendingListInteractorTest {

    @Test
    void addOrRemoveUser() {
        PendingListDsGateway repository = new whatever;
        EditPendingListOutputBoundary presenter = new EditPendingListOutputBoundary() {
            @Override
            public EditPendingListResponseModel prepareSuccessView(EditPendingListResponseModel pendingList) {
                
                return null;
            }

            @Override
            public EditPendingListResponseModel prepareFailView(String error) {
                return null;
            }
        };

        EditPendingListInputBoundary interactor = new EditPendingListInteractor(repository, presenter);
        EditPendingListRequestModel inputData = new EditPendingListRequestModel("sharonh", "csc207",
                true);
        interactor.addOrRemoveUser(inputData);

    }
}
