package controllers_presenters_and_screen_boundaries.leave_and_view_my_groups_adapters;

import controllers_presenters_and_screen_boundaries.leave_and_view_my_groups_adapters.MyGroupsScreenBoundary;
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
        myGroups.setSelectedIndex(0);
        myGroups.addListSelectionListener(myGroupsScreen);
        myGroups.setVisibleRowCount(5);

        myGroupsScreen.setMyGroups(myGroups);
        myGroupsScreen.setMyGroupsModel(myGroupsModel);
        myGroupsScreen.setGroupStatusMapping(groupAndStatus.getGroupAndStatus());
        myGroupsScreen.view();
    }
}