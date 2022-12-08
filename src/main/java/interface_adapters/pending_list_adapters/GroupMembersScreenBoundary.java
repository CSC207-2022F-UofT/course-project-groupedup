package interface_adapters.pending_list_adapters;

import javax.swing.*;

public interface GroupMembersScreenBoundary {
    void setGroupName(String groupName);

    void setMembersList(JList<String> membersList);

    void setMembersListModel(DefaultListModel<String> membersListModel);

    void setViewGroupMembersController(ViewGroupMembersController viewGroupMembersController);

}
