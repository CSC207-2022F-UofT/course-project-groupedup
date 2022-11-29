package pending_list_screens;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GroupMembersScreen extends JFrame {

    JList<String> groupMembers;
    ViewGroupMembersController viewGroupMembersController;
    DefaultListModel<String> groupMembersModel;
    String groupName;

    public GroupMembersScreen(ViewGroupMembersController viewGroupMembersController, String groupName) {

        setTitle("Group Members");
        setSize(300, 300);
        // setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        this.viewGroupMembersController = viewGroupMembersController;
        this.groupName = groupName;

        this.groupMembersModel = new DefaultListModel<>();
        ArrayList<String> usernames = viewGroupMembersController.getGroupMembers(groupName).getGroupMembers();
        for (String username: usernames) {
            groupMembersModel.addElement(username);
        }

        this.groupMembers = new JList<>(groupMembersModel);
        groupMembers.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        groupMembers.setSelectedIndex(0);
        groupMembers.setVisibleRowCount(5);
        JScrollPane requestsScrollPane = new JScrollPane(groupMembers);

        this.add(requestsScrollPane, BorderLayout.CENTER);
        this.revalidate();
        this.repaint();
    }
}
