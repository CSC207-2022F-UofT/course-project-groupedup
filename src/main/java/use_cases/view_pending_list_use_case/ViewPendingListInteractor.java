package use_cases.view_pending_list_use_case;

import entities.Group;
import entities.User;

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
     * Passes a list of users who've applied to the group to the presenter
     * @param requestModel the request model for the view pending list use case
     */
    @Override
    public void getUsernamesList(ViewPendingListRequestModel requestModel) {
        String groupName = requestModel.getGroupName();
        if (!dsGateway.groupIdentifierExists(groupName)) {
            throw new RuntimeException("This group doesn't exist.");
        }
        Group group = dsGateway.getGroup(groupName);
        HashMap<String, User> userMap = dsGateway.loadUsers();

        ArrayList<String> usernamesList = new ArrayList<>(group.getMemberRequests(userMap).keySet());

        ViewPendingListResponseModel responseModel = new ViewPendingListResponseModel(groupName, usernamesList);
        presenter.prepareSuccessView(responseModel);
    }
}
