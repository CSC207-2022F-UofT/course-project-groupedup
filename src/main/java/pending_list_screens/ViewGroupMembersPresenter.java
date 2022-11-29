package pending_list_screens;

import view_group_members.ViewGroupMembersOutputBoundary;
import view_group_members.ViewGroupMembersResponseModel;

public class ViewGroupMembersPresenter implements ViewGroupMembersOutputBoundary {
    @Override
    public ViewGroupMembersResponseModel prepareSuccessView(ViewGroupMembersResponseModel groupMembers) {
        return groupMembers;
    }
}
