package use_cases.view_my_groups_use_case;

import entities.Group;
import entities.InteractorMessages;
import entities.User;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * The view my groups use case.
 * Allows the user to view all groups they are currently a member or group leader for.
 */
public class ViewMyGroupsInteractor implements ViewMyGroupsInputBoundary {
    final ViewMyGroupsDsGateway dsGateway;
    final ViewMyGroupsOutputBoundary presenter;

    /**
     * @param dsGateway the data access interface
     * @param presenter the output boundary implemented by ViewMyGroupsPresenter
     */
    public ViewMyGroupsInteractor(ViewMyGroupsDsGateway dsGateway, ViewMyGroupsOutputBoundary presenter) {
        this.dsGateway = dsGateway;
        this.presenter = presenter;
    }

    /**
     * @param requestModel the requestModel for the view my groups use case
     */
    @Override
    public void getMyGroupsList(ViewMyGroupsRequestModel requestModel) {
        String username = requestModel.getUsername();

        if (!dsGateway.userIdentifierExists(username)) {
            throw new RuntimeException(InteractorMessages.GROUP_DOES_NOT_EXIST);
        }

        User user = dsGateway.getUser(username);

        ArrayList<String> groupNames = new ArrayList<>(user.getGroups().keySet());

        HashMap<String, Boolean> groupAndStatus = new HashMap<>();

        for (String groupName : groupNames) {
            Group group = dsGateway.getGroup(groupName);
            String groupLeader = group.getGroupLeaderUsername();

            groupAndStatus.put(groupName, (username.equals(groupLeader)));
        }

        ViewMyGroupsResponseModel myGroups = new ViewMyGroupsResponseModel(username, groupAndStatus);

        presenter.prepareSuccessView(myGroups);
    }
}
