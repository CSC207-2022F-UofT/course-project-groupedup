package pending_list_screens;

import Entities.*;
import MultiUsecaseUtil.SerializeDataAccess;
import edit_pending_list.EditPendingListDsGateway;
import edit_pending_list.EditPendingListInputBoundary;
import edit_pending_list.EditPendingListInteractor;
import edit_pending_list.EditPendingListOutputBoundary;
import view_pending_list.ViewPendingListOutputBoundary;
import view_pending_list.ViewPendingListResponseModel;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * The presenter for the view pending list use case.
 */

public class ViewPendingListPresenter implements ViewPendingListOutputBoundary {

    private final PendingListScreenBoundary screen;

    /**
     * @param screen the initial empty pending list screen
     */
    public ViewPendingListPresenter(PendingListScreenBoundary screen) {
        this.screen = screen;
    }

    /**
     * Initializes a JList and DefaultListModel of the list of users in the group's member requests
     * @param usernamesList a response model containing the list of users in the group's member requests
     */
    public void prepareSuccessView(ViewPendingListResponseModel usernamesList) {
        String groupName = usernamesList.getGroupName();

        // Making another fake data access
        String username1 = "sharon";
        String username2 = "aarya";

        User user = new NormalUser(username1, "pw", "Sharon", "sharon@gmail.com",
                new UserPublicProfile());
        User user1 = new NormalUser(username2, "pww", "Aarya", "aarya@gmail.com",
                new UserPublicProfile());
        CurrentUser currentUser = CurrentUser.getInstance();
        User testUser = new NormalUser("testUser", "testUser", "testUser", "testUser",
                new UserPublicProfile());
        currentUser.setUser(testUser);

        Group group = new NormalGroup(groupName);
        group.addRequest(username1);
        group.addRequest(username2);

        user.getApplicationsList().put(groupName, groupName);
        user1.getApplicationsList().put(groupName, groupName);

        HashMap<String, User> userMap = new HashMap<>();
        userMap.put(username1, user);
        userMap.put(username2, user1);

        HashMap<String, Group> groupMap = new HashMap<>();
        groupMap.put(groupName, group);
        EditPendingListDsGateway dsGateway = new PendingListDataAccess(userMap, groupMap);
//        EditPendingListDsGateway dsGateway = new SerializeDataAccess();
        EditPendingListOutputBoundary presenter = new EditPendingListPresenter();
        EditPendingListInputBoundary editPendingListInputBoundary = new EditPendingListInteractor(
                dsGateway, presenter);
        EditPendingListController editPendingListController = new EditPendingListController(
                editPendingListInputBoundary);

        DefaultListModel<String> memberRequestsModel = new DefaultListModel<>();
        ArrayList<String> usernames = usernamesList.getUsernamesList();

        for (String username: usernames) {
            memberRequestsModel.addElement(username);
        }

        JList<String> memberRequests = new JList<>(memberRequestsModel);
        memberRequests.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        memberRequests.setSelectedIndex(0);
        memberRequests.addListSelectionListener(screen);
        memberRequests.setVisibleRowCount(5);

        screen.setMemberRequests(memberRequests);
        screen.setMemberRequestsModel(memberRequestsModel);
        screen.setEditPendingListController(editPendingListController);
        screen.view();
    }

}
