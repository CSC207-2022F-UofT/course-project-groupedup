package cancel_application_screens;

import cancel_application_use_case.CancelApplicationInputBoundary;
import cancel_application_use_case.CancelApplicationRequestModel;
import cancel_application_use_case.CancelApplicationResponseModel;

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
     */
    void cancelApplication(String username, String groupname) {
        CancelApplicationRequestModel requestModel = new CancelApplicationRequestModel(username, groupname);

        userInput.cancelApplication(requestModel);
    }
}
