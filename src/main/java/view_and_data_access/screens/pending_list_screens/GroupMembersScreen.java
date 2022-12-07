package view_and_data_access.screens.pending_list_screens;

import controllers_presenters_and_screen_boundaries.pending_list_adapters.GroupMembersScreenBoundary;
import controllers_presenters_and_screen_boundaries.pending_list_adapters.ViewGroupMembersController;

import javax.swing.*;
import java.awt.*;

public class GroupMembersScreen extends JFrame implements GroupMembersScreenBoundary {
    JList<String> membersList;
    ViewGroupMembersController viewGroupMembersController;
    DefaultListModel<String> membersListModel;
    String groupName;

    public GroupMembersScreen() {
        setTitle("Group Members");
        setSize(300, 300);
        this.setVisible(false);
    }

    @Override
    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    @Override
    public void setMembersList(JList<String> membersList) {
        this.membersList = membersList;
    }

    @Override
    public void setMembersListModel(DefaultListModel<String> membersListModel) {
        this.membersListModel = membersListModel;
    }

    @Override
    public void setViewGroupMembersController(ViewGroupMembersController viewGroupMembersController) {
        this.viewGroupMembersController = viewGroupMembersController;
    }

    @Override
    public void view() {
        JScrollPane requestsScrollPane = new JScrollPane(membersList);
        this.add(requestsScrollPane, BorderLayout.CENTER);
        this.setVisible(true);
    }
}
