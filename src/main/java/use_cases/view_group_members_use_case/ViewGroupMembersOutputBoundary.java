package use_cases.view_group_members_use_case;

/**
 * The output boundary interface for the view group members use case.
 */
public interface ViewGroupMembersOutputBoundary {
    void prepareSuccessView(ViewGroupMembersResponseModel groupMembers);
}
