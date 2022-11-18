package viewpendinglist;

import Entities.Group;
import editpendinglist.PendingListDsGateway;
import pendinglistscreens.ViewPendingListPresenter;

import java.util.ArrayList;

public class ViewPendingListInteractor implements ViewPendingListInputBoundary {

    final PendingListDsGateway dsGateway;
    final ViewPendingListPresenter presenter;

    public ViewPendingListInteractor(PendingListDsGateway dsGateway, ViewPendingListPresenter presenter) {
        this.dsGateway = dsGateway;
        this.presenter = presenter;
    }
    @Override
    public ViewPendingListResponseModel getUsernamesList(ViewPendingListRequestModel requestModel) {
        String groupName = requestModel.getGroupName();
        Group group = dsGateway.getGroup(groupName);
        ArrayList<String> usernamesList = new ArrayList<>(group.getMemberRequests().keySet());
        ViewPendingListResponseModel responseModel = new ViewPendingListResponseModel(usernamesList);
        return presenter.prepareSuccessView(responseModel);
    }
}
