package Screens;

import CancelApplication.CancelApplicationInputBoundary;
import CancelApplication.CancelApplicationRequestModel;
import CancelApplication.CancelApplicationResponseModel;

public class CancelApplicationController {
    final CancelApplicationInputBoundary userInput;

    public CancelApplicationController(CancelApplicationInputBoundary actionGateway) {
        this.userInput = actionGateway;
    }

    CancelApplicationResponseModel cancelApplication(String username, String groupname) {
        CancelApplicationRequestModel requestModel = new CancelApplicationRequestModel(username, groupname);

        return userInput.cancelApplication(requestModel);
    }
}
