package controllers_presenters_and_screen_boundaries.view_group_profile_adapters;

import use_cases.view_group_profile_use_case.ViewGroupProfileInputBoundary;
import use_cases.view_group_profile_use_case.ViewGroupProfileRequestModel;

/**
 * The controller that initiates the view group profile use case.
 */
public class ViewGroupProfileController {
    final ViewGroupProfileInputBoundary userInput;

    public ViewGroupProfileController(ViewGroupProfileInputBoundary userInput) {
        this.userInput = userInput;
    }

    public void viewGroup(String groupName) {
        ViewGroupProfileRequestModel requestModel = new ViewGroupProfileRequestModel(groupName);

        userInput.viewGroup(requestModel);
    }
}
