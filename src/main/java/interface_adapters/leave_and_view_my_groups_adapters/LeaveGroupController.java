package interface_adapters.leave_and_view_my_groups_adapters;

import use_cases.leave_group_use_case.LeaveGroupInputBoundary;
import use_cases.leave_group_use_case.LeaveGroupRequestModel;

/**
 * The controller that initiates the leaveGroup use case.
 */
public class LeaveGroupController {
    final LeaveGroupInputBoundary userInput;

    public LeaveGroupController(LeaveGroupInputBoundary userInput) {
        this.userInput = userInput;
    }

    /**
     * @param username the username of the current user
     * @param groupname the groupname of the group the user is leaving
     */
    public void leaveGroup(String username, String groupname) {
        LeaveGroupRequestModel requestModel = new LeaveGroupRequestModel(username, groupname);

        this.userInput.leaveGroup(requestModel);
    }
}
