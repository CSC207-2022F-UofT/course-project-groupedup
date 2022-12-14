package interface_adapters.cancel_application_adapters;

import use_cases.cancel_application_use_case.CancelApplicationInputBoundary;
import use_cases.cancel_application_use_case.CancelApplicationRequestModel;

/**
 * The controller that initiates the cancelApplication use case.
 */
public class CancelApplicationController {
    final CancelApplicationInputBoundary userInput;

    public CancelApplicationController(CancelApplicationInputBoundary actionGateway) {
        this.userInput = actionGateway;
    }

    /**
     * @param username the username of the current user
     * @param groupname the groupname of the group the user is cancelling an application for
     */
    public void cancelApplication(String username, String groupname) {
        CancelApplicationRequestModel requestModel = new CancelApplicationRequestModel(username, groupname);

        userInput.cancelApplication(requestModel);
    }
}
