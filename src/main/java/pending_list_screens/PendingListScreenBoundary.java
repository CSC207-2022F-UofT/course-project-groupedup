package pending_list_screens;

import javax.swing.*;
import javax.swing.event.ListSelectionListener;

/**
 * The interface with methods implemented by the pending list screen.
 */

public interface PendingListScreenBoundary extends ListSelectionListener {
    void setMemberRequests(JList<String> memberRequestsList);

    void setMemberRequestsModel(DefaultListModel<String> memberRequestsModel);

    void setEditPendingListController(EditPendingListController editPendingListController);

//    void setViewPendingListController(ViewPendingListController viewPendingListController);

    void view();

    void buildButtons();

    void buildScrollPane();
}
