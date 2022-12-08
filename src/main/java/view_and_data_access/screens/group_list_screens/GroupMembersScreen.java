package view_and_data_access.screens.group_list_screens;

import interface_adapters.pending_list_adapters.GroupMembersScreenBoundary;
import interface_adapters.pending_list_adapters.ViewGroupMembersController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GroupMembersScreen extends JPanel implements GroupMembersScreenBoundary {
    JList<String> membersList = new JList<>();
    ViewGroupMembersController viewGroupMembersController;
    DefaultListModel<String> membersListModel = new DefaultListModel<>();
    String groupName;
    JScrollPane requestsScrollPane = new JScrollPane();
    CardLayout cardLayout;
    JPanel screens;
    JButton backToGroupProfile;

    public GroupMembersScreen(CardLayout cardLayout, JPanel screens) {
        this.cardLayout = cardLayout;
        this.screens = screens;
        this.add(new JLabel("Group Members"));
        this.setBackground( new Color(197,180,227));
        setSize(500, 500);
        requestsScrollPane.setSize(50, 50);
        this.add(requestsScrollPane, BorderLayout.CENTER);
        backToGroupProfile = new JButton("Back to Group Profile");
        backToGroupProfile.addActionListener(new buttonPress());
        this.add(backToGroupProfile);

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



    private class buttonPress implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == backToGroupProfile) {
                cardLayout.show(screens,"newGroupPageScreen");
            }

        }
    }
}

