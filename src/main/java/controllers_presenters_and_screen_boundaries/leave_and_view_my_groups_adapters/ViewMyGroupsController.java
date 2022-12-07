package controllers_presenters_and_screen_boundaries.leave_and_view_my_groups_adapters;

import use_cases.view_my_groups_use_case.ViewMyGroupsInputBoundary;
import use_cases.view_my_groups_use_case.ViewMyGroupsRequestModel;

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
