package interface_adapters.pending_list_adapters;

import javax.swing.*;
import javax.swing.event.ListSelectionListener;

/**
 * The interface with methods implemented by the pending list screen.
 */

public interface PendingListScreenBoundary extends ListSelectionListener {
    void setGroupName(String groupName);

    void setMemberRequests(JList<String> memberRequestsList);

    void setMemberRequestsModel(DefaultListModel<String> memberRequestsModel);

    void setEditPendingListController(EditPendingListController editPendingListController);

    void setViewPendingListController(ViewPendingListController viewPendingListController);

    void buildButtons();

    void buildScrollPane();
}
