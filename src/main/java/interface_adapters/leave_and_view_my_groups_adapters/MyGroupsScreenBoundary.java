package interface_adapters.leave_and_view_my_groups_adapters;

import interface_adapters.view_group_profile_adapters.ViewGroupProfileController;
import view_and_data_access.screens.group_creation_screens.NewGroupPageScreen;

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

    void setNewGroupPageScreen(NewGroupPageScreen newGroupPageScreen);

    void buildButtons();

    void buildScrollPane();
}
