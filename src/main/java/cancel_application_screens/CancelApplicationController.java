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
     * @return the response model created by CancelApplicationPresenter
     */
    CancelApplicationResponseModel cancelApplication(String username, String groupname) {
        CancelApplicationRequestModel requestModel = new CancelApplicationRequestModel(username, groupname);

        return userInput.cancelApplication(requestModel);
    }
}
