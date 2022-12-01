package pending_list_screens;

import view_pending_list.ViewPendingListOutputBoundary;
import view_pending_list.ViewPendingListResponseModel;

import javax.swing.*;
import java.util.ArrayList;

/**
 * The presenter for the view pending list use case.
 */

public class ViewPendingListPresenter implements ViewPendingListOutputBoundary {

    PendingListScreenBoundary screen;

    public ViewPendingListPresenter(PendingListScreenBoundary screen) {
        this.screen = screen;
    }

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

        screen.setMemberRequests(memberRequests);
        screen.setMemberRequestsModel(memberRequestsModel);
    }

//    public void setScreen(PendingListScreenBoundary screen) {
//        this.screen = screen;
//    }

//    public PendingListScreenBoundary getScreen() {
//        return screen;
//    }

}
