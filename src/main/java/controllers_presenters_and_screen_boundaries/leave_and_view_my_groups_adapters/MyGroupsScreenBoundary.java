package controllers_presenters_and_screen_boundaries.leave_and_view_my_groups_adapters;

import controllers_presenters_and_screen_boundaries.view_group_profile_adapters.ViewGroupProfileController;

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
