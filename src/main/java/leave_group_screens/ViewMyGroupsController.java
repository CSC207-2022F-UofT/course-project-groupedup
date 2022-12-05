package leave_group_screens;

import view_my_groups_use_case.ViewMyGroupsInputBoundary;
import view_my_groups_use_case.ViewMyGroupsRequestModel;

/**
 * The controller that initiates the view my groups use case.
 */
public class ViewMyGroupsController {
    final ViewMyGroupsInputBoundary userInput;


    public ViewMyGroupsController(ViewMyGroupsInputBoundary userInput) {
        this.userInput = userInput;
    }

    public void viewMyGroups(String username) {
        ViewMyGroupsRequestModel requestModel = new ViewMyGroupsRequestModel(username);

        userInput.getMyGroupsList(requestModel);
    }
}
