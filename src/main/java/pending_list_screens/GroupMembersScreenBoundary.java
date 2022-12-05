package pending_list_screens;

import javax.swing.*;

public interface GroupMembersScreenBoundary {
    void setGroupName(String groupName);

    void setMembersList(JList<String> membersList);

    void setMembersListModel(DefaultListModel<String> membersListModel);

    void setViewGroupMembersController(ViewGroupMembersController viewGroupMembersController);

    void view();
}