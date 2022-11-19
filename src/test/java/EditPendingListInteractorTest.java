import Entities.Group;
import Entities.User;
import editpendinglist.*;
import org.junit.Test;

import java.util.HashMap;

public class EditPendingListInteractorTest {

    @Test
    public void addOrRemoveUser() {
        EditPendingListDsGateway repository = new EditPendingListDsGateway() {
            @Override
            public User getUser(String username) {
                return null;
            }

            @Override
            public Group getGroup(String groupName) {
                return null;
            }

            @Override
            public HashMap<String, User> getUserMap() {
                return null;
            }

            @Override
            public void updateUser(String username) {

            }

            @Override
            public void updateGroup(String groupName) {

            }

            @Override
            public boolean userInGroup(String username, String groupName) {
                return false;
            }

            @Override
            public boolean groupInUser(String groupName, String username) {
                return false;
            }

            @Override
            public boolean userExists(String username) {
                return false;
            }
        };
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
