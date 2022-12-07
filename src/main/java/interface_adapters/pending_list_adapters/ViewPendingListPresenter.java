package interface_adapters.pending_list_adapters;

import use_cases.view_pending_list_use_case.ViewPendingListOutputBoundary;
import use_cases.view_pending_list_use_case.ViewPendingListResponseModel;

import javax.swing.*;
import java.util.ArrayList;

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

        screen.setGroupName(usernamesList.getGroupName());
        screen.setMemberRequests(memberRequests);
        screen.setMemberRequestsModel(memberRequestsModel);
        screen.view();
    }

}
