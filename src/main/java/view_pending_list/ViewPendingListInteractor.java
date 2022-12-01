package view_pending_list;

import Entities.Group;
import Entities.User;
import pending_list_screens.PendingListScreenBoundary;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * The view pending list use case.
 * Allows the group leader to view their group's current pending member requests.
 */

public class ViewPendingListInteractor implements ViewPendingListInputBoundary {

    final ViewPendingListDsGateway dsGateway;
    final ViewPendingListOutputBoundary presenter;

    /**
     * @param dsGateway the data access interface
     * @param presenter the output boundary implemented by ViewPendingListPresenter
     */
    public ViewPendingListInteractor(ViewPendingListDsGateway dsGateway, ViewPendingListOutputBoundary presenter) {
        this.dsGateway = dsGateway;
        this.presenter = presenter;
    }

    /**
     * @param requestModel the request model for the view pending list use case
     */
    @Override
    public void getUsernamesList(ViewPendingListRequestModel requestModel) {
        String groupName = requestModel.getGroupName();
        Group group = dsGateway.getGroup(groupName);
        HashMap<String, User> userMap = dsGateway.loadUsers();

        ArrayList<String> usernamesList = new ArrayList<>(group.getMemberRequests(userMap).keySet());

        ViewPendingListResponseModel responseModel = new ViewPendingListResponseModel(usernamesList);
        presenter.prepareSuccessView(responseModel);
    }
}
