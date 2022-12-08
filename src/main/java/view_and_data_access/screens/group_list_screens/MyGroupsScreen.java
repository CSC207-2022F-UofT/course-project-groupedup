package view_and_data_access.screens.group_list_screens;

import interface_adapters.leave_and_view_my_groups_adapters.LeaveGroupController;
import interface_adapters.leave_and_view_my_groups_adapters.MyGroupsScreenBoundary;
import interface_adapters.view_group_profile_adapters.ViewGroupProfileController;
import view_and_data_access.screens.group_creation_screens.NewGroupPageScreen;

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
public class MyGroupsScreen extends JPanel implements MyGroupsScreenBoundary, ListSelectionListener {
    JList<String> myGroups = new JList<>();
    DefaultListModel<String> myGroupsModel = new DefaultListModel<>();
    LeaveGroupController leaveGroupController;
    ViewGroupProfileController viewGroupProfileController;
    NewGroupPageScreen newGroupPageScreen;
    JButton backToHomePage;
    JButton leaveGroupButton;
    JButton editGroupButton;
    JButton viewGroupButton;
    String username;
    HashMap<String, Boolean> groupAndStatus;
    CardLayout cardLayout;
    JPanel screens;
    JScrollPane scrollPane = new JScrollPane();

    Integer SCREEN_SIZE = 500;

    /**
     * Initializes an empty groups list for the current user.
     * @param username the username of the current user
     */
    public MyGroupsScreen(CardLayout cardLayout, JPanel screens, String username) {
        this.setBackground(new Color(182,202,218));
        this.setSize(500, 500);
        this.add(new JLabel("My Groups"));
        this.cardLayout = cardLayout;
        this.screens = screens;
        this.username = username;
        this.setSize(SCREEN_SIZE, SCREEN_SIZE);
        this.buildButtons();
        this.buildScrollPane();

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
        this.scrollPane.setViewportView(myGroups);
    }

    @Override
    public void setNewGroupPageScreen(NewGroupPageScreen newGroupPageScreen){
        this.newGroupPageScreen = newGroupPageScreen;
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
    public void buildButtons() {
        JPanel buttons = new JPanel();
        buttons.setLayout(new BoxLayout(buttons, BoxLayout.LINE_AXIS));

        this.viewGroupButton = new JButton("View Group");
        this.editGroupButton = new JButton("Edit Group");
        this.leaveGroupButton = new JButton("Leave Group");
        this.backToHomePage = new JButton("Home Page");

        this.viewGroupButton.addActionListener(new buttonPress());
        this.editGroupButton.addActionListener(new buttonPress());
        this.leaveGroupButton.addActionListener(new buttonPress());
        this.backToHomePage.addActionListener(new buttonPress());

        if (this.myGroupsModel.size() == 0) {
            this.viewGroupButton.setEnabled(false);
            this.editGroupButton.setEnabled(false);
            this.leaveGroupButton.setEnabled(false);
        }

        buttons.add(viewGroupButton);
        buttons.add(editGroupButton);
        buttons.add(leaveGroupButton);
        buttons.add(backToHomePage);
        buttons.add(Box.createHorizontalStrut(5));
        buttons.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        this.add(buttons, BorderLayout.PAGE_END);
    }

    @Override
    public void buildScrollPane() {
        scrollPane.setViewportView(myGroups);
        this.add(scrollPane, BorderLayout.CENTER);
    }

    private class buttonPress implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int index = myGroups.getSelectedIndex();
            String groupName = myGroups.getSelectedValue();

            if (e.getSource() == viewGroupButton) {
                viewGroupProfileController.viewGroup(groupName);
                cardLayout.show(screens, "groupProfileScreen");
            } else if (e.getSource() == editGroupButton) {
                newGroupPageScreen.setGroupName(groupName);
                cardLayout.show(screens, "newGroupPageScreen");
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
            } else if (e.getSource() == backToHomePage){
                cardLayout.show(screens, "homepage");
            }

        }
    }
}
