package cancel_application_screens;

import view_user_applications_use_case.ViewApplicationsListInputBoundary;
import view_user_applications_use_case.ViewApplicationsListRequestModel;
import view_user_applications_use_case.ViewApplicationsListResponseModel;

/**
 * Executes the view user applications use case.
 */
public class ViewApplicationsListController {
    final ViewApplicationsListInputBoundary userInput;

    public ViewApplicationsListController(ViewApplicationsListInputBoundary userInput) {
        this.userInput = userInput;
    }

    ViewApplicationsListResponseModel viewApplicationsList(String username) {
        ViewApplicationsListRequestModel requestModel = new ViewApplicationsListRequestModel(username);

        return userInput.getApplicationsList(requestModel);
    }

}
