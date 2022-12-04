package view_group_profile_screens;

import view_group_profile_use_case.ViewGroupProfileInputBoundary;
import view_group_profile_use_case.ViewGroupProfileRequestModel;

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
