package use_cases.view_user_applications_use_case;

import entities.InteractorMessages;
import entities.User;

import java.util.ArrayList;

/**
 * The view applications list use case.
 * Allows the user to view all their current applications to groups.
 */
public class ViewApplicationsListInteractor implements ViewApplicationsListInputBoundary {
    final ViewApplicationsListDsGateway dsGateway;
    final ViewApplicationsListOutputBoundary presenter;

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
            throw new RuntimeException(InteractorMessages.USER_DOES_NOT_EXIST);
        }

        User user = dsGateway.getUser(username);

        ArrayList<String> userApplications = new ArrayList<>(user.getApplicationsList().keySet());
        ViewApplicationsListResponseModel applicationsList = new ViewApplicationsListResponseModel(username, userApplications);

        presenter.prepareSuccessView(applicationsList);
    }
}
