package view_user_applications_use_case;

import Entities.User;

import java.util.ArrayList;

/**
 * The view applications list use case.
 * Allows the user to view all their current applications to groups.
 */
public class ViewApplicationsListInteractor implements ViewApplicationsListInputBoundary {
    final ViewApplicationsListDsGateway dsGateway;
    final ViewApplicationsListOutputBoundary presenter;
    final ViewApplicationsListErrorMessages errorMessages = new ViewApplicationsListErrorMessages();

    /**
     * @param dsGateway the data access interface
     * @param presenter the output boundary implemented by ViewApplicationsListPresenter
     */
    public ViewApplicationsListInteractor(ViewApplicationsListDsGateway dsGateway,
                                          ViewApplicationsListOutputBoundary presenter) {
        this.dsGateway = dsGateway;
        this.presenter = presenter;
    }

    /**
     * @param requestModel the requestModel for the view user applications list use case
     */
    @Override
    public void getApplicationsList(ViewApplicationsListRequestModel requestModel) {
        String username = requestModel.getUsername();

        if (!dsGateway.userIdentifierExists(username)) {
            throw new RuntimeException(errorMessages.getUserDoesNotExist());
        }

        User user = dsGateway.getUser(username);

        ArrayList<String> userApplications = new ArrayList<>(user.getApplicationsList().keySet());
        ViewApplicationsListResponseModel applicationsList = new ViewApplicationsListResponseModel(username, userApplications);

        presenter.prepareSuccessView(applicationsList);
    }
}
