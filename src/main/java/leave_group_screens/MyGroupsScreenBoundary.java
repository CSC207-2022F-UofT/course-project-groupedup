package leave_group_screens;

import view_group_profile_screens.ViewGroupProfileController;

import javax.swing.*;
import javax.swing.event.ListSelectionListener;
import java.util.HashMap;

/**
 * The interface with methods implemented by the "My Groups" screen.
 */
public interface MyGroupsScreenBoundary extends ListSelectionListener {
    void setMyGroups(JList<String> myGroups);

    void setMyGroupsModel(DefaultListModel<String> myGroupsModel);

    void setLeaveGroupController(LeaveGroupController leaveGroupController);

    void setViewGroupProfileController(ViewGroupProfileController viewGroupProfileController);

    void setGroupStatusMapping(HashMap<String, Boolean> groupAndStatus);

    void view();

    void buildButtons();

    void buildScrollPane();
}
