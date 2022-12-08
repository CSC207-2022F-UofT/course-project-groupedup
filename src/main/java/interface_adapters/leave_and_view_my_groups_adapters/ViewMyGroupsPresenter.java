package interface_adapters.leave_and_view_my_groups_adapters;

import use_cases.view_my_groups_use_case.ViewMyGroupsOutputBoundary;
import use_cases.view_my_groups_use_case.ViewMyGroupsResponseModel;

import javax.swing.*;
import java.util.ArrayList;

/**
 * The presenter class for the view my groups use case.
 */
public class ViewMyGroupsPresenter implements ViewMyGroupsOutputBoundary {
    private final MyGroupsScreenBoundary myGroupsScreen;

    /**
     * @param screen the initial empty groups list screen
     */
    public ViewMyGroupsPresenter(MyGroupsScreenBoundary screen) {
        this.myGroupsScreen = screen;
    }

    @Override
    public void prepareSuccessView(ViewMyGroupsResponseModel groupAndStatus) {
        DefaultListModel<String> myGroupsModel = new DefaultListModel<>();
        ArrayList<String> groupNames = new ArrayList<>(groupAndStatus.getGroupAndStatus().keySet());

        for (String groupName : groupNames) {
            myGroupsModel.addElement(groupName);
        }

        JList<String> myGroups = new JList<>(myGroupsModel);
        myGroups.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        myGroups.setSelectedIndex(-1);
        myGroups.addListSelectionListener(myGroupsScreen);
        if(groupNames.size() == 0) {
            JOptionPane.showMessageDialog(null, "no groups");
        }
        myGroupsScreen.setMyGroups(myGroups);
        myGroupsScreen.setMyGroupsModel(myGroupsModel);
        myGroupsScreen.setGroupStatusMapping(groupAndStatus.getGroupAndStatus());

    }
}
