package view_and_data_access.screens.group_list_screens;

import interface_adapters.pending_list_adapters.GroupMembersScreenBoundary;
import interface_adapters.pending_list_adapters.ViewGroupMembersController;

import javax.swing.*;
import java.awt.*;

public class GroupMembersScreen extends JFrame implements GroupMembersScreenBoundary {
    JList<String> membersList;
    ViewGroupMembersController viewGroupMembersController;
    DefaultListModel<String> membersListModel;
    String groupName;
    JScrollPane requestsScrollPane = new JScrollPane();

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
        this.requestsScrollPane.setViewportView(membersList);
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
        this.add(requestsScrollPane, BorderLayout.CENTER);
        this.setVisible(true);
    }
}
