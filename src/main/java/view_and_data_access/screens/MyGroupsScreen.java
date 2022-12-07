package view_and_data_access.screens;

import controllers_presenters_and_screen_boundaries.edit_group_profile_adapters.EditGroupProfileScreenBoundary;
import controllers_presenters_and_screen_boundaries.leave_and_view_my_groups_adapters.LeaveGroupController;
import controllers_presenters_and_screen_boundaries.leave_and_view_my_groups_adapters.MyGroupsScreenBoundary;
import controllers_presenters_and_screen_boundaries.view_group_profile_adapters.ViewGroupProfileController;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

/**
 * The user's groups list screen.
 */
public class MyGroupsScreen extends JFrame implements MyGroupsScreenBoundary, ListSelectionListener {
    JList<String> myGroups;
    DefaultListModel<String> myGroupsModel;
    LeaveGroupController leaveGroupController;
    ViewGroupProfileController viewGroupProfileController;
    EditGroupProfileScreenBoundary editGroupScreen;
    JButton leaveGroupButton;
    JButton editGroupButton;
    JButton viewGroupButton;
    String username;
    HashMap<String, Boolean> groupAndStatus;
    CardLayout cardLayout;
    JPanel screens;

    /**
     * Initializes an empty groups list for the current user.
     * @param username the username of the current user
     */
    public MyGroupsScreen(CardLayout cardLayout, JPanel screens, String username,
                          EditGroupProfileScreenBoundary editGroupScreen) {
        setSize(400, 500);
        setTitle("My Groups");
        this.cardLayout = cardLayout;
        this.screens = screens;
        this.username = username;
        this.editGroupScreen = editGroupScreen;

        setVisible(false);
    }

    /**
     * Allows user to select a group application.
     * Disables all buttons when there is no selection.
     * Disables leave group button if user is Group Leader.
     * Disables edit group button if user is not Group Leader.
     * @param e the event that characterizes the change
     */
    @Override
    public void valueChanged(ListSelectionEvent e) {
        if (!e.getValueIsAdjusting()) {
            if (myGroups.getSelectedIndex() == -1) {
                leaveGroupButton.setEnabled(false);
                editGroupButton.setEnabled(false);
                viewGroupButton.setEnabled(false);
            } else {
                String groupName = myGroups.getSelectedValue();
                if (groupAndStatus.get(groupName)) {
                    leaveGroupButton.setEnabled(false);
                    editGroupButton.setEnabled(true);
                    viewGroupButton.setEnabled(true);
                } else {
                    leaveGroupButton.setEnabled(true);
                    editGroupButton.setEnabled(false);
                    viewGroupButton.setEnabled(true);
                }
            }
        }
    }
    @Override
    public void setMyGroups(JList<String> myGroups) {
        this.myGroups = myGroups;
    }

    @Override
    public void setMyGroupsModel(DefaultListModel<String> myGroupsModel) {
        this.myGroupsModel = myGroupsModel;
    }

    @Override
    public void setLeaveGroupController(LeaveGroupController leaveGroupController) {
        this.leaveGroupController = leaveGroupController;
    }

    @Override
    public void setViewGroupProfileController(ViewGroupProfileController viewGroupProfileController) {
        this.viewGroupProfileController = viewGroupProfileController;
    }

    @Override
    public void setGroupStatusMapping(HashMap<String, Boolean> groupAndStatus) {
        this.groupAndStatus = groupAndStatus;
    }

    @Override
    public void view() {
        this.buildButtons();
        this.buildScrollPane();
        this.setVisible(true);
    }

    @Override
    public void buildButtons() {
        JPanel buttons = new JPanel();
        buttons.setLayout(new BoxLayout(buttons, BoxLayout.LINE_AXIS));

        this.viewGroupButton = new JButton("View Group");
        this.editGroupButton = new JButton("Edit Group");
        this.leaveGroupButton = new JButton("Leave Group");

        this.viewGroupButton.addActionListener(new buttonPress());
        this.editGroupButton.addActionListener(new buttonPress());
        this.leaveGroupButton.addActionListener(new buttonPress());

        if (this.myGroupsModel.size() == 0) {
            this.viewGroupButton.setEnabled(false);
            this.editGroupButton.setEnabled(false);
            this.leaveGroupButton.setEnabled(false);
        }

        buttons.add(viewGroupButton);
        buttons.add(editGroupButton);
        buttons.add(leaveGroupButton);
        buttons.add(Box.createHorizontalStrut(5));
        buttons.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        this.add(buttons, BorderLayout.PAGE_END);
    }

    @Override
    public void buildScrollPane() {
        JScrollPane applicationsScrollPane = new JScrollPane(myGroups);
        this.add(applicationsScrollPane, BorderLayout.CENTER);
    }

    private class buttonPress implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int index = myGroups.getSelectedIndex();
            String groupName = myGroups.getSelectedValue();

            if (e.getSource() == viewGroupButton) {
                viewGroupProfileController.viewGroup(groupName);
            } else if (e.getSource() == editGroupButton) {
                editGroupScreen.setGroupName(groupName);
                cardLayout.show(screens, "editGroupScreen");
            } else if (e.getSource() == leaveGroupButton) {
                myGroupsModel.remove(index);
                groupAndStatus.remove(groupName);

                int numGroups = myGroupsModel.getSize();

                if (numGroups == 0) {
                    leaveGroupButton.setEnabled(false);
                    editGroupButton.setEnabled(false);
                    viewGroupButton.setEnabled(false);
                } else if (index == numGroups) {
                    index--;
                }

                myGroups.setSelectedIndex(index);
                myGroups.ensureIndexIsVisible(index);
                leaveGroupController.leaveGroup(username, groupName);
            }

        }
    }
}
