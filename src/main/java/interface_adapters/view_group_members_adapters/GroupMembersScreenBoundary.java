package interface_adapters.view_group_members_adapters;

import interface_adapters.view_group_members_adapters.ViewGroupMembersController;

import javax.swing.*;

public interface GroupMembersScreenBoundary {
    void setGroupName(String groupName);

    void setMembersList(JList<String> membersList);

    void setMembersListModel(DefaultListModel<String> membersListModel);

    void setViewGroupMembersController(ViewGroupMembersController viewGroupMembersController);

}
