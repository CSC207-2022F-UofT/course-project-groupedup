package controllers_presenters_and_screen_boundaries.cancel_application_adapters;

import use_cases.view_user_applications_use_case.ViewApplicationsListInputBoundary;
import use_cases.view_user_applications_use_case.ViewApplicationsListRequestModel;

/**
 * The controller that initiates the view applications use case.
 */
public class ViewApplicationsListController {
    final ViewApplicationsListInputBoundary userInput;

    public ViewApplicationsListController(ViewApplicationsListInputBoundary userInput) {
        this.userInput = userInput;
    }

    public void viewApplicationsList(String username) {
        ViewApplicationsListRequestModel requestModel = new ViewApplicationsListRequestModel(username);

        userInput.getApplicationsList(requestModel);
    }

}
