package Screens;

import CancelApplication.CancelApplicationInputBoundary;
import CancelApplication.CancelApplicationRequestModel;
import CancelApplication.CancelApplicationResponseModel;

/**
 * Executes the cancelApplication use case.
 */
public class CancelApplicationController {
    final CancelApplicationInputBoundary userInput;

    public CancelApplicationController(CancelApplicationInputBoundary actionGateway) {
        this.userInput = actionGateway;
    }

    /**
     * @param username the username of the current user
     * @param groupname the groupname of the group the user is cancelling an application for
     * @return the response model for the cancelApplicationPresenter
     */
    CancelApplicationResponseModel cancelApplication(String username, String groupname) {
        CancelApplicationRequestModel requestModel = new CancelApplicationRequestModel(username, groupname);

        return userInput.cancelApplication(requestModel);
    }
}
