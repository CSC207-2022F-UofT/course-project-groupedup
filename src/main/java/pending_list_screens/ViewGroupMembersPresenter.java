package pending_list_screens;

import view_group_members.ViewGroupMembersOutputBoundary;
import view_group_members.ViewGroupMembersResponseModel;

import javax.swing.*;
import java.util.ArrayList;

/**
 * The presenter for the view group members use case.
 */

public class ViewGroupMembersPresenter implements ViewGroupMembersOutputBoundary {

    private final GroupMembersScreenBoundary screen;

    public ViewGroupMembersPresenter(GroupMembersScreenBoundary screen) {
        this.screen = screen;
    }
    /**
     * @param groupMembers a response model for view group members that contains the group's name and a list of the
     *                     group's members
     */
    @Override
    public void prepareSuccessView(ViewGroupMembersResponseModel groupMembers) {
        DefaultListModel<String> membersListModel = new DefaultListModel<>();
        ArrayList<String> usernames = groupMembers.getGroupMembers();

        for (String username: usernames) {
            membersListModel.addElement(username);
        }

        JList<String> membersList = new JList<>(membersListModel);

        screen.setGroupName(groupMembers.getGroupName());
        screen.setMembersList(membersList);
        screen.setMembersListModel(membersListModel);
        screen.view();
    }
}
