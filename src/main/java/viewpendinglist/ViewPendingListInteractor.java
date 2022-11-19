package viewpendinglist;

import Entities.Group;
import Entities.User;
import editpendinglist.EditPendingListDsGateway;
import pendinglistscreens.ViewPendingListPresenter;

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
     * @return a list of usernames of the users who've applied to the group
     */
    @Override
    public ViewPendingListResponseModel getUsernamesList(ViewPendingListRequestModel requestModel) {
        String groupName = requestModel.getGroupName();
        Group group = dsGateway.getGroup(groupName);
        HashMap<String, User> userMap = dsGateway.getUserMap();

        ArrayList<String> usernamesList = new ArrayList<>(group.getMemberRequests(userMap).keySet());

        ViewPendingListResponseModel responseModel = new ViewPendingListResponseModel(usernamesList);
        return presenter.prepareSuccessView(responseModel);
    }
}
